package com.example.gtics231lab520201696.Repository;

import com.example.gtics231lab520201696.Entitys.JobHistory;
import com.example.gtics231lab520201696.Entitys.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
}