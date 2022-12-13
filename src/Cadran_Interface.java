
/**
 * class intermédiaire entre les cadranset l'utilisateur: elle fait toute les initialisations, il suffit d'appeler la fonction getSovieticDial et getEuropeanDial pour avoir les cadrans
 * l'existance de cette classe est juste pour l'organisation et pour faciliter le développement de l'application dans le futur
 */
class Cadran_Interface
{
    SovieticDial sovieticDial = new SovieticDial(0,0);
    EuropeanDial europeanDial = new EuropeanDial(0,0);

    /**
     * fonction qui renvoit le cadran dans la norme soviétique 
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     * @return le cadran dans la norme soviétique 
     */
    public javafx.scene.Group getSovieticDial(double angleHorizontal,double angleVertical)
    {
        sovieticDial.Update(angleHorizontal, angleVertical);
        return sovieticDial.getCadran();
    }

    /**
     * fonction qui renvoit le cadran dans la norme européenne 
     * @param angleHorizontal l'angle d'inclinaison vers la droite(positif) ou la gauche(négatif)
     * @param angleVertical l'angle d'inclinaison vers le haut(positif) ou le bas(négatif)
     * @return le cadran dans la norme européenne 
     */
    public javafx.scene.Group getEuropeanDial(double angleHorizontal,double angleVertical)
    {
        europeanDial.Update(angleHorizontal, angleVertical);
        return europeanDial.getCadran();
    }
}