

import javafx.scene.image.*;

class cadran
{
    private double angleHorizontal = 0; // sens horaire
    private double angleVertical = 0; // positive vers le haut, négative vers le bas, ne doit pas dépasser 180 ou être inférieur à -180

    private ImageView ImageViewAvion = new ImageView(new Image("C:\\Users\\Eleves\\Desktop\\test project\\JavaFX\\src\\avion.png")); // photo de l'avion du cadran

    public cadran(double angleHorizontal, double angleVertical)
    {
        this.angleHorizontal = angleHorizontal;
        this.angleVertical = angleVertical;
    }

    public ImageView getSovieticPlane()
    {
        return ImageViewAvion;
    }

    public ImageView getEuropeanPlane()
    {
        return ImageViewAvion;
    }

    public ImageView getWallpaper()
    {
        return ImageViewAvion;
    }

}