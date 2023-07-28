public class Sommet {
    private String sommet;
    private boolean visited;

    public String getSommet() {
        return sommet;
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
}
