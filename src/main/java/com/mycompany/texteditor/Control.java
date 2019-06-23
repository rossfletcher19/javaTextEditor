/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texteditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author rtbfl
 */
public class Control extends Application implements EventHandler {
    
    String selectedText = new String();
    //headings variables
    String h1 = "h1";
    String h2 = "h2";
    String h3 = "h3";
    String h4 = "h4";
    String h5 = "h5";
    String h6 = "h6";
    // text effects varibales
    String strong = "*";
   
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // HEADINGS Methods
    public Hyperlink createNewH1Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        String biggestHeading = ". Biggest heading";
       Link.setStyle("-fx-font: normal bold 24px 'serif' ");
        
        Link.setText(h1 + biggestHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(h1 + ". " + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH2Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setStyle("-fx-font: normal bold 20px 'serif' ");
        String biggerHeading = ". Bigger heading";
        Link.setText(h2+biggerHeading);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(h2 + ". " + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH3Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText(h3);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(h3 + ". " + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH4Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText(h4);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(h4 + ". " + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH5Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText(h5);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(h5 + ". " + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewH6Link(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText(h6);
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(h6 + ". " + selectedText);
            }
        });
        return Link;
    }
    
    public Hyperlink createNewStrongLink(final TextArea textArea) {
        Hyperlink Link = new Hyperlink();
        Link.setText("strong");
        Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                selectedText = textArea.getSelectedText(); 
                textArea.replaceSelection(strong + selectedText + strong);
            }
        });
        return Link;
    }
    
    
    
    public Button createSaveButton(final TextArea textArea, final Stage primaryStage){
        
        Button button = new Button();
        button.setText("save");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
             
                if(file != null){
                    
                    SaveFile(textArea.getText().replaceAll("\n", System.getProperty("line.separator")), file);
                } 
            }
        });
       return button;
    
    }
    
    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Control.class
                .getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    
    
}
    
    

