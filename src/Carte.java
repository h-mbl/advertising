import java.util.ArrayList;


public class Carte {
    private ArrayList<String> sommets;
    private ArrayList<Rue> rue;

    public Carte(ArrayList<String> sommets, ArrayList<Rue> rue) {
        this.sommets = sommets;
        this.rue = rue;
    }

    public ArrayList<String> getSommets() {
        return sommets;
    }

    public void setSommets(ArrayList<String> sommets) {
        this.sommets = sommets;
    }

    public ArrayList<Rue> getRue() {
        return rue;
    }

    public void setRue(ArrayList<Rue> rue) {
        this.rue = rue;
    }
}
