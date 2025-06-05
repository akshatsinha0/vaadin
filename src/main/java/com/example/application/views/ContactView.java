package com.example.application.views;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.example.application.MainLayout;

@Route(value = "contact", layout = MainLayout.class)
@PageTitle("Contact | John Carter")
public class ContactView extends VerticalLayout {

    public ContactView() {
        addClassName("contact-view");
        setSpacing(true);
        setPadding(true);
        setAlignItems(Alignment.CENTER);
        
        H2 title = new H2("Get In Touch");
        title.addClassName("section-title");
        
        Paragraph intro = new Paragraph(
            "I'm always interested in new opportunities and collaborations. " +
            "Feel free to reach out if you'd like to discuss a project or just connect!"
        );
        intro.addClassName("contact-intro");
        
        // Contact Information
        VerticalLayout contactInfo = new VerticalLayout();
        contactInfo.addClassName("contact-info");
        contactInfo.setSpacing(true);
        
        contactInfo.add(
            createContactItem(VaadinIcon.ENVELOPE, "Email", "john.carter@email.com", "mailto:john.carter@email.com"),
            createContactItem(VaadinIcon.PHONE, "Phone", "+1 (555) 123-4567", "tel:+15551234567"),
            createContactItem(VaadinIcon.LOCATION_ARROW, "Location", "San Francisco, CA", null),
            createContactItem(VaadinIcon.GLOBE, "LinkedIn", "linkedin.com/in/johncarter", "https://linkedin.com/in/johncarter"),
            createContactItem(VaadinIcon.CODE, "GitHub", "github.com/johncarter", "https://github.com/johncarter")
        );
        
        add(title, intro, contactInfo);
    }

    private HorizontalLayout createContactItem(VaadinIcon icon, String label, String value, String link) {
        HorizontalLayout item = new HorizontalLayout();
        item.addClassName("contact-item");
        item.setSpacing(true);
        item.setAlignItems(Alignment.CENTER);
        
        Div iconDiv = new Div(icon.create());
        iconDiv.addClassName("contact-icon");
        
        H3 labelText = new H3(label + ":");
        labelText.addClassName("contact-label");
        
        if (link != null) {
            Anchor linkElement = new Anchor(link, value);
            linkElement.addClassName("contact-link");
            item.add(iconDiv, labelText, linkElement);
        } else {
            Paragraph valueText = new Paragraph(value);
            valueText.addClassName("contact-value");
            item.add(iconDiv, labelText, valueText);
        }
        
        return item;
    }
}
