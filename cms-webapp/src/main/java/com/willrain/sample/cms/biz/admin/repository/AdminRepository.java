package com.willrain.sample.cms.biz.admin.repository;

import com.willrain.sample.cms.biz.admin.dto.AdminEntity;
import com.willrain.sample.cms.common.dao.BaseRepository;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends BaseRepository<AdminEntity, String> {
    @Query("SELECT u FROM AdminEntity u WHERE 1 = 1 " +
            "and (:deptId is null or u.departmentEntity.deptId = :deptId)" +
            "and (:useYn is null or u.useYn = :useYn)")
    Page<AdminEntity> findByDepartmentEntity_DeptIdAndUseYn(@Param("deptId")Long deptId, @Param("useYn")String useYn, Pageable pageable);
}
