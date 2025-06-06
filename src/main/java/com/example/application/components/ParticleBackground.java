package com.example.application.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;

@Tag("particle-background")
@NpmPackage(value = "three", version = "0.152.2")
@JsModule("./threejs/particles.js")
public class ParticleBackground extends Div {
    public ParticleBackground() {
        addClassName("particle-canvas");
        // getElement().executeJs("window.initParticles($0)", getElement());
    }
}
