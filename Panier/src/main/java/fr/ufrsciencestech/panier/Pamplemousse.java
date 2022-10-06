package fr.ufrsciencestech.panier;


import fr.ufrsciencestech.panier.Fruit;
import fr.ufrsciencestech.panier.Fruit;

/**
 *
 * @author roudet
 */
 
public class Pamplemousse implements Fruit{
    private double prix;
    private String origine;
	
    public Pamplemousse() 
    {
        this.prix = 1.8;  //prix en euros
        this.origine="Afrique du Sud";
    }
    
    public Pamplemousse(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Afrique du Sud";  //Afrique du Sud par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Pamplemousse de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 pamplemousses sont equivalents
        if(o != null && getClass() == o.getClass()){
            Pamplemousse p = (Pamplemousse) o;
            return (prix == p.prix && origine.equals(p.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'un pamplemousse a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
        Pamplemousse o = new Pamplemousse();
        System.out.println("premier test Pamplemousse");
        double prix = o.getPrix();
        String origine = o.getOrigine();
        if(prix==1.8)
            System.out.println("getPrix OK");
        else
            System.out.println("getPrix FALSE");
        
        if(origine.equals("Afrique du Sud"))
            System.out.println("getOrigine OK");
        else
            System.out.println("getOrigine FALSE");
        
        o.setPrix(1.5);
        prix = o.getPrix();
        if(prix==1.5)
            System.out.println("setPrix OK");
        else
            System.out.println("setPrix FALSE");
        
        o.setOrigine("Chine");
        origine = o.getOrigine();
        if(origine.equals("Chine"))
            System.out.println("setOrigine OK");
        else
            System.out.println("setOrigine FALSE");
        
        String desc = o.toString();
        if(desc.equals("Pamplemousse de Chine a 1.5 euros"))
            System.out.println("toString OK");
        else
            System.out.println("toString FALSE");    
   }
}
