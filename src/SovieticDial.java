

import javafx.scene.image.*;

class SovieticDial extends cadran
{
    /**
     * Constructeur du cadran soviétique
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public SovieticDial(double angleHorizontal, double angleVertical)
    {
        super(angleHorizontal,angleVertical);
    }

    /**
     * méthode qui renvoie l'image de l'avion
     * @return l'image du type ImageView
     */
    @Override
    protected ImageView getPlane() // à changer en void pour ne pas renvoyer une image à chaque fois
    {
        ImageViewAvion.setRotate(angleHorizontal);
        return ImageViewAvion;
    }
    /**
     * fonction qui renvoie la position de la frontiere en couleur de l'arriere plan (en distance) (Calcul détaillé au brouillon)
     * @param angle l'angle vertical
     * @return
     */
    private double frontiere(double angle)
    {
        return (tailleCadran/180)*angle + tailleCadran/2;
    }

    /**
     * méthode qui renvoie l'arrière plan du cadran
     * @return deux rectangles du regroupé du type Group
     */   
    @Override
    protected javafx.scene.Group getWallpaper()
    {
        ImageViewArrierePlan.setY(frontiere(angleVertical)-tailleCadran/2);


        return new javafx.scene.Group(ImageViewArrierePlan);
    }

    /**
     * méthode qui retourne l'image complète du cadran
     * @return l'image complète du cadran du type Group
     */
    public javafx.scene.Group getCadran()
    {

        ImageView imageAvion = getPlane();

        imageAvion.setX((tailleCadran - imageAvion.getLayoutBounds().getWidth())/2);
        imageAvion.setY((tailleCadran - imageAvion.getLayoutBounds().getHeight())/2);

        return new javafx.scene.Group(getWallpaper(),imageAvion);
    }
}