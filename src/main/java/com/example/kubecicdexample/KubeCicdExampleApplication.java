package com.example.kubecicdexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KubeCicdExampleApplication {

    @Value("${server.type}")
    private String type;

    @Value("${server.version}")
    private String version;

    public static void main(String[] args) {
        SpringApplication.run(KubeCicdExampleApplication.class, args);
    }

    @GetMapping("/")
    public String www() {
        return type + "V:" + version;
    }

}
