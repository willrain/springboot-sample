package com.willrain.sample.cms.biz.doctype.dto;

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
public class DoctypeDutyModel extends BaseModel {
    private String doctypeId;
    private String doctypeName;
    private Long deptId;
    private String deptName;
    private String dutyYn;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String depts;

    public DoctypeDutyModel(DoctypeDutyEntity entity) {
        this.doctypeId = entity.getDoctypeId();
        this.doctypeName = entity.getDoctypeName();
        this.deptId = entity.getDeptId();
        this.dutyYn = entity.getDutyYn();
        this.userId = entity.getUserId();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();

        this.depts = entity.getDepts();
    }

    @Override
    public DoctypeDutyEntity toEntity() { return new DoctypeDutyEntity(this); }
}
