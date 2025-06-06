package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme("my-vaadin-app")
public class Application implements AppShellConfigurator {
    
    static {
      
        System.setProperty("lit.dev.mode.force", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
