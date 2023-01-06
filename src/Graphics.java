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
    private char nbCadran ; // nombre de Cadrans à afficher sur l'écran
    private HBox CadransBox; // VBox qui contient les deux portaits des cadrans, soit l'un à côté de l'autre, soit un seul cadran
    private Text HInclinaisonTexte;// indique l'inclinaison vers la gauche
    private Text VInclinaisonTexte ;// indique l'inclinaison vers le bas

    // le groupe les objets qui doivent être affichés sur l'ecran
    Cadran_Interface Interface ; // l'interface qui permet d'avoir les images des cadrans

    boolean ShowSovietic; // boolean qui indique s'il faut montrer le cadran soviétique
    boolean ShowEuropean; // boolean qui indique s'il faut montrer le cadran européen

    /**
     * constructeur par défaut qui initialise les variables
     */
    public Graphics()
    {
        nbCadran = 0; // le nombre des cadrans à afficher
        CadransBox = new HBox(5);
        HInclinaisonTexte = new Text();
        VInclinaisonTexte = new Text();
        Interface = new Cadran_Interface(); // l'interface de gestion des cadrans
        ShowSovietic = false; // boolean qui indique si le cadran sovitétique doit être affiché
        ShowEuropean = false; // boolean qui indique si le cadran européen doit être affiché
    }
    /**
     * fonction qui sert à actualiser les cadrans
     */
    void actualiserCadran()
    {
        CadransBox.getChildren().clear();
        switch(nbCadran)
        {
            case 0:// dans ce cas il ne faut rien afficher
            HInclinaisonTexte.setText("");
            VInclinaisonTexte.setText("");
            break;

            case 1: // il faut afficher un seul cadran
            if(ShowSovietic)CadransBox.getChildren().addAll(new VBox(new Text("Cadran Soviétique:"),Interface.getSovieticDial()));
            if(ShowEuropean)CadransBox.getChildren().addAll(new VBox(new Text("Cadran Européen:"),Interface.getEuropeanDial()));

            HInclinaisonTexte.setText("l'inclinaison vers la droite est de: "+Interface.getRoulis()+"°");// indique l'inclinaison vers la gauche
            VInclinaisonTexte.setText("l'inclinaison vers le bas est de: "+Interface.getTangage()+"°");// indique l'inclinaison vers le bas

            break;

            case 2: //il faut afficher deux cadrans
            CadransBox.getChildren().addAll(new VBox(new Text("Cadran Soviétique:"),Interface.getSovieticDial()),new VBox(new Text("Cadran Européen:"),Interface.getEuropeanDial()));

            HInclinaisonTexte.setText("l'inclinaison vers la droite est de: "+Interface.getRoulis()+"°");// indique l'inclinaison vers la gauche
            VInclinaisonTexte.setText("l'inclinaison vers le bas est de: "+Interface.getTangage()+"°");// indique l'inclinaison vers le bas
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
            
            actualiserCadran(); // actualiser le cadran
        }
        );



        menuCadran.getItems().addAll(BoutonSovietique, BoutonEuropeen);

        menuBar.getMenus().addAll(menuCadran);
        
        
        // création des vbox et hbox d'organisation

            HBox hbox = new HBox(15); // représente les information d'inclinaison

            hbox.getChildren().addAll(HInclinaisonTexte,VInclinaisonTexte);
    
            VBox vbox = new VBox(4);
            vbox.setTranslateY(25); // car la barre des menus fait 25 pixels de hauteur

            root.getChildren().addAll(vbox);

            vbox.getChildren().addAll(CadransBox,hbox);

            
        ///////////////////////////////////////
           
            
            root.setTop(menuBar); // création de la barre des tâches
            
        // gestion des entrée/sorties avec l'utilisateur 
            Scene scene = new Scene(root, 610, 600);
    
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
    

                actualiserCadran(); // actualiser le cadran
                
                HInclinaisonTexte.setText("l'inclinaison vers la droite est de: "+Interface.getRoulis()+"°");// indique l'inclinaison vers la gauche
                VInclinaisonTexte.setText("l'inclinaison vers le bas est de: "+Interface.getTangage()+"°");// indique l'inclinaison vers le bas
            });
    
            
            stage.setResizable(false);
            stage.setTitle("Boeing 737 Max");
            stage.setScene(scene);
            stage.show();
        }
}