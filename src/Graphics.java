import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


import javafx.scene.layout.BorderPane;

final class Graphics
{
    private char nbCadran = 0; // nombre de Cadrans à afficher sur l'écran
    private HBox CadransBox = new HBox(5); // VBox qui contient les deux portaits des cadrans, soit l'un à côté de l'autre, soit un seul cadran
    private Text HInclinaisonTexte = new Text();// indique l'inclinaison vers la gauche
    private Text VInclinaisonTexte = new Text();// indique l'inclinaison vers le bas

    // le groupe les objets qui doivent être affichés sur l'ecran
    Cadran_Interface Interface = new Cadran_Interface(); // l'interface qui permet d'avoir les images des cadrans

    boolean ShowSovietic = false; // boolean qui indique s'il faut montrer le cadran soviétique
    boolean ShowEuropean = false; // boolean qui indique s'il faut montrer le cadran européen
    /**
     * fonction qui sert à actualiser les cadrans
     */
    void actualiserCadran()
    {
        CadransBox.getChildren().clear();
        switch(nbCadran)
        {
            case 0:// dans ce cas il ne faut rien afficher
            break;

            case 1: // il faut afficher un seul cadran
            if(ShowSovietic)CadransBox.getChildren().addAll( new HBox(new Text("Cadran Soviétique"),Interface.getSovieticDial()));
            if(ShowEuropean)CadransBox.getChildren().addAll(new HBox(new Text("Cadran Européen"),Interface.getEuropeanDial()));
            break;

            case 2: //il faut afficher deux cadrans
            CadransBox.getChildren().addAll(Interface.getSovieticDial(),Interface.getEuropeanDial());
            break;
        }
    }
    void lancer(Stage stage)
    {
        // gestion des menus (pour l'organisation)

        BorderPane root = new BorderPane(); // l'ensemble global des objets à afficher
        MenuBar menuBar = new MenuBar(); // création de la bar principale

        Menu menuCadran = new Menu("Cadran"); // le menu du cadran

        // création des bouttons des cadran et leurs actions
        MenuItem BoutonSovietique = new MenuItem("   Sovietique");
        MenuItem BoutonEuropeen = new MenuItem("   Européen");

        BoutonSovietique.setOnAction(e -> 
        {
            if(ShowSovietic)
            {
                ShowSovietic=false;
                BoutonSovietique.setText("   Sovietique");
            }
            else
            {
                ShowSovietic=true;
                BoutonSovietique.setText("X  Sovietique");
            }
            nbCadran = 0;
            if(ShowSovietic)nbCadran++;
            if(ShowEuropean)nbCadran++;

            actualiserCadran();
        }
        );

        BoutonEuropeen.setOnAction(e -> 
        {
            if(ShowEuropean)
            {
                ShowEuropean=false;
                BoutonEuropeen.setText("   Européen");
            }
            else
            {
                ShowEuropean=true;
                BoutonEuropeen.setText("X  Européen");
            }
            nbCadran = 0;
            if(ShowSovietic)nbCadran++;
            if(ShowEuropean)nbCadran++;
            
            actualiserCadran();
        }
        );



        menuCadran.getItems().addAll(BoutonSovietique, BoutonEuropeen);

        menuBar.getMenus().addAll(menuCadran);
        
        
        // création des vbox et hbox d'organisation

            HBox hbox = new HBox(15); // représente les information d'inclinaison

            hbox.getChildren().addAll(HInclinaisonTexte,VInclinaisonTexte);
    
            VBox vbox = new VBox(4);

            root.getChildren().addAll(vbox);

            

            vbox.getChildren().addAll(CadransBox,hbox);
            
        ///////////////////////////////////////
           
            
            root.setTop(menuBar);
            
        // gestion des entrée/sorties avec l'utilisateur 
            Scene scene = new Scene(root, 600, 600);
    
            scene.addEventHandler(KeyEvent.KEY_PRESSED, event ->
            {
                switch(event.getCode())
                {
                    case RIGHT:
                    Interface.rotation(1, 0);
                    break;
    
                    case LEFT:
                    Interface.rotation(-1, 0);
                    break;
    
                    case UP:
                    Interface.rotation(0,1);
                    break;
    
                    case DOWN:
                    Interface.rotation(0,-1);
                    break;
    
                    default:
                    break;
    
                }
    

                actualiserCadran();
                

                // il faut ajouter des getters dans la class Interface pour connaîtres les angles !!
                HInclinaisonTexte.setText("l'inclinaison vers la droite est de: "+"°");// indique l'inclinaison vers la gauche
                VInclinaisonTexte.setText("l'inclinaison vers le bas est de: "+"°");// indique l'inclinaison vers le bas
            });
    
            
            stage.setResizable(false);
            stage.setTitle("Boeing 737 Max");
            stage.setScene(scene);
            stage.show();
        }
}