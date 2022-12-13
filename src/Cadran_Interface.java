
/**
 * class intermédiaire entre les cadranset l'utilisateur: elle fait toute les initialisations, il suffit d'appeler la fonction getSovieticDial et getEuropeanDial pour avoir les cadrans
 * l'existance de cette classe est juste pour l'organisation et pour faciliter le développement de l'application dans le futur
 */
class Cadran_Interface
{
    SovieticDial sovieticDial = new SovieticDial(0,0);
    EuropeanDial europeanDial = new EuropeanDial(0,0);
    private double roulis = 0;
    private double tangage = 0;

    /**
     * méthode qui remet les angles dans leurs intervalles correspondants: roulis de -179 à 180 et tangage de -90 à 90
     */
    private void nomaliseAngles()
    {
        // les deux cas en dessous doivent être plus détaillés en fonction de l'utilisation 
        if(tangage>=90)tangage=90; 
        if(tangage<=-90)tangage=-90;

        roulis = roulis%360;
        if(roulis>180) roulis = roulis-360;
        else if(roulis<=(-180)) roulis = roulis+360;
    }

    /**
     * préciser les angles de l'avion
     * @param roulis l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param tangage l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public void setAngles(double roulis,double tangage)
    {
        this.roulis=roulis;
        this.tangage = tangage;
        nomaliseAngles();
    }

    /**
     * méthode qui fait une rotation vers 
     * @param roulis l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param tangage l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     */
    public void rotation(double roulis,double tangage)
    {
        setAngles(this.roulis+roulis,this.tangage+tangage);
    }

    /**
     * 
     * @return 
     */
    public javafx.scene.Group getEuropeanDial()
    {
        europeanDial.Update(roulis, tangage);
        return europeanDial.getCadran();
    }

    public javafx.scene.Group getSovieticDial()
    {
        sovieticDial.Update(roulis, tangage);
        return sovieticDial.getCadran();
    }

    //Les deux fonctions qui suivent sont utiles pour une simulation des angles précis et notament pour la réalisation d'une vidéo 

    /**
     * fonction qui renvoit le cadran dans la norme soviétique(simulation)
     * @param roulis l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param tangage l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     * @return le cadran dans la norme soviétique 
     */
    public javafx.scene.Group getSovieticDial(double roulis,double tangage)
    {
        setAngles(roulis,tangage);
        sovieticDial.Update(roulis, tangage);
        return sovieticDial.getCadran();
    }

    /**
     * fonction qui renvoit le cadran dans la norme européenne (simulation)
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     * @return le cadran dans la norme européenne 
     */
    public javafx.scene.Group getEuropeanDial(double roulis,double tangage)
    {
        setAngles(roulis,tangage);
        europeanDial.Update(this.roulis, this.tangage);
        return europeanDial.getCadran();
    }
}