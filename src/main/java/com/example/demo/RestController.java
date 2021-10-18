package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final Logger log = LogManager.getLogger(RestController.class);

    @GetMapping("*")
    public Map<String, String> test() {
        MDC.put("foo", "bar");

        log.info("mdc context log {}", MDC.getCopyOfContextMap());
        log.info("thread context log {}", ThreadContext.getContext());
        return ThreadContext.getContext();
    }
}
