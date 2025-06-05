package com.example.application.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

import com.example.application.MainLayout;

@Route(value = "about", layout = MainLayout.class)
@PageTitle("About | John Dev")
public class AboutView extends VerticalLayout {

    public AboutView() {
        addClassName("about-view");
        
        H2 title = new H2("About Me");
        Paragraph bio = new Paragraph("Passionate developer with 5+ years of experience building web applications.");
        
        add(title, bio);
        setAlignItems(Alignment.CENTER);
        setSpacing(true);
    }
}
