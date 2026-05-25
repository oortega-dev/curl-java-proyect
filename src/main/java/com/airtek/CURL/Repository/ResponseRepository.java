package com.airtek.CURL.Repository;

import com.airtek.CURL.Entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long>, JpaSpecificationExecutor {

    @Query("SELECT r FROM Response r WHERE r.request.id = :requestId ORDER BY r.created DESC")
    List<Response> findResponsesByRequestId(@Param("requestId") Long requestId);
}
