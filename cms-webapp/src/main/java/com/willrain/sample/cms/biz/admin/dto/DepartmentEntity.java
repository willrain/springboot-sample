package com.willrain.sample.cms.biz.admin.dto;

import com.willrain.sample.cms.common.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DEPARTMENT")
@ToString
@NoArgsConstructor
public class DepartmentEntity extends BaseEntity {

    @Id
    @Column(name = "DEPT_ID")
    private Long deptId;
    @Column(name = "DEPT_NAME")
    private String deptName;

    @OneToMany(mappedBy = "departmentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<AdminEntity> adminEntityList = new ArrayList<>();

    public DepartmentEntity(DepartmentModel model) {
        this.deptId = model.getDeptId();
        this.deptName = model.getDeptName();
        this.adminEntityList.addAll(model.getAdminModelList().stream().map(AdminModel::toEntity).toList());
    }

    @Override
    public DepartmentModel toModel() { return new DepartmentModel(this);}
}
