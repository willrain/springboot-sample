package com.willrain.sample.cms.biz.admin.repository;

import com.willrain.sample.cms.biz.admin.entity.AdminEntity;
import com.willrain.sample.cms.common.dao.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseRepository<AdminEntity, String> {
}
