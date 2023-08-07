package com.willrain.sample.cms.biz.doctype.service;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyEntity;
import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyModel;
import com.willrain.sample.cms.biz.doctype.mapper.DoctypeDutyMapper;
import com.willrain.sample.cms.common.dto.PageEntity;
import com.willrain.sample.cms.common.service.BaseServiceImplWithMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
public class DoctypeDutyService extends BaseServiceImplWithMapper<DoctypeDutyModel, DoctypeDutyEntity, String, DoctypeDutyMapper> {

    public DoctypeDutyService(DoctypeDutyMapper doctypeDutyMapper) {
        this.mapper = doctypeDutyMapper;
    }


    public PageEntity<DoctypeDutyModel> getListWithConcat(PageEntity<DoctypeDutyModel> param) throws Exception {
        PageEntity<DoctypeDutyEntity> pageEntity = this.toEntity(param);

//        long totalCnt = mapper.totalCnt(pageEntity);
        List<DoctypeDutyEntity> entityList = mapper.selectListWithConcat(pageEntity);
        Stream<DoctypeDutyModel> stream =entityList.stream().map(e -> e.toModel());

        param.setDtoList(stream.toList());
        param.setTotalCnt(param.getDtoList().size());
        return param;
    }

}
