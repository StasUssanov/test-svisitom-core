package com.example.testsvisitomcore.status.repository;

import com.example.testsvisitomcore.status.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, String> {
}
