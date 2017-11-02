package com.xz.drip.service;

import com.xz.drip.service.vo.PoolVo;

/**
 * Created by MABIAO on 2017/10/26.
 */
public interface BootService {

    String home();

    String insertBySingleThread(PoolVo poolVo) throws Exception;
}
