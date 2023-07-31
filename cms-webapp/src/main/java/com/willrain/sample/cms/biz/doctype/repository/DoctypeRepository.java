package com.willrain.sample.cms.biz.doctype.repository;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeEntity;
import com.willrain.sample.cms.common.dao.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctypeRepository extends BaseRepository<DoctypeEntity, String > {

}
