

import javafx.scene.image.*;
import javafx.scene.shape.Circle;

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
    protected void UpdatePlane() // à changer en void pour ne pas renvoyer une image à chaque fois
    {
        ImageViewAvion.setRotate(angleHorizontal);
    }
    /**
     * fonction qui renvoie la position de la position y de l'image à couper 
     * @param angle l'angle vertical
     * @param tailleImage la taille de l'image à couper
     * @return
     */
    private double y(double angle,double tailleImage)
    {
        return (tailleImage/360)*angle + tailleImage/4;
    }

    /**
     * méthode qui renvoie l'arrière plan du cadran
     * @return deux rectangles du regroupé du type Group
     */   
    @Override
    protected javafx.scene.Group getWallpaper()
    {
        
        Circle bord = new Circle(tailleCadran/2);

        double ImageHeight = ImageViewArrierePlan.getImage().getHeight();
        
        PixelReader reader = ImageViewArrierePlan.getImage().getPixelReader();
        WritableImage newImage = new WritableImage(reader, (int)ImageHeight/4,(int)y(angleVertical,ImageHeight), (int)ImageHeight/2, (int)ImageHeight/2);
        
        javafx.scene.paint.ImagePattern imagePattern = new javafx.scene.paint.ImagePattern(newImage);

        bord.setFill(imagePattern);

        bord.setCenterX(tailleCadran/2);
        bord.setCenterY(tailleCadran/2);

        return new javafx.scene.Group(bord);
    }

    /**
     * méthode qui retourne l'image complète du cadran
     * @return l'image complète du cadran du type Group
     */
    public javafx.scene.Group getCadran()
    {

        UpdatePlane();

        ImageViewAvion.setX((tailleCadran - ImageViewAvion.getLayoutBounds().getWidth())/2);
        ImageViewAvion.setY((tailleCadran - ImageViewAvion.getLayoutBounds().getHeight())/2);

        return new javafx.scene.Group(getWallpaper(),ImageViewAvion);
    }
}