package com.example.application.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;

import com.example.application.MainLayout;  // Import MainLayout

@Route(value = "", layout = MainLayout.class)  // Use MainLayout as parent
@PageTitle("Home | John Dev")
public class HomeView extends VerticalLayout {

    public HomeView() {
        addClassName("home-view");
        setAlignItems(Alignment.CENTER);
        setSpacing(true);

        // PNG image resource
        StreamResource imageResource = new StreamResource("profile.png", 
            () -> getClass().getResourceAsStream("/META-INF/resources/images/profile.png"));
        
        Image profile = new Image(imageResource, "John Dev");
        profile.addClassName("profile-image");
        profile.setWidth("200px");
        profile.setHeight("200px");
        
        H2 intro = new H2("Full Stack Developer & UI Enthusiast");
        intro.addClassName("hero-text");
        
        add(profile, intro);
    }
}
