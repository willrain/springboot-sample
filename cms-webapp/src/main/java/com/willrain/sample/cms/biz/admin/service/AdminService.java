package com.willrain.sample.cms.biz.admin.service;

import com.willrain.sample.cms.biz.admin.entity.AdminEntity;
import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.biz.admin.repository.AdminRepository;
import com.willrain.sample.cms.common.service.BaseServiceImplWithJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService extends BaseServiceImplWithJpa<AdminModel, AdminEntity, String, AdminRepository> {

    private final AdminRepository adminRepository;
}
