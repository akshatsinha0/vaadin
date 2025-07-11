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
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.checkbox.Checkbox;

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

        // Custom dark/light mode toggle switch
        Checkbox themeSwitch = new Checkbox();
        themeSwitch.getElement().setAttribute("aria-label", "Toggle dark mode");
        themeSwitch.addClassName("theme-toggle-switch");
        themeSwitch.setValue(isDarkMode());

        Div slider = new Div();
        slider.addClassName("theme-toggle-slider");

        // Moon icon (SVG)
        Span moon = new Span();
        moon.addClassName("icon");
        moon.addClassName("moon");
        moon.getElement().setProperty("innerHTML", "<svg width='16' height='16' viewBox='0 0 24 24' fill='black'><path d='M21 12.79A9 9 0 0111.21 3a7 7 0 100 14 9 9 0 009.79-4.21z'/></svg>");

        // Sun icon (SVG)
        Span sun = new Span();
        sun.addClassName("icon");
        sun.addClassName("sun");
        sun.getElement().setProperty("innerHTML", "<svg width='16' height='16' viewBox='0 0 24 24' fill='yellow'><circle cx='12' cy='12' r='5'/><g><line x1='12' y1='1' x2='12' y2='3'/><line x1='12' y1='21' x2='12' y2='23'/><line x1='4.22' y1='4.22' x2='5.64' y2='5.64'/><line x1='18.36' y1='18.36' x2='19.78' y2='19.78'/><line x1='1' y1='12' x2='3' y2='12'/><line x1='21' y1='12' x2='23' y2='12'/><line x1='4.22' y1='19.78' x2='5.64' y2='18.36'/><line x1='18.36' y1='5.64' x2='19.78' y2='4.22'/></g></svg>");

        slider.add(moon, sun);
        themeSwitch.getElement().appendChild(slider.getElement());

        themeSwitch.addValueChangeListener(e -> toggleTheme());

        DrawerToggle toggle = new DrawerToggle();

        HorizontalLayout headerLayout = new HorizontalLayout(toggle, title, themeSwitch);
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

    private boolean isDarkMode() {
        ThemeList themeList = UI.getCurrent().getElement().getThemeList();
        return themeList.contains(Lumo.DARK);
    }
}
