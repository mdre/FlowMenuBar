package com.awesomecontrols.menubar;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag("menu-bar-popup")
@StyleSheet("frontend://bower_components/menubar/cards.css")
@HtmlImport("bower_components/menubar/menu-bar-popup.html")
class MenuBarPopup extends PolymerTemplate<MenuBarPopupModel> implements  HasSize, HasTheme, HasStyle {
    private final static Logger LOGGER = Logger.getLogger(MenuBarPopup.class .getName());
    static {
        if (LOGGER.getLevel() == null) {
            LOGGER.setLevel(Level.FINER);
        }
    }
    
    @Id("popup")
    Div popup;
    
    double top;
    double left;
    
    public MenuBarPopup() {
    }
    
    public void setPosition(double top, double left) {
        this.top = top;
        this.left = left;
        popup.getStyle().set("top", ""+top+"px");
        popup.getStyle().set("left", ""+left+"px");
    }
    
    public void addMenuItem(MenuItem menuItem) {
        this.popup.add(menuItem);
    }
    
}

