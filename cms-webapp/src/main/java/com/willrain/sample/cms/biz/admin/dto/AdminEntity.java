package com.willrain.sample.cms.biz.admin.dto;

import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.common.dto.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "member")
@ToString
@NoArgsConstructor
public class AdminEntity extends BaseEntity {
    @Id
    @Column(name = "MBR_ID")
    private String mbrId;

    @Column(name = "MBR_NAME")
    private String mbrName;

    public AdminEntity(AdminModel model) {
        this.mbrId = model.getMbrId();
        this.mbrName = model.getMbrName();
        this.createdAt = model.getCreatedAt();
        this.updatedAt = model.getUpdatedAt();
    }

    @Override
    public AdminModel toModel() { return new AdminModel(this);}
}
