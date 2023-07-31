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
@Table(name = "DOC_TYPE")
@ToString
@NoArgsConstructor
public class DoctypeEntity extends BaseEntity {
    @Id
    @Column(name = "DOCTYPE_ID")
    private String doctypeId;

    @Column(name = "DOCTYPE_NAME")
    private String doctypeName;

    @Column(name = "SAMPLE_FILE_URI")
    private String sampleFileUri;

    @Column(name = "DOCTYPE_NOTE")
    private String doctypeNote;

    @Column(name = "DOCTYPE_CYCLE")
    private String doctypeCycle;

    @Column(name = "ACTIVE_YN")
    private String activeYn;

    @Column(name = "CREATED_ID")
    private String createdId;

    public DoctypeEntity(DoctypeModel model) {
        this.doctypeId = model.getDoctypeId();
        this.doctypeName = model.getDoctypeName();
        this.sampleFileUri = model.getSampleFileUri();
        this.doctypeNote = model.getDoctypeNote();
        this.doctypeCycle = model.getDoctypeCycle();
        this.activeYn = model.getActiveYn();
        this.createdId = model.getCreatedId();
        this.createdAt = model.getCreatedAt();
        this.updatedAt = model.getUpdatedAt();
    }

    @Override
    public DoctypeModel toModel() { return new DoctypeModel(this); }
}
