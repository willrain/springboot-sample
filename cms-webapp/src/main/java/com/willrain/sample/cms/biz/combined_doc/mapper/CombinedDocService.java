package com.willrain.sample.cms.biz.combined_doc.mapper;

import com.willrain.sample.cms.biz.combined_doc.dto.CombinedDocEntity;
import com.willrain.sample.cms.biz.combined_doc.dto.CombinedDocModel;
import com.willrain.sample.cms.biz.combined_doc.repository.CombinedDocRepository;
import com.willrain.sample.cms.common.service.BaseServiceImplWithJpa;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CombinedDocService extends BaseServiceImplWithJpa<CombinedDocModel, CombinedDocEntity, String, CombinedDocRepository> {
    public CombinedDocService(CombinedDocRepository combinedDocRepository) {this.repository=combinedDocRepository; }
}
