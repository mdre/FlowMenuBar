package com.awesomecontrols.menubar;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag("menu-bar")
@StyleSheet("frontend://bower_components/menubar/cards.css")
@HtmlImport("bower_components/menubar/menu-bar.html")
public class MenuBar extends PolymerTemplate<TemplateModel>  implements HasStyle {
    private final static Logger LOGGER = Logger.getLogger(MenuBar.class .getName());
    static {
        if (LOGGER.getLevel() == null) {
            LOGGER.setLevel(Level.FINER);
        }
    }
    @Id("menuBar")
    Div menuBar;
    
    @Id("caption")
    Span caption;
    
    @Id("iconDiv") 
    Div icon;
    
    Icon barIcon;
    
    // overlay utilziado para mostrar el menú
    MenuBarOverlay mbo;
    
    // marco del popup;
    MenuBarPopup mbp;
    
    public MenuBar(String caption) {
        Label lbl = new Label(caption);
        this.caption.add(lbl);
        mbo = new MenuBarOverlay();
        mbp = new MenuBarPopup();
    }
    
    public MenuBar(String caption, Icon icon) {
        this.barIcon = icon;
        this.icon.add(this.barIcon);
        
        Label lbl = new Label(caption);
        this.caption.add(lbl);
        mbo = new MenuBarOverlay();
        mbp = new MenuBarPopup();
        
    }
    
    @Synchronize("change")
    public String getCaption() {
        return getElement().getProperty("value");
    }

    public void setCaption(String value) {
        getElement().setProperty("value", value);
    }
    
    @ClientCallable
    public void onMenuBarClick(double top, double left) {
        LOGGER.log(Level.INFO, "Click detectado: "+top+", "+left);
        // agregar el overlay
        UI.getCurrent().add(mbo);
        
        mbp.setPosition(top,left);
        
        mbo.addComponent(mbp);
    }
    
    
    public MenuItem addMenuItem(String itemCaption) {
        MenuItem mi = new MenuItem(itemCaption);
        this.mbp.addMenuItem(mi);
        return mi;
    }
    
    public MenuItem addMenuItem(String itemCaption, Icon icon) {
        MenuItem mi = new MenuItem(itemCaption, icon);
        this.mbp.addMenuItem(mi);
        return mi;
    }
    
    public MenuItem addMenuItem(String itemCaption, IItemClickListener icl) {
        MenuItem mi = new MenuItem(itemCaption, icl);
        this.mbp.addMenuItem(mi);
        return mi;
    }
    
    public MenuItem addMenuItem(String itemCaption, Icon icon, IItemClickListener icl) {
        MenuItem mi = new MenuItem(itemCaption, icon, icl);
        this.mbp.addMenuItem(mi);
        return mi;
    }

    @Override
    public void removeClassNames(String... classNames) {
        HasStyle.super.removeClassNames(classNames); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addClassNames(String... classNames) {
        menuBar.addClassNames(classNames); 
        mbp.addClassNames(classNames);
    }

    @Override
    public void setClassName(String className, boolean set) {
        menuBar.setClassName(className, set); 
        mbp.setClassName(className, set);
    }

    @Override
    public void setClassName(String className) {
        menuBar.setClassName(className);
        mbp.setClassName(className);
    }

    @Override
    public boolean removeClassName(String className) {
        mbp.removeClassName(className);
        return menuBar.removeClassName(className); 
    }

    @Override
    public void addClassName(String className) {
        menuBar.addClassName(className); 
        mbp.addClassName(className);
    }
    
    
}

