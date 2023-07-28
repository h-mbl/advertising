public class Rue {
    private String nomArete;
    private String sommetDepart;
    private String sommetArrivee;
    private int poidsArete;

    public Rue(String nomArete, String sommetDepart, String sommetArrivee, int poidsArete) {
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

    public int getPoidsArete() {
        return poidsArete;
    }

    public void setPoidsArete(int poidsArete) {
        this.poidsArete = poidsArete;
    }
}
