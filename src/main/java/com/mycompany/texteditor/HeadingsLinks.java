/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texteditor;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;


/**
 *
 * @author rtbfl
 */
public class HeadingsLinks {
    String[] headings = {"h1. ","h2. ","h3. ","h4. ","h5. ","h6. "};
    String selectedText = new String();
    
    public Button createNewH1Button(final TextArea textArea){
    Button button = new Button();
    button.getStyleClass().add("button");
    String biggestHeading = "Biggest heading";
    button.setText(headings[0] + biggestHeading);
    button.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[0] + selectedText);
        }
    });
    
    return button;
    }
    
    
    public Hyperlink createNewH1Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        
        Link.getStyleClass().add("hyperlinkH1");
        Link.getStyleClass().add("hyperlinkHnC");
        
        String biggestHeading = "Biggest heading";
        Link.setText(headings[0] + biggestHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[0] + selectedText);
                
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH2Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.getStyleClass().add("hyperlinkH2");
        Link.getStyleClass().add("hyperlinkHnC");
//        Link.setStyle("-fx-font: bold 20px 'serif' ");
        String biggerHeading = "Bigger heading";
        Link.setText(headings[1]+biggerHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[1] + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH3Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.getStyleClass().add("hyperlinkH3");
        Link.getStyleClass().add("hyperlinkHnC");
        String bigHeading = "Big heading";
        Link.setText(headings[2] + bigHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[2] + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH4Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.getStyleClass().add("hyperlinkH4");
        Link.getStyleClass().add("hyperlinkHnC");
        String normalHeading = "Normal heading";
        Link.setText(headings[3] + normalHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[3] + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH5Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.getStyleClass().add("hyperlinkH5");
        Link.getStyleClass().add("hyperlinkHnC");
        String smallHeading = "Small heading";
        Link.setText(headings[4] + smallHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[4] + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH6Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.getStyleClass().add("hyperlinkH6");
        Link.getStyleClass().add("hyperlinkHnC");
        String smallestHeading = "Smallest heading";
        Link.setText(headings[5] + smallestHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(headings[5] + selectedText);
            }
        });
        return Link;
    }

   
}
