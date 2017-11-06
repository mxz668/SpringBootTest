package com.xz.drip.controller;

import com.xz.drip.service.BootService;
import com.xz.drip.service.Thread.ThreadExecutorFactory;
import com.xz.drip.service.vo.PoolVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by MABIAO on 2017/10/25.
 */
@RestController
//@RequestMapping("/testService")
@EnableAutoConfiguration
public class ControllerTest {

    @Resource(name = "ThreadExecutor")
    private ScheduledExecutorService executor;


    @Autowired
    private BootService testService;

    @RequestMapping("/")
    String home() {
        return testService.home();
    }

    @RequestMapping(value = "/insertBySingleThread", method = RequestMethod.POST)
    String insertBySingleThread(@RequestBody PoolVo poolVo) {
        String ret = "su";
        try {
            ret = testService.insertBySingleThread(poolVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    @RequestMapping(value = "/insertByThreads", method = RequestMethod.POST)
    String insertByThreads(@RequestBody final PoolVo poolVo) {
        String ret = "failed";
        try {
            Future<String> ft = executor.submit(new Callable<String>() {
                public String call() {
                    String res = "failed";
                    try {
                        res = testService.insertBySingleThread(poolVo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return res;
                }
            });

            ret = ft.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
}
