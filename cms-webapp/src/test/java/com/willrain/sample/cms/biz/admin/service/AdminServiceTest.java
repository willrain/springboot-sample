package com.willrain.sample.cms.biz.admin.service;

import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
class AdminServiceTest {

    @Autowired
    private AdminService adminService;


    @Test
    public void test() {
        if (adminService == null) {
            System.out.println("adminService is null");
        }
        else {
            System.out.println("adminService is not null");
        }
    }


    //@Transactional
    @Test
    public void crudTest() throws Exception {
        AdminModel adminModel = new AdminModel();
        adminModel.setMbrId("willrain1");
        adminModel.setMbrName("윤승환");


        // 1. 생성
        log.info("========================= 1.생성 테스트 ");
        adminModel = adminService.add(adminModel);
        log.info("# adminModel = {} ", adminModel);
        assertTrue(adminModel != null);

        // 2. 수정
        log.info("========================= 2.수정 테스트 ");
        String modifyMbrName = "윤승환11";
        adminModel.setMbrName(modifyMbrName);
        adminModel = adminService.modify(adminModel);

        // 3. 상세 조회
        log.info("========================= 3. 상세 조회 테스트 ");
        AdminModel detail = adminService.getDetail(adminModel.getMbrId());

        assertTrue(detail.getMbrName().equals(modifyMbrName));

        // 4. 삭제
//        log.info("========================= 4. 삭제 테스트 ");
//        adminService.remove(adminModel.getMbrId());
//        try {
//            adminService.getDetail(adminModel.getMbrId());
//            assertTrue(false);
//        }
//        catch (BizException e) {
//            log.info(e.getMessage());
//            assertTrue(true);
//        }
    }

}