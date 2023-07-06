package com.willrain.sample.cms.biz.board.mapper;

import com.willrain.sample.cms.biz.board.dto.SampleBoardEntity;
import com.willrain.sample.cms.common.dao.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleBoardMapper extends BaseMapper<SampleBoardEntity, Long> {
}
