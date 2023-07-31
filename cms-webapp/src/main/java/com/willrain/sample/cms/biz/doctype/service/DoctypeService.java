package com.willrain.sample.cms.biz.doctype.service;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeEntity;
import com.willrain.sample.cms.biz.doctype.dto.DoctypeModel;
import com.willrain.sample.cms.biz.doctype.repository.DoctypeRepository;
import com.willrain.sample.cms.common.service.BaseServiceImplWithJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DoctypeService extends BaseServiceImplWithJpa<DoctypeModel, DoctypeEntity, String, DoctypeRepository> {

    public DoctypeService(DoctypeRepository doctypeRepository) {
        this.repository = doctypeRepository;
    }


}
