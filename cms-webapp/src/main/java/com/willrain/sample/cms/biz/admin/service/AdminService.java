package com.willrain.sample.cms.biz.admin.service;

import com.willrain.sample.cms.biz.admin.dto.AdminEntity;
import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.biz.admin.repository.AdminRepository;
import com.willrain.sample.cms.common.service.BaseServiceImplWithJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminService extends BaseServiceImplWithJpa<AdminModel, AdminEntity, String, AdminRepository> {
    public AdminService(AdminRepository adminRepository) {
        this.repository = adminRepository;
    }
}
