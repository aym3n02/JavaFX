import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

final class Graphics
{
    private char nbCadran = 1; // nombre de Cadrans à afficher sur l'écran
    private double roulis = 0;
    private double tangage = 0;
    private Text HInclinaisonTexte = new Text("l'inclinaison vers la droite est de: "+roulis+"°");// indique l'inclinaison vers la gauche
    private Text VInclinaisonTexte = new Text("l'inclinaison vers le bas est de: "+tangage+"°");// indique l'inclinaison vers le bas

    void lancer(Stage stage)
    {
        

            HBox hbox = new HBox(15); // représente les information d'inclinaison
    
            hbox.getChildren().addAll(HInclinaisonTexte,VInclinaisonTexte);
    
            VBox vbox = new VBox(4);
    
            
            Group root = new Group(vbox);
    
            /***********Testing spot************/

            SovieticDial cadran = new SovieticDial(roulis,tangage);
    
            root.getChildren().addAll(cadran.getCadran());
    
            /***********************************/
            

            

            Scene scene = new Scene(root, 300, 300);
    
            scene.addEventHandler(KeyEvent.KEY_PRESSED, event ->
            {
                switch(event.getCode())
                {
                    case RIGHT:
                    roulis++;
                    break;
    
                    case LEFT:
                    roulis--;
                    break;
    
                    case UP:
                    tangage++;
                    break;
    
                    case DOWN:
                    tangage--;
                    break;
    
                    default:
                    break;
    
                }
    
                if(tangage>=90)tangage=90;
                if(tangage<=-90)tangage=-90;
    
    
                roulis = roulis%360;
                if(roulis>180) roulis = roulis-360;
                else if(roulis<=(-180)) roulis = roulis+360;
    
    
                cadran.Update(roulis, tangage);
    
                root.getChildren().remove(1);// supprimer l'ancienne image
                root.getChildren().addAll(cadran.getCadran());
    
                HInclinaisonTexte.setText("l'inclinaison vers la droite est de: "+roulis+"°");// indique l'inclinaison vers la gauche
                VInclinaisonTexte.setText("l'inclinaison vers le bas est de: "+tangage+"°");// indique l'inclinaison vers le bas
            
            });
    
            
            stage.setResizable(false);
            stage.setTitle("Boeing 737 Max");
            stage.setScene(scene);
            stage.show();
        }
}