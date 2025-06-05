package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")  // Root path
public class MainView extends VerticalLayout {

    public MainView() {
        H1 header = new H1("Welcome to Vaadin!");
        header.addClassName("main-header");
        
        Button clickMe = new Button("Click Me", e -> {
            header.setText("Button Clicked!");
        });
        
        add(header, clickMe);
        setAlignItems(Alignment.CENTER);
        setSpacing(true);
    }
}
