package org.example;

import io.micrometer.core.instrument.Gauge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
@RestController
@RequestMapping("/api")
public class MyController {
    @Value("${name}")
    private String myName;
    private final Counter myCounter;
    public MyController(MeterRegistry registry) {
        //        List<String> list = new ArrayList<>(4);
        //        list.add("abc");
        //         取得的為NAN，因為回收機制
        MyClass myclass = MyClass.getMyClass();
        Gauge.builder("my_gauge", myclass, myclass::getCount)
            .description("a description of what this gauge does") // 可选
            .register(registry);
        this.myCounter = Counter.builder("my_custom_counter")
                .description("A custom counter metric")
                .register(registry);

    }
    @GetMapping("/hello")
    public String hello() {
        myCounter.increment();
        return "Hello, World: " + myName;
    }
}