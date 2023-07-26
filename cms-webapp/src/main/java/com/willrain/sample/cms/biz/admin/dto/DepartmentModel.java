package com.willrain.sample.cms.biz.admin.dto;

import com.willrain.sample.cms.common.dto.BaseModel;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DepartmentModel extends BaseModel{
    private Long deptId;
    private String deptName;
    private final List<AdminModel> adminModelList = new ArrayList<>();

    public DepartmentModel(DepartmentEntity entity) {
        this.deptId = entity.getDeptId();
        this.deptName = entity.getDeptName();
        this.adminModelList.addAll(entity.getAdminEntityList().stream().map(AdminEntity::toModel).toList());
    }

    @Override
    public DepartmentEntity toEntity() { return new DepartmentEntity(this); }
}
