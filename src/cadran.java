

import javafx.scene.image.*;

abstract class cadran
{
    protected double angleHorizontal = 0; // sens horaire
    protected double angleVertical = 0; // positive vers le haut, négative vers le bas, ne doit pas dépasser 180 ou être inférieur à -180


    /**
     * à modifier à chaque reprise :
     */
    protected ImageView ImageViewAvion = new ImageView(new Image("C:\\Users\\Eleves\\Desktop\\test project\\JavaFX\\src\\avion.png")); // photo de l'avion du cadran
    protected ImageView ImageViewArrierePlan = new ImageView(new Image("C:\\Users\\Eleves\\Desktop\\test project\\JavaFX\\src\\arriere plan.png")); // photo de l'Arrière plan
    protected double tailleCadran = 300; // représente la taille du cadran(il est de forme carrée)

    /**
     * Constructeur d'un cadran
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public cadran(double angleHorizontal, double angleVertical)
    {
        this.angleHorizontal = angleHorizontal;
        this.angleVertical = angleVertical;
    }
    
    /**
     * méthode qui renvoie l'image de l'avion
     * @return l'image du type ImageView
     */
    abstract protected ImageView getPlane();

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
     * @param angleHorizontal le nouveau angle d'inclinaison droite/gauche
     * @param angleVertical le nouveau angle d'inclinaison haut/bas
     */
    public void Update(double angleHorizontal, double angleVertical)
    {
        this.angleHorizontal = angleHorizontal;
        this.angleVertical = angleVertical;
    }
}