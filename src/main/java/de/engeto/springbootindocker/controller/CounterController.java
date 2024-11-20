package de.engeto.springbootindocker.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CounterController {

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

        counter.increment();

        Thread.sleep((long) (Math.random() * 1000));

        return String.valueOf(counter.count());
    }

}
