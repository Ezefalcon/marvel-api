package com.openpay.marvelapi.repository;

import com.openpay.marvelapi.model.LogRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRequestRepository extends JpaRepository<LogRequest, Long> {
}
