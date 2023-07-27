public class Rue {
    private String nomArete;
    private String sommetDepart;
    private String sommetArrivee;
    private int poidAret;

    public Rue(String nomArete, String sommetDepart, String sommetArrivee, int poidAret) {
        this.nomArete = nomArete;
        this.sommetDepart = sommetDepart;
        this.sommetArrivee = sommetArrivee;
        this.poidAret = poidAret;
    }

    public String getNomArete() {
        return nomArete;
    }

    public void setNomArete(String nomArete) {
        this.nomArete = nomArete;
    }

    public String getSommetDepart() {
        return sommetDepart;
    }

    public void setSommetDepart(String sommetDepart) {
        this.sommetDepart = sommetDepart;
    }

    public String getSommetArrivee() {
        return sommetArrivee;
    }

    public void setSommetArrivee(String sommetArrivee) {
        this.sommetArrivee = sommetArrivee;
    }

    public int getPoidAret() {
        return poidAret;
    }

    public void setPoidAret(int poidAret) {
        this.poidAret = poidAret;
    }
}
