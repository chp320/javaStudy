package com.tistory.skyfox83.migTest.dao;

import com.tistory.skyfox83.migTest.dto.MigrationDataDto;

import java.util.List;

public interface IMigrationDataDao {

    /* get target */
    public List<MigrationDataDto> listDao();
}
