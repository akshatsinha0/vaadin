package com.example.application.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

import com.example.application.MainLayout;

@Route(value = "skills", layout = MainLayout.class)
@PageTitle("Skills | John Dev")
public class SkillsView extends VerticalLayout {

    public SkillsView() {
        H2 title = new H2("Technical Skills");
        add(title);
        setAlignItems(Alignment.CENTER);
    }
}
