package com.willrain.sample.cms.biz.admin.repository;

import com.willrain.sample.cms.biz.admin.dto.AdminEntity;
import com.willrain.sample.cms.biz.admin.dto.DepartmentEntity;
import com.willrain.sample.cms.common.dao.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends BaseRepository<DepartmentEntity, String> {
}
