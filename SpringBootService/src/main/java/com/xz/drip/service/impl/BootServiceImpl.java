package com.xz.drip.service.impl;

import com.xz.drip.dao.PoolDao;
import com.xz.drip.entity.Pool;
import com.xz.drip.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MABIAO on 2017/10/26.
 */
@Service
public class BootServiceImpl implements BootService {

    @Autowired
    private PoolDao poolDao;

    @Override
    public String home() {
        Pool pool = poolDao.selectByPrimaryKey(12l);
        return "haha";
    }
}
