package com.example.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.example.application.MainLayout;

@Route(value = "skills", layout = MainLayout.class)
@PageTitle("Skills | John Carter")
public class SkillsView extends VerticalLayout {

    public SkillsView() {
        addClassName("skills-view");
        setSpacing(true);
        setPadding(true);
        
        H2 title = new H2("Technical Skills");
        title.addClassName("section-title");
        
        // Backend Skills
        H3 backendTitle = new H3("Backend Development");
        HorizontalLayout backendSkills = new HorizontalLayout();
        backendSkills.addClassName("skills-row");
        backendSkills.add(
            createSkillBadge("Java", "Expert"),
            createSkillBadge("Spring Boot", "Expert"),
            createSkillBadge("Spring Framework", "Expert"),
            createSkillBadge("Hibernate/JPA", "Advanced"),
            createSkillBadge("Maven/Gradle", "Advanced")
        );
        
        // Frontend Skills
        H3 frontendTitle = new H3("Frontend Development");
        HorizontalLayout frontendSkills = new HorizontalLayout();
        frontendSkills.addClassName("skills-row");
        frontendSkills.add(
            createSkillBadge("React", "Advanced"),
            createSkillBadge("TypeScript", "Advanced"),
            createSkillBadge("JavaScript", "Expert"),
            createSkillBadge("HTML/CSS", "Expert"),
            createSkillBadge("Vaadin", "Advanced")
        );
        
        // Database Skills
        H3 databaseTitle = new H3("Databases");
        HorizontalLayout databaseSkills = new HorizontalLayout();
        databaseSkills.addClassName("skills-row");
        databaseSkills.add(
            createSkillBadge("PostgreSQL", "Expert"),
            createSkillBadge("MySQL", "Advanced"),
            createSkillBadge("MongoDB", "Advanced"),
            createSkillBadge("Redis", "Advanced"),
            createSkillBadge("Elasticsearch", "Intermediate")
        );
        
        // Cloud & DevOps
        H3 cloudTitle = new H3("Cloud & DevOps");
        HorizontalLayout cloudSkills = new HorizontalLayout();
        cloudSkills.addClassName("skills-row");
        cloudSkills.add(
            createSkillBadge("AWS", "Advanced"),
            createSkillBadge("Docker", "Advanced"),
            createSkillBadge("Kubernetes", "Advanced"),
            createSkillBadge("Jenkins", "Advanced"),
            createSkillBadge("Git", "Expert")
        );
        
        add(title, 
            backendTitle, backendSkills,
            frontendTitle, frontendSkills,
            databaseTitle, databaseSkills,
            cloudTitle, cloudSkills);
    }

    private Div createSkillBadge(String skill, String level) {
        Div badge = new Div();
        badge.addClassName("skill-badge");
        badge.addClassName("skill-" + level.toLowerCase());
        
        Span skillName = new Span(skill);
        skillName.addClassName("skill-name");
        
        Span skillLevel = new Span(level);
        skillLevel.addClassName("skill-level");
        
        badge.add(skillName, skillLevel);
        return badge;
    }
}
