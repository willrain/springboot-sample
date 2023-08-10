package com.willrain.sample.cms.biz.combined_doc.dto;

import com.willrain.sample.cms.common.dto.BaseModel;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CombinedDocModel extends BaseModel {
    private Long comdocId;
    private String doctypeId;
    private String openYn;
    private String dueDate;
    private String createdId;
    private String updateId;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public CombinedDocModel(CombinedDocEntity entity) {
        log.debug("# CombinedEntity : {}", entity);
    this.comdocId = entity.getComdocId();
    this.doctypeId = entity.getDoctypeId();
    this.openYn = entity.getOpenYn();
    this.dueDate = entity.getDueDate();
    this.createdId = entity.getCreatedId();
    this.updateId = entity.getUpdateId();
    this.createdAt = entity.getCreatedAt();
    this.updateAt = entity.getUpdatedAt();
    }

    @Override
    public CombinedDocEntity toEntity() { return new CombinedDocEntity(this);}
}
