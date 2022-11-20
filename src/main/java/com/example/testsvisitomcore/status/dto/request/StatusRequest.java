package com.example.testsvisitomcore.status.dto.request;

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
public class StatusRequest {
    private UUID uuid = null;
    private String serialNumber = null;
    private String name = null;
    private Date date = null;
    private Boolean status = null;
}
