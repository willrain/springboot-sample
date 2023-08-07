package com.willrain.sample.cms.biz.doctype;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyModel;
import com.willrain.sample.cms.biz.admin.service.AdminService;
import com.willrain.sample.cms.biz.doctype.service.DoctypeDutyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
class DoctypeDutyServiceTest {

    @Autowired
    private DoctypeDutyService doctypeDutyService;


    @Test
    public void test() {
        if (doctypeDutyService == null) {
            System.out.println("doctypeDutyService is null");
        }
        else {
            System.out.println("doctypeDutyService is not null");
        }
    }


    //@Transactional
    @Test
    public void crudTest() throws Exception {
        DoctypeDutyModel adminModel = new DoctypeDutyModel();
        adminModel.setUserId("willrain1");
        adminModel.setUserName("윤승환");


        // 1. 생성
        log.info("========================= 1.생성 테스트 ");
        adminModel = doctypeDutyService.add(adminModel);
        log.info("# adminModel = {} ", adminModel);
        assertTrue(adminModel != null);

        // 2. 수정
        log.info("========================= 2.수정 테스트 ");
        String modifyMbrName = "윤승환11";
        adminModel.setUserName(modifyMbrName);
        adminModel = doctypeDutyService.modify(adminModel);

        // 3. 상세 조회
        log.info("========================= 3. 상세 조회 테스트 ");
        DoctypeDutyModel detail = doctypeDutyService.getDetail(adminModel.getUserId());

        assertTrue(detail.getUserName().equals(modifyMbrName));

        // 4. 삭제
//        log.info("========================= 4. 삭제 테스트 ");
//        doctypeDutyService.remove(adminModel.getMbrId());
//        try {
//            doctypeDutyService.getDetail(adminModel.getMbrId());
//            assertTrue(false);
//        }
//        catch (BizException e) {
//            log.info(e.getMessage());
//            assertTrue(true);
//        }
    }

}