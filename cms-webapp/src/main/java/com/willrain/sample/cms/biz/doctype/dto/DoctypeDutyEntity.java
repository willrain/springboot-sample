package com.willrain.sample.cms.biz.doctype.dto;

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
@Table(name="DOCTYPE_DUTY")
@ToString
@NoArgsConstructor
public class DoctypeDutyEntity extends BaseEntity {
    @Id
    @Column(name = "DOCTYPE_ID")
    private String doctypeId;

    @Id
    @Column(name = "DEPT_ID")
    private Long deptId;

    @Column(name = "DUTY_YN")
    private String dutyYn;

    @Column(name = "USER_ID")
    private String userId;

    public DoctypeDutyEntity(DoctypeDutyModel model) {
        this.doctypeId = model.getDoctypeId();
        this.deptId = model.getDeptId();
        this.dutyYn = model.getDutyYn();
        this.userId = model.getUserId();
    }

    @Override
    public DoctypeDutyModel toModel() { return new DoctypeDutyModel(this); }
}
