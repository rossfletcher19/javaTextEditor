/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texteditor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;

/**
 *
 * @author rtbfl
 */
public class EffectsLinks {
    String[] effects = {"*","_","??","-","+","^","~","{{","}}","bq. ","{quote}","{color:color}","{color}"};
    String selectedText = new String();
    
    public Hyperlink createNewStrongLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("strong");
        Link.getStyleClass().add("strongLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[0] + selectedText + effects[0]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewEmphasisLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("emphasis");
        Link.getStyleClass().add("emphasisLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[1] + selectedText + effects[1]);
            }
        });
        return Link;
    }
    
    
    
    public Hyperlink createNewCitationLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("— citation");
        Link.getStyleClass().add("citationLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[2] + selectedText + effects[2]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewDeletedLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("deleted");
        Link.getStyleClass().add("deletedLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[3] + selectedText + effects[3]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewInsertedLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("inserted");
        Link.getStyleClass().add("insertedLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[4] + selectedText + effects[4]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewSuperscriptLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("superscript");
        Link.getStyleClass().add("superscriptLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[5] + selectedText + effects[5]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewSubscriptLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("subscript");
        Link.getStyleClass().add("subscriptLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[6] + selectedText + effects[6]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewMonospaceLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("monospace");
        Link.getStyleClass().add("monospaceLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[7] + selectedText + effects[8]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewBlockQuoteLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("block quote");
        Link.getStyleClass().add("blockquoteLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText();
                textArea.replaceSelection(effects[9] + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewQuoteLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("quote");
        Link.getStyleClass().add("quoteLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[10] + selectedText + effects[10]);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewColorLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("text color");
        Link.getStyleClass().add("textcolorLink");
        Link.getStyleClass().add("hyperlinkHnC");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(effects[11] + selectedText + effects[12]);
            }
        });
        return Link;
    }
}
