
import javafx.scene.image.*;
import javafx.scene.shape.Circle;

class EuropeanDial extends cadran
{

    public EuropeanDial(double angleHorizontal, double angleVertical)
    {
        super(angleHorizontal,angleVertical);
    }

    protected void UpdatePlane() // à changer en void pour ne pas renvoyer une image à chaque fois
    {
        // L'avion reste immobile dans la norme européenne, cette fonction restera alors constante
    }

    private double y(double angle,double tailleImage)
    {
        return (tailleImage/360)*angle + tailleImage/4;
    }


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

        // faire la rotation de l'arrière plan ici
        bord.setRotate(-angleHorizontal);

        return new javafx.scene.Group(bord);
    }

    public javafx.scene.Group getCadran()
    {

        UpdatePlane(); // fonction inutile mais ajoutée en cas de potentielle mise à jour

        ImageViewAvion.setX((tailleCadran - ImageViewAvion.getLayoutBounds().getWidth())/2);
        ImageViewAvion.setY((tailleCadran - ImageViewAvion.getLayoutBounds().getHeight())/2);

        return new javafx.scene.Group(getWallpaper(),ImageViewAvion);
    }

}