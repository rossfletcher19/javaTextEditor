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
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author rtbfl
 */
public class Control extends Application implements EventHandler {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    

