
/**
 * class intermédiaire entre les cadranset l'utilisateur: elle fait toute les initialisations, il suffit d'appeler la fonction getSovieticDial et getEuropeanDial pour avoir les cadrans
 * l'existance de cette classe est juste pour l'organisation et pour faciliter le développement de l'application dans le futur
 */
class Cadran_Interface
{
    SovieticDial sovieticDial = new SovieticDial(0,0);
    EuropeanDial europeanDial = new EuropeanDial(0,0);
    private double angleHorizontal = 0;
    private double angleVertical = 0;

    /**
     * méthode qui remet les angles dans leurs intervalles correspondants: angleHorizontal de -179 à 180 et angleVertical de -90 à 90
     */
    private void nomaliseAngles()
    {
        // les deux cas en dessous doivent être plus détaillés en fonction de l'utilisation 
        if(angleVertical>=90)angleVertical=90; 
        if(angleVertical<=-90)angleVertical=-90;

        angleHorizontal = angleHorizontal%360;
        if(angleHorizontal>180) angleHorizontal = angleHorizontal-360;
        else if(angleHorizontal<=(-180)) angleHorizontal = angleHorizontal+360;
    }

    /**
     * préciser les angles de l'avion
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public void setAngles(double angleHorizontal,double angleVertical)
    {
        this.angleHorizontal=angleHorizontal;
        this.angleVertical = angleVertical;
        nomaliseAngles();
    }

    /**
     * méthode qui fait une rotation vers 
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public void rotation(double angleHorizontal,double angleVertical)
    {
        setAngles(this.angleHorizontal+angleHorizontal,this.angleVertical+angleVertical);
    }

    public javafx.scene.Group getEuropeanDial()
    {
        europeanDial.Update(angleHorizontal, angleVertical);
        return europeanDial.getCadran();
    }

    public javafx.scene.Group getSovieticDial()
    {
        sovieticDial.Update(angleHorizontal, angleVertical);
        return sovieticDial.getCadran();
    }

    //Les deux fonctions qui suivent sont utiles pour une simulation des angles précis et notament pour la réalisation d'une vidéo 

    /**
     * fonction qui renvoit le cadran dans la norme soviétique(simulation)
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     * @return le cadran dans la norme soviétique 
     */
    public javafx.scene.Group getSovieticDial(double angleHorizontal,double angleVertical)
    {
        setAngles(angleHorizontal,angleVertical);
        sovieticDial.Update(angleHorizontal, angleVertical);
        return sovieticDial.getCadran();
    }

    /**
     * fonction qui renvoit le cadran dans la norme européenne (simulation)
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     * @return le cadran dans la norme européenne 
     */
    public javafx.scene.Group getEuropeanDial(double angleHorizontal,double angleVertical)
    {
        setAngles(angleHorizontal,angleVertical);
        europeanDial.Update(this.angleHorizontal, this.angleVertical);
        return europeanDial.getCadran();
    }
}