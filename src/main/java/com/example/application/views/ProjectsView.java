package com.example.application.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

import com.example.application.MainLayout;

@Route(value = "projects", layout = MainLayout.class)
@PageTitle("Projects | John Dev")
public class ProjectsView extends VerticalLayout {

    public ProjectsView() {
        H2 title = new H2("My Projects");
        add(title);
        setAlignItems(Alignment.CENTER);
    }
}
