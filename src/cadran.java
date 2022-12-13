

import javafx.scene.image.*;

abstract class cadran
{
    protected double roulis = 0; // sens horaire
    protected double tangage = 0; // positive vers le haut, négative vers le bas, ne doit pas dépasser 180 ou être inférieur à -180


    /**
     * à modifier à chaque reprise :
     */
    protected ImageView ImageViewAvion = new ImageView(new Image("C:\\Users\\Eleves\\Desktop\\test project\\JavaFX\\src\\avion.png")); // photo de l'avion du cadran
    protected ImageView ImageViewArrierePlan = new ImageView(new Image("C:\\Users\\Eleves\\Desktop\\test project\\JavaFX\\src\\arriere plan.png")); // photo de l'Arrière plan
    protected double tailleCadran = 300; // représente la taille du cadran(il est de forme carrée)

    /**
     * Constructeur d'un cadran
     * @param roulis l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param tangage l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public cadran(double roulis, double tangage)
    {
        this.roulis = roulis;
        this.tangage = tangage;
        ImageViewAvion.setFitHeight(tailleCadran/1.5);
        ImageViewAvion.setFitWidth(tailleCadran/1.5);
    }
    
    /**
     * méthode qui renvoie l'image de l'avion
     * @return l'image du type ImageView
     */
    abstract protected void UpdatePlane();

    /**
     * méthode qui renvoie l'arrière plan du cadran
     * @return deux rectangles du regroupé du type Group
     */   
    abstract protected javafx.scene.Group getWallpaper();

    /**
     * méthode qui retourne l'image complète du cadran
     * @return l'image complète du cadran du type Group
     */
    abstract public javafx.scene.Group getCadran();

    /**
     * méthode qui permet d'actualiser le cadran
     * @param roulis le nouveau angle d'inclinaison droite/gauche
     * @param tangage le nouveau angle d'inclinaison haut/bas
     */
    public void Update(double roulis, double tangage)
    {
        this.roulis = roulis;
        this.tangage = tangage;
    }
}