import java.util.List;

public class Sommet  {
    private String sommet;
    private boolean visited;

    private List<Rue> rueConnecte;

    public Sommet() {
    }

    public Sommet(String sommet, boolean visited, List<Rue> rueConnecte) {
        this.sommet = sommet;
        this.visited = visited;
        this.rueConnecte = rueConnecte;
    }

    public String getSommet() {
        return sommet;
    }
    public List<Rue> getRueConnecte() {
        return rueConnecte;
    }


    public void setSommet(String sommet) {
        this.sommet = sommet;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Sommet(String sommet, boolean visited) {
        this.sommet = sommet;
        this.visited = visited;
    }
    public void addRue(Rue rue){
        rueConnecte.add(rue);
    }

    public void printRue(){
        for (Rue rue: rueConnecte){
            System.out.println(rue.getNomArete());
        }
    }

    @Override
    public String toString() {
        return "Sommet{" +
                "sommet='" + sommet + '\'' +
                ", visited=" + visited +
                ", rueConnecte=" + rueConnecte +
                '}';
    }
}
