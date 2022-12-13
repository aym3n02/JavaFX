import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.Group;

import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;//TextArea
import javafx.animation.AnimationTimer;

import javafx.scene.text.Text;

public class App extends Application {


    private double roulis = 0;
    private double tangage = 0;
    Text HInclinaisonTexte = new Text("l'inclinaison vers la droite est de: "+roulis+"°");// indique l'inclinaison vers la gauche
    Text VInclinaisonTexte = new Text("l'inclinaison vers le bas est de: "+tangage+"°");// indique l'inclinaison vers le bas



    @Override
    public void start(Stage stage) throws Exception {
        Graphics gfx = new Graphics();
        gfx.lancer(stage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
