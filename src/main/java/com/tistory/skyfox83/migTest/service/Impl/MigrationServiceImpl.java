package com.tistory.skyfox83.migTest.service.Impl;

import com.tistory.skyfox83.migTest.dao.IMigrationDataDao;
import com.tistory.skyfox83.migTest.dto.MigrationDataDto;
import com.tistory.skyfox83.migTest.service.IMigrationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigrationServiceImpl implements IMigrationService {

    /* 생성자 주입 */
    private final IMigrationDataDao dao;

    public MigrationServiceImpl(IMigrationDataDao dao) {
        this.dao = dao;
    }
    /* 생성자 주입 */

    @Override
    public List<MigrationDataDto> list() {
        return dao.listDao();
    }
}
