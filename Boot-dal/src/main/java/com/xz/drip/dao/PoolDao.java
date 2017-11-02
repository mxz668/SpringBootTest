package com.xz.drip.dao;

import com.xz.drip.entity.Pool;

public interface PoolDao {
    int deleteByPrimaryKey(Long id);

    int insert(Pool record);

    int insertSelective(Pool record);

    Pool selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pool record);

    int updateByPrimaryKey(Pool record);
}