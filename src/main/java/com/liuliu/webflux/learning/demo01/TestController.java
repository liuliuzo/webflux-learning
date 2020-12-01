package com.liuliu.webflux.learning.demo01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping("persion/getPersion/{id}.json")
    @ResponseBody
    public Person getPersion(@PathVariable("id") String id) {
        log.info("ID:" + id);
        return new Person("1", "leftso", 1, "chongqing");
    }
}

