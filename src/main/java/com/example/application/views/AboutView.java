package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.example.application.MainLayout;

@Route(value = "about", layout = MainLayout.class)
@PageTitle("About | John Carter")
public class AboutView extends VerticalLayout {

    public AboutView() {
        addClassName("about-view");
        setSpacing(true);
        setPadding(true);
        
        // Professional Summary
        H2 summaryTitle = new H2("Professional Summary");
        summaryTitle.addClassName("section-title");
        
        Paragraph summary = new Paragraph(
            "Experienced Senior Full-Stack Developer with 8+ years in enterprise software development. " +
            "Specialized in Java ecosystem, cloud-native architectures, and modern web technologies. " +
            "Proven track record of leading teams and delivering scalable solutions for Fortune 500 companies. " +
            "AWS Certified Solutions Architect with expertise in microservices, DevOps, and agile methodologies."
        );
        summary.addClassName("summary-text");
        
        // Experience Timeline
        H2 experienceTitle = new H2("Professional Experience");
        experienceTitle.addClassName("section-title");
        
        VerticalLayout experience = new VerticalLayout();
        experience.addClassName("timeline");
        experience.add(
            createTimelineEntry(
                "Tech Innovators Inc", 
                "Lead Full-Stack Developer", 
                "2020 - Present",
                "Led a team of 8 developers in building microservices architecture. " +
                "Implemented CI/CD pipelines reducing deployment time by 60%. " +
                "Technologies: Java 17, Spring Boot, React, AWS, Docker, Kubernetes."
            ),
            createTimelineEntry(
                "Cloud Solutions Corp", 
                "Senior Java Developer", 
                "2017 - 2020",
                "Developed and maintained enterprise-level applications serving 10M+ users. " +
                "Optimized database queries improving performance by 40%. " +
                "Technologies: Java 11, Spring Framework, Angular, PostgreSQL, Redis."
            ),
            createTimelineEntry(
                "Digital Dynamics Ltd", 
                "Full-Stack Developer", 
                "2015 - 2017",
                "Built responsive web applications and RESTful APIs. " +
                "Collaborated with UX/UI teams to implement user-friendly interfaces. " +
                "Technologies: Java 8, Spring MVC, JavaScript, MySQL, Git."
            )
        );
        
        add(summaryTitle, summary, experienceTitle, experience);
    }

    private Component createTimelineEntry(String company, String role, String duration, String description) {
        Div timelineItem = new Div();
        timelineItem.addClassName("timeline-entry");
        
        Span dateSpan = new Span(duration);
        dateSpan.addClassName("timeline-date");
        
        H3 companyTitle = new H3(company);
        companyTitle.addClassName("company-name");
        
        Paragraph roleText = new Paragraph(role);
        roleText.addClassName("role-title");
        
        Paragraph descText = new Paragraph(description);
        descText.addClassName("role-description");
        
        VerticalLayout contentLayout = new VerticalLayout(companyTitle, roleText, descText);
        contentLayout.setSpacing(false);
        contentLayout.setPadding(false);
        
        HorizontalLayout entryLayout = new HorizontalLayout(dateSpan, contentLayout);
        entryLayout.setSpacing(true);
        entryLayout.setAlignItems(Alignment.START);
        
        timelineItem.add(entryLayout);
        return timelineItem;
    }
}
