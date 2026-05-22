package com.airtek.CURL.Repository;

import com.airtek.CURL.Entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResponseRepository extends JpaRepository<Response, Long>, JpaSpecificationExecutor {
}
