package com.awesomecontrols.menubar;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag("menu-bar-overlay")
@StyleSheet("frontend://bower_components/menubar/cards.css")
@HtmlImport("bower_components/menubar/menu-bar-overlay.html")
class MenuBarOverlay extends PolymerTemplate<TemplateModel>  {
    private final static Logger LOGGER = Logger.getLogger(MenuBarOverlay.class .getName());
    static {
        if (LOGGER.getLevel() == null) {
            LOGGER.setLevel(Level.FINER);
        }
    }
    
    @Id("overlay")
    Div overlay;
    
    
    public MenuBarOverlay() {
    }
    
    public void addComponent(MenuBarPopup mbp) {
        overlay.add(mbp);
    }
        
    @ClientCallable
    public void onOverlayClick() {
        LOGGER.log(Level.FINER, "Overlay Click detectado!");
        UI.getCurrent().remove(this);
    }
}

