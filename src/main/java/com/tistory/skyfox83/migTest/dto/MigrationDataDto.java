package com.tistory.skyfox83.migTest.dto;

import lombok.Data;

/**
 * 마이그레이션 작업을 하기 위한 기준데이터 테이블에서 조회한 대상을 담기 위한 클래스
 */
/*
create table tcmct_ctrt_info (
	so_id varchar(3),
	inact_dttm varchar(14),
	act_dttm varchar(14),
	ctrt_id varchar(10),
	cust_id varchar(15),
	mvno_cust_id varchar(15),
	reg_id varchar(10),
	reg_dttm datetime,
	chg_id varchar(10),
	chg_dttm datetime
) ;
 */

@Data
public class MigrationDataDto {

    private int soId;
    private String inactDttm;
    private String actDttm;
    private String ctrtId;
    private String custId;
    private String mvnoCustId;
    private String regId;
    private String regDttm;
    private String chgId;
    private String chgDttm;

}
