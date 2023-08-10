package com.willrain.sample.cms.biz.combined_doc.repository;

import com.willrain.sample.cms.biz.combined_doc.dto.CombinedDocEntity;
import com.willrain.sample.cms.common.dao.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinedDocRepository extends BaseRepository<CombinedDocEntity, String> {

}
