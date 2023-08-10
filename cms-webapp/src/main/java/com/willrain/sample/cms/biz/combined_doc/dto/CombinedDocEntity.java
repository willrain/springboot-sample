package com.willrain.sample.cms.biz.combined_doc.dto;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeEntity;
import com.willrain.sample.cms.common.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity
@Table(name = "COMBINED_DOC")
@ToString
@NoArgsConstructor
public class CombinedDocEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COM_DOC_ID")
    private Long comdocId;

    @Column(name = "DOCTYPE_ID")
    private String doctypeId;

    @ManyToOne
    @JoinColumn(name = "DOCTHYPE_ID")
    private DoctypeEntity doctypeEntity;

    @Column(name = "OPEN_YN")
    private String openYn;

    @Column(name = "DUE_DATE")
    private String dueDate;

    @Column(name = "CREATED_ID")
    private String createdId;

    @Column(name = "UPDATED_ID")
    private String updateId;

    public CombinedDocEntity(CombinedDocModel model) {
        this.comdocId = model.getComdocId();
        this.doctypeId = model.getDoctypeId();
        this.openYn = model.getOpenYn();
        this.dueDate = model.getDueDate();
        this.createdId = model.getCreatedId();
        this.updateId = model.getUpdateId();
        this.createdAt = model.getCreatedAt();
        this.updatedAt = model.getUpdateAt();
    }

    @Override
    public CombinedDocModel toModel() { return new CombinedDocModel(this); }
}
