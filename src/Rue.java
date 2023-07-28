public class Rue implements Comparable<Rue>{
    private String nomArete;
    private Sommet sommetDepart;
    private Sommet sommetArrivee;
    private int poidsArete;

    public Rue(String nomArete, Sommet sommetDepart, Sommet sommetArrivee, int poidsArete) {
        this.nomArete = nomArete;
        this.sommetDepart = sommetDepart;
        this.sommetArrivee = sommetArrivee;
        this.poidsArete = poidsArete;
    }

    public String getNomArete() {
        return nomArete;
    }

    public void setNomArete(String nomArete) {
        this.nomArete = nomArete;
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

    public void setPoidsArete(int poidsArete) {
        this.poidsArete = poidsArete;
    }
    @Override
    public int compareTo(Rue other) {
        return Integer.compare(this.poidsArete, other.poidsArete);
    }
}
