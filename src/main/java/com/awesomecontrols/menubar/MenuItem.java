package com.awesomecontrols.menubar;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag("menu-item")
@StyleSheet("frontend://bower_components/menubar/cards.css")
@HtmlImport("bower_components/menubar/menu-item.html")
public class MenuItem extends PolymerTemplate<TemplateModel>  {
    private final static Logger LOGGER = Logger.getLogger(MenuItem.class .getName());
    static {
        if (LOGGER.getLevel() == null) {
            LOGGER.setLevel(Level.FINER);
        }
    }
    
    @Id("caption")
    Div caption;
    
    @Id("iconDiv")
    Div iconDiv;
    
    Icon icon;
    
    String sCaption;
    
    IItemClickListener icl;
    
    MenuItem(String caption) {
        this.sCaption = caption;
        this.caption.add(new Label(caption));
    }
    
    MenuItem(String caption, Icon icon) {
        this.sCaption = caption;
        this.caption.add(new Label(caption));
        this.icon = icon;
        this.iconDiv.add(this.icon);
    }
    
    MenuItem(String caption, IItemClickListener icl) {
        this.caption.add(new Label(caption));
        this.icl = icl;
    }
    
    MenuItem(String caption, Icon icon, IItemClickListener icl) {
        this.caption.add(new Label(caption));
        this.icl = icl;
        this.icon = icon;
        this.iconDiv.add(this.icon);
    }
    
    @ClientCallable
    void onItemClick() {
        LOGGER.log(Level.INFO, "Item click detectado!");
        if (icl != null) icl.onItemClick(this);
    }
    
    public MenuItem addClickListener(IItemClickListener icl) {
        this.icl = icl;
        return this;
    }
    
    public String getCaption() {
        return this.sCaption;
    }
    
    public MenuItem setCaption(String caption) {
        this.sCaption = caption;
        this.caption.removeAll();
        this.caption.add(new Label(caption));
        return this;
    }
}

