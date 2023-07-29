package com.willrain.sample.cms.biz.admin.service;

import com.willrain.sample.cms.biz.admin.dto.AdminEntity;
import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.biz.admin.dto.DepartmentEntity;
import com.willrain.sample.cms.biz.admin.dto.DepartmentModel;
import com.willrain.sample.cms.biz.admin.repository.AdminRepository;
import com.willrain.sample.cms.biz.admin.repository.DepartmentRepository;
import com.willrain.sample.cms.common.dto.PageEntity;
import com.willrain.sample.cms.common.service.BaseServiceImplWithJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
public class AdminService extends BaseServiceImplWithJpa<AdminModel, AdminEntity, String, AdminRepository> {
    private final DepartmentRepository departmentRepository;

    public AdminService(AdminRepository adminRepository, DepartmentRepository departmentRepository) {
        this.repository = adminRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentModel> getDepartmentList() {
        List<DepartmentEntity> list = departmentRepository.findAll();
        return list.stream().map(entity -> entity.toModel()).toList();
    }

    @Transactional
    public PageEntity<AdminModel> getListByDto(PageEntity pageEntity){

        AdminModel searchDto = (AdminModel) pageEntity.getSearchDto();

        Page<AdminEntity> page = repository.findByDepartmentEntity_DeptIdAndUseYn(searchDto.getDeptId(), searchDto.getUseYn(), toPageable(pageEntity));
        Stream<AdminModel> stream = page.getContent().stream()
                .map(entity -> entity.toModel());

        pageEntity.setTotalCnt(page.getTotalElements());
        pageEntity.setDtoList(stream.toList());
        return pageEntity;
    }

//    @Transactional
//    public PageEntity<DepartmentModel> getUserList(PageEntity<DepartmentModel> pageEntity) throws Exception {
//        Page<DepartmentEntity> page = departmentRepository.findAll(toPageable(pageEntity));
//        Stream<DepartmentModel> stream = page.getContent().stream().map(entity -> entity.toModel());
//
//        pageEntity.setTotalCnt(page.getTotalElements());
//        pageEntity.setDtoList(stream.toList());
//        return pageEntity;
    //    }
}
