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
    HeadingsLinks headingsLinks = new HeadingsLinks();
    EffectsLinks effectsLinks = new EffectsLinks();
    
    
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #42f442;");
        return hbox;
    }
    
    private VBox addHeadingsVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(0);              // Gap between nodes
        
//        vbox.getChildren().add(control.createNewH1Button(textArea));
        vbox.getChildren().add(headingsLinks.createNewH1Link(textArea));
        vbox.getChildren().add(headingsLinks.createNewH2Link(textArea));
        vbox.getChildren().add(headingsLinks.createNewH3Link(textArea));
        vbox.getChildren().add(headingsLinks.createNewH4Link(textArea));
        vbox.getChildren().add(headingsLinks.createNewH5Link(textArea));
        vbox.getChildren().add(headingsLinks.createNewH6Link(textArea));
       
        
        return vbox;
    }
    
    private VBox addTextEffectsVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(0);              // Gap between nodes
        vbox.getChildren().add(effectsLinks.createNewStrongLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewEmphasisLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewCitationLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewDeletedLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewInsertedLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewSuperscriptLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewSubscriptLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewMonospaceLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewBlockQuoteLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewQuoteLink(textArea));
        vbox.getChildren().add(effectsLinks.createNewColorLink(textArea));
        
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
//        grid.setVgap(0);
        grid.setPadding(new Insets(10, 10, 0, 10));
        // Category in column 2, row 1
        Text category = new Text("formatting");
        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(category, 0, 0);
        
        final Accordion headingsAccordion = new Accordion ();
        final TitledPane headingsTitlePane = new TitledPane();
        headingsTitlePane.setText("Headings");
        headingsTitlePane.setContent(addHeadingsVBox());
        headingsAccordion.getPanes().addAll(headingsTitlePane);
        grid.add(headingsAccordion, 0, 1);
        
        final Accordion textEffectsAccordion = new Accordion ();
        final TitledPane textEffectsTitlePane = new TitledPane();
        textEffectsTitlePane.setText("Text Effects");
        textEffectsTitlePane.setContent(addTextEffectsVBox());
        textEffectsAccordion.getPanes().addAll(textEffectsTitlePane);
        grid.add(textEffectsAccordion, 0, 2);
        
        // Save/Open Buttons in column 0 (bottom)
        
        grid.add(control.createSaveButton(textArea, primaryStage), 0, 3); 
        grid.add(control.createSaveAsButton(textArea, primaryStage), 0, 4);
        grid.add(control.createOpenButton(textArea, primaryStage),0,5);

//        grid.setGridLinesVisible(true);
        return grid;
    }
    
    
       public Scene createScene(Stage primaryStage) {
        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addSideBarGridPane(primaryStage));
        addStackPane(hbox);
        textArea.setWrapText(true);
        border.setCenter(textArea);
        Scene scene = new Scene(border);
        return scene;
       }
}
