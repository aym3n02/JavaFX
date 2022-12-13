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


    private double angleHorizontal = 0;
    private double angleVertical = 0;
    Text HInclinaisonTexte = new Text("l'inclinaison vers la droite est de: "+angleHorizontal+"°");// indique l'inclinaison vers la gauche
    Text VInclinaisonTexte = new Text("l'inclinaison vers le bas est de: "+angleVertical+"°");// indique l'inclinaison vers le bas



    @Override
    public void start(Stage stage) throws Exception {

        HBox hbox = new HBox(15); // représente les information d'inclinaison

        hbox.getChildren().addAll(HInclinaisonTexte,VInclinaisonTexte);

        VBox vbox = new VBox(4);

        vbox.getChildren().addAll(hbox);


        Group root = new Group(vbox);


        /***********Testing spot************/

        Cadran_Interface cadran = new Cadran_Interface();

        root.getChildren().addAll(cadran.getSovieticDial());

        /***********************************/

        Scene scene = new Scene(root, 300, 300);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event ->
        {
            switch(event.getCode())
            {
                case RIGHT:
                angleHorizontal++;
                break;

                case LEFT:
                angleHorizontal--;
                break;

                case UP:
                angleVertical++;
                break;

                case DOWN:
                angleVertical--;
                break;

                default:
                break;

            }
            cadran.setAngles(angleHorizontal, angleVertical);

            root.getChildren().remove(1);// supprimer l'ancienne image
            root.getChildren().addAll(cadran.getSovieticDial());

            HInclinaisonTexte.setText("l'inclinaison vers la droite est de: "+angleHorizontal+"°");// indique l'inclinaison vers la gauche
            VInclinaisonTexte.setText("l'inclinaison vers le bas est de: "+angleVertical+"°");// indique l'inclinaison vers le bas
        
        });

        
        stage.setResizable(false);
        stage.setTitle("Boeing 737 Max");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {

        launch(args);
    }
}
