package com.airtek.CURL.Repository;

import com.airtek.CURL.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor {
    Optional<Employee> findOneByDocumentId(String DocumentId);
}
