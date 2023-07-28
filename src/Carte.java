import java.util.ArrayList;


public class Carte {
    private boolean visited;
    private ArrayList<Sommet> sommets;
    private ArrayList<Rue> rue;

    public Carte(ArrayList<Sommet> sommets, ArrayList<Rue> rue) {
        this.sommets = sommets;
        this.rue = rue;
    }

    public ArrayList<Sommet> getSommets() {
        return sommets;
    }

    public void setSommets(ArrayList<Sommet> sommets) {
        this.sommets = sommets;
    }

    public ArrayList<Rue> getRue() {
        return rue;
    }

    public void setRue(ArrayList<Rue> rue) {
        this.rue = rue;
    }
}
