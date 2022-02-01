package io.h5z.bootolith.apps.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.h5z.bootolith.components.auth.AuthConfiguration;

@SpringBootApplication
@Import({AuthConfiguration.class})
class CustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }

}
