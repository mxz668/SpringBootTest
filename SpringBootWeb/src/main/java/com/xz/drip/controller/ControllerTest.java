package com.xz.drip.controller;

import com.xz.drip.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MABIAO on 2017/10/25.
 */
@RestController
//@RequestMapping("/testService")
@EnableAutoConfiguration
public class ControllerTest {


    @Autowired
    private BootService testService;

    @RequestMapping("/")
    String home() {
        return testService.home();
    }
}
