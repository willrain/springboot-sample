package com.willrain.sample.cms.biz.doctype.service;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyEntity;
import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyModel;
import com.willrain.sample.cms.biz.doctype.mapper.DoctypeDutyMapper;
import com.willrain.sample.cms.common.service.BaseServiceImplWithMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DoctypeDutyService extends BaseServiceImplWithMapper<DoctypeDutyModel, DoctypeDutyEntity, String, DoctypeDutyMapper> {

    public DoctypeDutyService(DoctypeDutyMapper doctypeDutyMapper) {
        this.mapper = doctypeDutyMapper;
    }

}
