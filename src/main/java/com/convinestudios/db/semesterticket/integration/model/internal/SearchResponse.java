package com.convinestudios.db.semesterticket.integration.model.internal;

import com.convinestudios.db.semesterticket.integration.model.ConnectionModel;
import java.time.LocalDateTime;
import java.util.List;

public record SearchResponse(LocalDateTime requestAt,
                             LocalDateTime responseAt,
                             List<ConnectionModel> connections) {
}
