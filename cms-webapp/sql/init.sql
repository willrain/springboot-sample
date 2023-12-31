CREATE TABLE `SAMPLE_BOARD` (
    `BOARD_NO` bigint(20) NOT NULL AUTO_INCREMENT,
    `BOARD_NAME` varchar(50) NOT NULL,
    `OWNER_ID` varchar(50) NOT NULL,
    `CREATED_AT` datetime NOT NULL DEFAULT current_timestamp(),
    `UPDATED_AT` datetime DEFAULT NULL,
    PRIMARY KEY (`BOARD_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;


-- 사용자 관리
CREATE TABLE USER (
    USER_ID VARCHAR(20) NOT NULL COMMENT '사용자ID',
    USER_NAME VARCHAR(20) NOT NULL COMMENT '사용자명',
    DEPT_ID BIGINT(20) NULL COMMENT '부서아이디',
    AUTHOR_CD CHAR(1) NOT NULL DEFAULT 'U' COMMENT 'A: 시스템관리 Q: 취합자U: 일반 입력자 - 수동관리',
    USE_YN CHAR(1) NOT NULL DEFAULT 'N' COMMENT '사용여부',
    CREATED_AT DATETIME NOT NULL DEFAULT current_timestamp(),
    UPDATED_AT DATETIME DEFAULT NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (USER_ID)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- 부서 관리
CREATE TABLE DEPARTMENT (
    DEPT_ID BIGINT(20) NOT NULL COMMENT '부서아이디',
    DEPT_NM VARCHAR(50) NOT NULL COMMENT '부서명',
--     MANAGER_ID VARCHAR(20) NULL COMMENT '입력담당자ID',
    CREATED_AT DATETIME NOT NULL DEFAULT current_timestamp(),
    UPDATED_AT DATETIME DEFAULT NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (DEPT_ID)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- 문서 서식
CREATE TABLE DOC_TYPE (
    DOCTYPE_ID	varchar(20)	NOT NULL,
    DOCTYPE_NAME	varchar(50)	NOT NULL	COMMENT '문서 종류의 명 (예: 주간보고서)',
    SAMPLE_FILE_URI	varchar(300)	NULL	COMMENT '파일 절대경로 위치',
    DOCTYPE_NOTE	varchar(1000)	NULL,
    DOCTYPE_CYCLE	varchar(10)	NOT NULL	DEFAULT 'W'	COMMENT '주(W), 월(M), 분기(Q), 반기(H), 년(Y) - 변경불가',
    ACTIVE_YN	char(1)	NOT NULL	DEFAULT 'Y'	COMMENT '취합문서  종류 사용 여부',
    CREATED_ID	varchar(22)	NOT NULL,
    CREATED_AT	datetime	NOT NULL	DEFAULT current_timestamp(),
    UPDATED_AT datetime NULL,
    PRIMARY KEY (DOCTYPE_ID)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- 입력자 지정 (취합 문서 종류 마다 모든 부서가 존재해야함)
CREATE TABLE DOCTYPE_DUTY (
    DOCTYPE_ID	varchar(20)	NOT NULL,
    DEPT_ID	varchar(20)	NOT NULL,
    DUTY_YN	varchar(1)	NOT NULL	DEFAULT 'Y'	COMMENT '미 작성 "N"',
    USER_ID	varchar(22)	NOT NULL,
    CREATED_AT	datetime	NOT NULL	DEFAULT current_timestamp(),
    UPDATED_AT datetime NULL,
    PRIMARY KEY (DOCTYPE_ID, DEPT_ID)
)ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;