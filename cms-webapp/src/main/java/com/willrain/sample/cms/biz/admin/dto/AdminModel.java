package com.willrain.sample.cms.biz.admin.dto;

import com.willrain.sample.cms.common.dto.BaseModel;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminModel extends BaseModel {
    private String userId;
    private String userName;
    private Long deptId;
    private String deptName;
    private String authorCd;
    private String useYn;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public AdminModel(AdminEntity entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.deptId = entity.getDepartmentEntity().getDeptId();
        this.deptName = entity.getDeptName();
        this.authorCd = entity.getAuthorCd();
        this.useYn = entity.getUseYn();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public AdminEntity toEntity() {return new AdminEntity(this);}
}
