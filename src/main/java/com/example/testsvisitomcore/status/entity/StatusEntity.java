package com.example.testsvisitomcore.status.entity;

import com.example.testsvisitomcore.status.dto.request.StatusRequest;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statuses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", length = 36, unique = true, updatable = false, nullable = false)
    private String uuid;

    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "status")
    private Boolean status;

    public static StatusEntity toEntity(StatusRequest request) {
        StatusEntityBuilder result = StatusEntity
                .builder()
                .serialNumber(request.getSerialNumber())
                .name(request.getName());

        if (request.getUuid() != null) result.uuid(request.getUuid().toString());

        if (request.getDate() != null) result.date(request.getDate());
        else result.date(new Date());

        if (request.getStatus() != null) result.status(request.getStatus());
        else result.status(false);

        return result.build();
    }

    public static StatusEntity updateEntity(StatusEntity currentEntity, StatusRequest request) {
        if (request.getSerialNumber() != null) currentEntity.setSerialNumber(request.getSerialNumber());
        if (request.getName() != null) currentEntity.setName(request.getName());
        if (request.getDate() != null) currentEntity.setDate(request.getDate());
        if (request.getStatus() != null) currentEntity.setStatus(request.getStatus());
        return currentEntity;
    }
}
