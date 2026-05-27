package com.airtek.CURL.Repository;

import com.airtek.CURL.Entity.Backup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackupRepository extends JpaRepository<Backup, Long>, JpaSpecificationExecutor {

}
