package com.example.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.example.application.MainLayout;

@Route(value = "projects", layout = MainLayout.class)
@PageTitle("Projects | John Carter")
public class ProjectsView extends VerticalLayout {

    public ProjectsView() {
        addClassName("projects-view");
        setSpacing(true);
        setPadding(true);
        
        H2 title = new H2("Featured Projects");
        title.addClassName("section-title");
        
        VerticalLayout projectsContainer = new VerticalLayout();
        projectsContainer.addClassName("projects-container");
        
        projectsContainer.add(
            createProjectCard(
                "E-Commerce Microservices Platform",
                "Java, Spring Boot, React, PostgreSQL, Redis, AWS",
                "Built a scalable e-commerce platform handling 1M+ daily transactions. " +
                "Implemented microservices architecture with event-driven communication. " +
                "Features include real-time inventory management, payment processing, and analytics dashboard."
            ),
            createProjectCard(
                "Real-Time Analytics Dashboard",
                "React, TypeScript, Node.js, MongoDB, Socket.io",
                "Developed a comprehensive analytics dashboard for business intelligence. " +
                "Real-time data visualization with interactive charts and customizable widgets. " +
                "Supports multiple data sources and automated report generation."
            ),
            createProjectCard(
                "Cloud-Native CMS",
                "Java 17, Spring Cloud, Vue.js, MySQL, Docker, Kubernetes",
                "Created a content management system deployed on Kubernetes. " +
                "Features multi-tenancy, role-based access control, and automated scaling. " +
                "Integrated with CDN for optimal content delivery worldwide."
            )
        );
        
        add(title, projectsContainer);
    }

    private Div createProjectCard(String name, String technologies, String description) {
        Div card = new Div();
        card.addClassName("project-card");
        
        H3 projectName = new H3(name);
        projectName.addClassName("project-name");
        
        Paragraph techStack = new Paragraph("Technologies: " + technologies);
        techStack.addClassName("tech-stack");
        
        Paragraph projectDescription = new Paragraph(description);
        projectDescription.addClassName("project-description");
        
        card.add(projectName, techStack, projectDescription);
        return card;
    }
}
