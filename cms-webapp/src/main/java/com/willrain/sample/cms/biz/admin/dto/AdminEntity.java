package com.willrain.sample.cms.biz.admin.dto;

import com.willrain.sample.cms.common.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@Entity
@Table(name = "USER")
@ToString
@NoArgsConstructor
public class AdminEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private String userId;

//    JoinColumn의 name은 USER 테이블의 DEPT_ID,
//    referencedColumnNmae은 DEPARTMENT 테이블의 DEPT_ID 생략 가능
//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")
    private DepartmentEntity departmentEntity;

    @Formula("(SELECT d.DEPT_NAME FROM DEPARTMENT d WHERE d.DEPT_ID = DEPT_ID)")
    private String deptName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "AUTHOR_CD")
    private String authorCd;

    @Column(name = "USE_YN")
    private String useYn;

    public AdminEntity(AdminModel model) {
        this.userId = model.getUserId();
        this.userName = model.getUserName();
//        this.deptId = model.getDeptId();
        this.deptName = model.getDeptName();
        this.authorCd = model.getAuthorCd();
        this.useYn = model.getUseYn();
        this.createdAt = model.getCreatedAt();
        this.updatedAt = model.getUpdatedAt();
    }

    @Override
    public AdminModel toModel() { return new AdminModel(this);}
}
