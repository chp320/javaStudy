package com.tistory.skyfox83.migTest.service;

import com.tistory.skyfox83.migTest.dto.MigrationDataDto;

import java.util.List;

public interface IMigrationService {

    // 기준 데이터 get
    public List<MigrationDataDto> list();
}
