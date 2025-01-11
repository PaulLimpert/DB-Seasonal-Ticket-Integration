package com.convinestudios.db.semesterticket.integration.model.external.response;

import com.google.gson.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FahrplanResponseMapper {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                    context.serialize(src.format(formatter)))
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                    LocalDateTime.parse(json.getAsString(), formatter))
            .create();

        /**
         * Converts a FahrplanResponse Object into its String-Representation
         *
         * @param response the FahrplanResponse object that the method has to convert
         * @return the String-Representation of the given FahrplanResponse object
         */
        public static String stringRep(FahrplanResponse response){
            return gson.toJson(response);
        }

        /**
         * Maps a given JSON String to an FahrplanResponse Object if Possible
         *
         * @param response the response in JSON Format
         * @return the mapped object from the given response, returns null if the response is in invalid format
         */
        public static FahrplanResponse mapFromJson(String response){
        try {
            return gson.fromJson(response, FahrplanResponse.class);
        } catch (JsonSyntaxException e) {
            System.err.println("JSON in incorrect format: " + e.getMessage());
            return null;
        }
    }
}
