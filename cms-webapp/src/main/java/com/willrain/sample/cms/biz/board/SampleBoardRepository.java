package com.willrain.sample.cms.biz.board;

import com.willrain.sample.cms.biz.board.dto.SampleBoardEntity;
import com.willrain.sample.cms.common.dao.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleBoardRepository extends BaseRepository<SampleBoardEntity, Long> {

}
