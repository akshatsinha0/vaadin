package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import com.example.application.MainLayout;
import com.example.application.components.ParticleBackground;  

@Route(value = "", layout = MainLayout.class)
@PageTitle("Home | John Carter")
public class HomeView extends VerticalLayout {

    public HomeView() {
        addClassName("home-view");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSpacing(true);
        setSizeFull();
        
        
        ParticleBackground particles = new ParticleBackground();
        add(particles);  
        
        
        StreamResource imageResource = new StreamResource("profile.png", 
            () -> getClass().getResourceAsStream("/META-INF/resources/images/profile.png"));
        
        Image profile = new Image(imageResource, "John Carter");
        profile.addClassName("profile-image");
        profile.setWidth("200px");
        profile.setHeight("200px");
        
        
        H1 name = new H1("John Carter");
        name.addClassName("hero-name");
        
        H2 title = new H2("Senior Full-Stack Developer & Cloud Architect");
        title.addClassName("hero-title");
        
        Paragraph description = new Paragraph(
            "Passionate about creating scalable web applications with modern technologies. " +
            "8+ years of experience in Java, Spring Boot, and cloud-native architectures."
        );
        description.addClassName("hero-description");
        
        
        VerticalLayout content = new VerticalLayout(profile, name, title, description);
        content.addClassName("content-overlay");
        content.setAlignItems(Alignment.CENTER);
        
        add(content);
    }
}
