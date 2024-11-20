package de.engeto.springbootindocker.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
public class CounterController {

//    private static final Logger log = LoggerFactory.getLogger("jsonLogger");

    private final Counter counter;
    //
    private final MeterRegistry meterRegistry;

    public CounterController(MeterRegistry registry) {
        this.counter = registry.counter("custom.counter");
        this.meterRegistry = registry;
    }

    @GetMapping("increment")
    @Timed(value = "custom_counter_request", description = "Doba trvani custom HTTP request")
    public String makeIncrementation() throws InterruptedException {

        log.trace("It is trace");
        log.debug("It is debug");
        log.info("It is info");
        log.warn("It is warning");
        log.error("It is error");

        counter.increment();

        Thread.sleep((long) (Math.random() * 1000));

        return String.valueOf(counter.count());
    }

}
