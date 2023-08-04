package com.willrain.sample.cms.biz.doctype.mapper;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyEntity;
import com.willrain.sample.cms.common.dao.BaseMapper;
import com.willrain.sample.cms.common.dto.PageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctypeDutyMapper extends BaseMapper<DoctypeDutyEntity, String> {

    List<DoctypeDutyEntity> selectListWithConcat(PageEntity<DoctypeDutyEntity> pageEntity);
}
