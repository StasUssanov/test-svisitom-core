package com.example.testsvisitomcore.status.dto.response;

import com.example.testsvisitomcore.status.entity.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusResponse {
    private UUID uuid = null;
    private String serialNumber = null;
    private String name = null;
    private Date date = null;
    private Boolean status = null;

    public static StatusResponse toResponse(StatusEntity entity) {
        return new StatusResponse(
                UUID.fromString(entity.getUuid()),
                entity.getSerialNumber(),
                entity.getName(),
                entity.getDate(),
                entity.getStatus()
        );
    }
}
