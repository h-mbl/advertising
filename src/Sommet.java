
import java.util.List;

public class Sommet  {
    private String nomSommet;
    private boolean visited;

    private List<Rue> rueConnecte;

    public Sommet() {
    }

    public Sommet(String nomSommet, boolean visited, List<Rue> rueConnecte) {
        //nom du sommet
        this.nomSommet = nomSommet;
        this.visited = visited;
        this.rueConnecte = rueConnecte;
    }

    public String getNomSommet() {
        return nomSommet;
    }
    public List<Rue> getRueConnecte() {
        return rueConnecte;
    }


    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Sommet(String nomSommet, boolean visited) {
        this.nomSommet = nomSommet;
        this.visited = visited;
    }
    public void addRue(Rue rue){
        rueConnecte.add(rue);
    }

    @Override
    public String toString() {
        return "Sommet{" +
                "sommet='" + nomSommet + '\'' +
                ", visited=" + visited +
                ", rueConnecte=" + rueConnecte +
                '}';
    }
}
