/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texteditor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rtbfl
 */
public class View {
    TextArea textArea = new TextArea();
    Control control = new Control();
    
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #42f442;");
        return hbox;
    }
    
    private VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(0);              // Gap between nodes
        vbox.getChildren().add(control.createNewH1Link(textArea));
        vbox.getChildren().add(control.createNewH2Link(textArea));
        vbox.getChildren().add(control.createNewH3Link(textArea));
        vbox.getChildren().add(control.createNewH4Link(textArea));
        vbox.getChildren().add(control.createNewH5Link(textArea));
        vbox.getChildren().add(control.createNewH6Link(textArea));
        
        return vbox;
    }
    
    public void addStackPane(HBox hb) {
        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
            new Stop[]{
            new Stop(0,Color.web("#4977A3")),
            new Stop(0.5, Color.web("#B0C6DA")),
            new Stop(1,Color.web("#9CB6CF")),}));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);

        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0")); 

        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"

        hb.getChildren().add(stack);            // Add stack pane to HBox object
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
    }
    
    
    
    public GridPane addSideBarGridPane(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 0, 10));
        // Category in column 2, row 1
        Text category = new Text("formatting");
        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(category, 0, 0);
        
        final Accordion headingsAccordion = new Accordion ();
        final TitledPane h1TitlePane = new TitledPane();
        h1TitlePane.setText("Headings");
        h1TitlePane.setContent(addVBox());
        headingsAccordion.getPanes().addAll(h1TitlePane);
        grid.add(headingsAccordion, 0, 1); 
        
        // Save Button in column 1 (bottom), row 3
        grid.add(control.createSaveButton(textArea, primaryStage), 0, 2); 

        // Right label in column 4 (top), row 3
        Text servicesPercent = new Text("gridcorner");
        grid.add(servicesPercent, 3, 2);
        grid.setGridLinesVisible(true);
        return grid;
    }
    
    
       public Scene createScene(Stage primaryStage) {
        
      
        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addSideBarGridPane(primaryStage));
        addStackPane(hbox);
        border.setCenter(textArea);
        Scene scene = new Scene(border);
        return scene;
       }
}
