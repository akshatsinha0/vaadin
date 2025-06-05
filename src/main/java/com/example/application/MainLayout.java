package com.example.application;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;

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
        H1 title = new H1("John Dev Portfolio");
        title.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.MEDIUM);
        
        DrawerToggle toggle = new DrawerToggle();
        
        Header header = new Header(toggle, title);
        header.addClassName("main-header");
        addToNavbar(header);
    }

    private void createDrawer() {
        SideNav nav = new SideNav();
        
        // Correct SideNavItem constructor: (label, navigationTarget, icon)
        nav.addItem(new SideNavItem("Home", HomeView.class, VaadinIcon.HOME.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, VaadinIcon.USER.create()));
        nav.addItem(new SideNavItem("Projects", ProjectsView.class, VaadinIcon.CODE.create()));
        nav.addItem(new SideNavItem("Skills", SkillsView.class, VaadinIcon.CHECK.create()));
        nav.addItem(new SideNavItem("Contact", ContactView.class, VaadinIcon.ENVELOPE.create()));
        
        Scroller scroller = new Scroller(nav);
        addToDrawer(scroller);
    }
}
