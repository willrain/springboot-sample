package com.willrain.sample.cms.biz.board;

import com.willrain.sample.cms.biz.admin.service.AdminService;
import com.willrain.sample.cms.biz.board.dto.SampleBoardModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
class SampleBoardServiceWithMapperTest {

    @Autowired
    private SampleBoardServiceWithMapper sampleBoardService;
    //@Transactional
    @Test
    public void crudTest() throws Exception {
        SampleBoardModel sampleBoard = new SampleBoardModel();
        sampleBoard.setBoardName("테스트보드");
        sampleBoard.setOwnerId("willrain");
        


        // 1. 생성
        log.info("========================= 1.생성 테스트 ");
        sampleBoard = sampleBoardService.add(sampleBoard);
        log.info("# sampleBoard = {} ", sampleBoard);
        assertTrue(sampleBoard != null);

//        // 2. 수정
//        log.info("========================= 2.수정 테스트 ");
//        String modifyMbrName = "윤승환11";
//        sampleBoard.setUserName(modifyMbrName);
//        sampleBoard = sampleBoardService.modify(sampleBoard);
//
//        // 3. 상세 조회
//        log.info("========================= 3. 상세 조회 테스트 ");
//        SampleBoardModel detail = sampleBoardService.getDetail(sampleBoard.getUserId());
//
//        assertTrue(detail.getUserName().equals(modifyMbrName));

        // 4. 삭제
//        log.info("========================= 4. 삭제 테스트 ");
//        sampleBoardService.remove(sampleBoard.getMbrId());
//        try {
//            sampleBoardService.getDetail(sampleBoard.getMbrId());
//            assertTrue(false);
//        }
//        catch (BizException e) {
//            log.info(e.getMessage());
//            assertTrue(true);
//        }
    }
}