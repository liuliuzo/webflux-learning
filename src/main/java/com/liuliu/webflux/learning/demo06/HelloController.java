package com.liuliu.webflux.learning.demo06;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello/")
public class HelloController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/common")
    public String commonHandle() {
        String uuid = UUID.randomUUID().toString();
        log.info("common-start"+":"+uuid);
        // 执行耗时操作
        String result = doThing("common handler"+":"+uuid);
        log.info("common-end"+":"+uuid);
        return result;
    }

    @GetMapping("/mono")
    public Mono<String> monoHandle() {
        String uuid = UUID.randomUUID().toString();
        log.info("mono-start"+":"+uuid);
        // 执行耗时操作
        Mono<String> mono = Mono.fromSupplier(() -> doThing("mono handle"+":"+uuid));
        log.info("mono-end"+":"+uuid);
        // Mono表示包含0或1个元素的异步序列
        return mono;
    }

    // 定义耗时操作
    private String doThing(String msg) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
