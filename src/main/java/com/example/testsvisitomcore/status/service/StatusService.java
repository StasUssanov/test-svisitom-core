package com.example.testsvisitomcore.status.service;

import com.example.testsvisitomcore.status.dto.request.StatusRequest;
import com.example.testsvisitomcore.status.dto.response.StatusResponse;
import com.example.testsvisitomcore.status.entity.StatusEntity;
import com.example.testsvisitomcore.status.exception.StatusNameBusyException;
import com.example.testsvisitomcore.status.exception.StatusNotFoundException;
import com.example.testsvisitomcore.status.exception.StatusSerialNumberBusyException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService extends StatusBaseService {

    protected void checkException(DataIntegrityViolationException error) throws Exception {
        String message = error.getMostSpecificCause().getMessage();
        String constName = this.parseErrorMessage("unique constraint \"", message, "uc_statuses_");

        switch (constName) {
            case "serial_number" -> throw new StatusSerialNumberBusyException();
            case "name" -> throw new StatusNameBusyException();
            default -> throw new Exception(error.getMessage());
        }
    }

    public StatusResponse createStatus(StatusRequest status) throws Exception {
        try {
            StatusEntity entity = StatusEntity.toEntity(status);
            return StatusResponse.toResponse(statusRepository.save(entity));
        } catch (DataIntegrityViolationException error) {
            this.checkException(error);
            throw new Exception(error.getMessage());
        }
    }

    public List<StatusResponse> getStatuses() {
        List<StatusEntity> entities = statusRepository.findAll(Sort.by(Sort.Direction.ASC, "serialNumber"));
        List<StatusResponse> result = new ArrayList<>();
        entities.forEach(entity -> result.add(StatusResponse.toResponse(entity)));
        return result;
    }

    public StatusResponse updateStatus(StatusRequest status) throws Exception {
        Optional<StatusEntity> current = statusRepository.findById(status.getUuid().toString());
        if (current.isPresent()) {
            try {
                return StatusResponse.toResponse(statusRepository.save(
                        StatusEntity.updateEntity(current.get(), status)
                ));
            } catch (DataIntegrityViolationException error) {
                this.checkException(error);
                throw new Exception(error.getMessage());
            }
        } else {
            throw new StatusNotFoundException();
        }
    }

    @Transactional
    public List<StatusResponse> updateStatuses(List<StatusRequest> statuses) {
        List<StatusResponse> result = new ArrayList<>();

        statuses.forEach(status -> {
            Optional<StatusEntity> current = statusRepository.findById(status.getUuid().toString());

            current.ifPresent(entity -> {
                entity.setStatus(status.getStatus());
                result.add(StatusResponse.toResponse(statusRepository.save(entity)));
            });
        });

        return result;
    }
}
