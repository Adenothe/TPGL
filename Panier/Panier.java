import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier

    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
		    this.fruits = new ArrayList<Fruit>();
		    this.contenanceMax = contenanceMax;
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String s = "Votre panier contient:\n";
        for (Fruit f: this.fruits)
        {
			s += "- " + f.toString() + "\n";
		}


		return s;
    }

    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut

    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.getFruits().size();
    }

    public int getContenanceMax(){  //accesseur du second attribut
	    return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        if(getTaillePanier() <= i || i < 0){ return null;}
        else{ return this.getFruits().get(i); }
    }

    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if(getFruit(i) != null){
            this.getFruits().set(i, f);
        }
    }

    public boolean estVide(){  //predicat indiquant que le panier est vide
	    return getTaillePanier() == 0;
    }

    public boolean estPlein(){  //predicat indiquant que le panier est plein
  return this.getTaillePanier() == this.getContenanceMax();
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein

        if(!estPlein()){this.getFruits().add(o);}

    }


    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide

      if(this.fruits.isEmpty()){
        throw new PanierVideException();
      }
      else
        this.fruits.remove(this.fruits.size()-1);


    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	     return 0;
    }

    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine

    }

    //groupe 8
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        return false;
    }

    //tests
    public static void main (String[] args) throws Exception{
    	//Ecrire ici vos tests

        Panier P = new Panier(69);
        Fruit o = new Orange();
        Fruit p = new Pamplemousse();
	    System.out.println("premier test Panier");
        System.out.println(P.toString());
        try {
            P.ajout(o);
            P.ajout(p);
        }
        catch (PanierPleinException e) {
            e.printStackTrace();
        }
               
       System.out.println(P.toString());
       if (P.getContenanceMax() == 69) {System.out.println("TRUE");} else {System.out.println("FALSE");}




    }
}
