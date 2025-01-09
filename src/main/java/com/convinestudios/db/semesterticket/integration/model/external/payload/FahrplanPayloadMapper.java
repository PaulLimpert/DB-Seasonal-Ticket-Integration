package com.convinestudios.db.semesterticket.integration.model.external.payload;
import com.google.gson.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FahrplanPayloadMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                    context.serialize(src.format(formatter)))
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                    LocalDateTime.parse(json.getAsString(), formatter))
            .create();

    /**
     * Converts a FahrplanPayload Object into its String-Representation
     *
     * @param payload the FahrplanPayload object that the method has to convert
     * @return the String-Representation of the given FahrplanPayload object
     */
    public static String stringRep(FahrplanPayload payload){
        return gson.toJson(payload);
    }

    /**
     * Maps a given JSON String to an FahrplanPayload Object if Possible
     *
     * @param payload the payload in JSON Format
     * @return the mapped object from the given payload, returns null if the payload is in invalid format
     */
    public static FahrplanPayload mapFromJson(String payload){
        try {
            return gson.fromJson(payload, FahrplanPayload.class);
        } catch (JsonSyntaxException e) {
            System.err.println("JSON in incorrect format: " + e.getMessage());
            return null;
        }
    }
}
