package com.willrain.sample.cms.biz.doctype.dto;

import com.willrain.sample.cms.common.dto.BaseModel;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DoctypeModel extends BaseModel {
    private String doctypeId;
    private String doctypeName;
    private String sampleFileUri;
    private String doctypeNote;
    private String doctypeCycle;
    private String activeYn;
    private String createdId;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    private MultipartFile uploadFile;

    public DoctypeModel(DoctypeEntity entity) {
        this.doctypeId = entity.getDoctypeId();
        this.doctypeName = entity.getDoctypeName();
        this.sampleFileUri = entity.getSampleFileUri();
        this.doctypeNote = entity.getDoctypeNote();
        this.doctypeCycle = entity.getDoctypeCycle();
        this.activeYn = entity.getActiveYn();
        this.createdId = entity.getCreatedId();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public DoctypeEntity toEntity() { return new DoctypeEntity(this); }
}
