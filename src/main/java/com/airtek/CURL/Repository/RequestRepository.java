package com.airtek.CURL.Repository;

import com.airtek.CURL.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor {

    @Query("SELECT r FROM Request r " +
    "WHERE (:documentId IS NULL OR r.employee.documentId = :documentId)")
    List<Request> findRequestsByEmployeeDocumentId(@Param("documentId") String documentId);
}
