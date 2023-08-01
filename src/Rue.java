
public class Rue implements Comparable<Rue>{
    private String nomArete;
    private Sommet sommetDepart;
    private Sommet sommetArrivee;
    private int poidsArete;
    private boolean visited;
    // une rue est une arête
    public Rue(String nomArete, Sommet sommetDepart, Sommet sommetArrivee, int poidsArete) {
        this.nomArete = nomArete;
        this.sommetDepart = sommetDepart;
        this.sommetArrivee = sommetArrivee;
        this.poidsArete = poidsArete;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getNomArete() {
        return nomArete;
    }

    public Sommet getSommetDepart() {
        return sommetDepart;
    }

    public void setSommetDepart(Sommet sommetDepart) {
        this.sommetDepart = sommetDepart;
    }

    public Sommet getSommetArrivee() {
        return sommetArrivee;
    }

    public void setSommetArrivee(Sommet sommetArrivee) {
        this.sommetArrivee = sommetArrivee;
    }

    public int getPoidsArete() {
        return poidsArete;
    }

    //comparateur pour la priorityqueue
    @Override
    public int compareTo(Rue other) {
        int weightComparison = Integer.compare(this.poidsArete, other.poidsArete);
        if (weightComparison != 0) {
            return weightComparison;
        } else {
            int sommetArriveeComparison = this.sommetArrivee.getSommet().compareTo(other.sommetArrivee.getSommet());

            if (sommetArriveeComparison != 0) {
                return sommetArriveeComparison;
            } else {
                return this.sommetDepart.getSommet().compareTo(other.sommetDepart.getSommet());
            }
        }
    }

    @Override
    public String toString() {
        return "Rue{" +
                "nomArete='" + nomArete + '\'' +
                ", sommetDepart=" + sommetDepart.getSommet() +
                ", sommetArrivee=" + sommetArrivee.getSommet() +
                ", poidsArete=" + poidsArete +
                '}';
    }
}
