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
    private String mbrId;
    private String mbrName;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public AdminModel(AdminEntity entity) {
        this.mbrId = entity.getMbrId();
        this.mbrName = entity.getMbrName();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public AdminEntity toEntity() {return new AdminEntity(this);}
}
