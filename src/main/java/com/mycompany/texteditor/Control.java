/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texteditor;


import java.io.File;
import java.io.FileReader;
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
import javafx.stage.FileChooser.ExtensionFilter;
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
        Link.setStyle("-fx-font: bold 24px 'serif' ");
        String biggestHeading = ". Biggest heading";
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
        Link.setStyle("-fx-font: bold 20px 'serif' ");
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
        Link.setStyle("-fx-font: bold 16px 'serif' ");
        String bigHeading = ". Big heading";
        Link.setText(h3 + bigHeading);
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
        Link.setStyle("-fx-font: bold 14px 'serif' ");
        String normalHeading = ". Normal heading";
        Link.setText(h4 + normalHeading);
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
        Link.setStyle("-fx-font: bold 12px 'serif' ");
        String smallHeading = ". Small heading";
        Link.setText(h5 + smallHeading);
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
        Link.setStyle("-fx-font: 12px 'serif' ");
        String smallestHeading = ". Smallest heading";
        Link.setText(h6 + smallestHeading);
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
    
    
    
    public Button createSaveAsButton(final TextArea textArea, final Stage primaryStage){
        
        Button button = new Button();
        button.setText("save as");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
             
                if(file != null){
                    
                    SaveFile(textArea.getText().replaceAll("\n", System.getProperty("line.separator")), file);
                } 
            }
        });
       return button;
    
    }
    
    public Button createSaveButton(final TextArea textArea, final Stage primaryStage){
        
        Button button = new Button();
        button.setText("save");
       
        
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                
                
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
                
                
                if(file != null){
                    
                    SaveFile(textArea.getText().replaceAll("\n", System.getProperty("line.separator")), file);
                } 
            }
        });
       return button;
    
    }
    
     public Button createOpenButton(final TextArea textArea, final Stage primaryStage){
        
        Button button = new Button();
        button.setText("open");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                
                
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
                        new ExtensionFilter("Text Files", "*.txt"));
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                if (selectedFile != null) {
                 OpenFile(textArea, selectedFile);
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
    
    // kinda working
//    private void OpenFile(TextArea textArea, File file){
//        try {
//            
//            FileReader filereader;
//            filereader = new FileReader(file);
//            
//            BufferedReader reader = new BufferedReader(filereader);
//            String string;
//            string = reader.lines().collect(Collectors.joining());
//            
//            System.out.print(string);
//            
//            textArea.setText(string);
//            filereader.close();
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Control.class
//                .getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//          
//    }
    
    private void OpenFile(TextArea textArea, File file){
        
        try {
            
            FileReader filereader;
            filereader = new FileReader(file);
            int i; 
            String targetString = "";
            while ((i=filereader.read()) != -1) {
                targetString += (char) i;
            }

            textArea.setText(targetString);
            filereader.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Control.class
                .getName()).log(Level.SEVERE, null, ex);
        }
        
        
          
    }
    
    
    
}
    
    

