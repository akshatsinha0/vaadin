package com.example.application.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

import com.example.application.MainLayout;

@Route(value = "contact", layout = MainLayout.class)
@PageTitle("Contact | John Dev")
public class ContactView extends VerticalLayout {

    public ContactView() {
        H2 title = new H2("Contact Me");
        add(title);
        setAlignItems(Alignment.CENTER);
    }
}
