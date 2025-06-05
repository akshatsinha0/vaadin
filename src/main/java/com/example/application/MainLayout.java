package com.example.application;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;

import com.example.application.views.HomeView;
import com.example.application.views.AboutView;
import com.example.application.views.ProjectsView;
import com.example.application.views.SkillsView;
import com.example.application.views.ContactView;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 title = new H1("John Carter - Portfolio");
        title.getStyle()
            .set("margin", "0 auto")
            .set("color", "var(--lumo-primary-text-color)")
            .set("font-size", "1.5rem");
        
        Button themeToggle = new Button(VaadinIcon.ADJUST.create());
        themeToggle.addClickListener(e -> toggleTheme());
        themeToggle.addClassName("theme-toggle");
        
        DrawerToggle toggle = new DrawerToggle();
        
        HorizontalLayout headerLayout = new HorizontalLayout(toggle, title, themeToggle);
        headerLayout.setWidthFull();
        headerLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        headerLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        headerLayout.addClassName("main-header");
        
        Header header = new Header(headerLayout);
        addToNavbar(header);
    }

    private void createDrawer() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Home", HomeView.class, VaadinIcon.HOME.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, VaadinIcon.USER.create()));
        nav.addItem(new SideNavItem("Projects", ProjectsView.class, VaadinIcon.CODE.create()));
        nav.addItem(new SideNavItem("Skills", SkillsView.class, VaadinIcon.CHECK.create()));
        nav.addItem(new SideNavItem("Contact", ContactView.class, VaadinIcon.ENVELOPE.create()));
        
        Scroller scroller = new Scroller(nav);
        addToDrawer(scroller);
    }

    private void toggleTheme() {
        ThemeList themeList = UI.getCurrent().getElement().getThemeList();
        if (themeList.contains(Lumo.DARK)) {
            themeList.remove(Lumo.DARK);
        } else {
            themeList.add(Lumo.DARK);
        }
    }
}
