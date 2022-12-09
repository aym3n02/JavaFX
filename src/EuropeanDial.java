
import javafx.scene.image.*;
import javafx.scene.shape.Circle;

class EuropeanDial extends cadran
{

    public EuropeanDial(double angleHorizontal, double angleVertical)
    {
        super(angleHorizontal,angleVertical);
    }

    protected ImageView getPlane() // à changer en void pour ne pas renvoyer une image à chaque fois
    {
        return ImageViewAvion;
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
    
        // faire la rotation de l'arrière plan ici
        ImageView newImageView = new ImageView(newImage);
        newImageView.setRotate(ImageHeight);


        javafx.scene.paint.ImagePattern imagePattern = new javafx.scene.paint.ImagePattern(newImage);

        bord.setFill(imagePattern);

        bord.setCenterX(tailleCadran/2);
        bord.setCenterY(tailleCadran/2);

        return new javafx.scene.Group(bord);
    }

    public javafx.scene.Group getCadran()
    {
        ImageView imageAvion = getPlane();

        imageAvion.setX((tailleCadran - imageAvion.getLayoutBounds().getWidth())/2);
        imageAvion.setY((tailleCadran - imageAvion.getLayoutBounds().getHeight())/2);

        return new javafx.scene.Group(getWallpaper(),imageAvion);
    }

}