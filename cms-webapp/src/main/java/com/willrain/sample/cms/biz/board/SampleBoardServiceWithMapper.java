package com.willrain.sample.cms.biz.board;

import com.willrain.sample.cms.biz.board.dto.SampleBoardEntity;
import com.willrain.sample.cms.biz.board.dto.SampleBoardModel;
import com.willrain.sample.cms.biz.board.mapper.SampleBoardMapper;
import com.willrain.sample.cms.common.code.ResultCode;
import com.willrain.sample.cms.common.exception.BizException;
import com.willrain.sample.cms.common.service.BaseServiceImplWithMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleBoardServiceWithMapper
        extends BaseServiceImplWithMapper<SampleBoardModel, SampleBoardEntity, Long, SampleBoardMapper> {

    public SampleBoardServiceWithMapper(SampleBoardMapper sampleBoardMapper) {
        this.mapper = sampleBoardMapper;
    }


    @Override
    public void remove(Long pk) throws Exception {
        throw new BizException(ResultCode.NOT_SUPPORTED);
    }
}
