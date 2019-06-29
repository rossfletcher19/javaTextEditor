package com.mycompany.texteditor;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    /**
     * The main() method is ignored in correctly deployed JavaFX application.main() serves only as fallback in case the application can not be
 launched through deployment artifacts, e.g., in IDEs with limited FX
 support.
     * NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(MainApp.class, args);
    }
    
    View view = new View();
    
    public void start(Stage primaryStage) {
        primaryStage.setHeight(600);
        primaryStage.setWidth(1000);
        
        Scene scene = view.createScene(primaryStage);
        scene.getStylesheets().add("styles/Styles.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("textEditor");
        primaryStage.show();
        
    }

}
