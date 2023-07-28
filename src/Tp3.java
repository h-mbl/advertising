import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class Tp3 {
    static List<Sommet> listSommet = new ArrayList<>();
    static List<Rue> listArete = new ArrayList<>();
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Fournissez les noms des fichiers d'entrée et de sortie.");
            return;
        }
        String inputFileCarte= "./src/testsTP3E19/" + args[0];
        String outputFileArm = "./src/testsTP3E19/" + args[1];
        try (FileReader fileReader = new FileReader(inputFileCarte);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader .readLine()) != null) {
                if (line.length() <= 2 && (Character.isLetter(line.charAt(0)))){
                    line = line.replace("\\s+","");
                    Sommet sommet= new Sommet(line, false);
                    listSommet.add(sommet);
                }
                else if(Character.isLetter(line.charAt(0))) {
                    line = line.replace(";", "");
                    line = line.replace(":", "");
                    line = line.trim().replaceAll("\\s+", " ");
                    String[] newLine = line.split(" ");
                    String nomArete = newLine[0];
                    Sommet sommetDepart = new Sommet(newLine[1], false);
                    Sommet sommetArrivee = new Sommet(newLine[2], false);
                    int poidsArete = Integer.parseInt(newLine[3]);
                    Rue rue = new Rue(nomArete,sommetDepart,sommetArrivee,poidsArete);
                    for (Sommet sommet: listSommet) {
                        System.out.println(sommet.getSommet().length());
                        System.out.println(sommetDepart.getSommet().length());
                        System.out.println("##############");
                        if (sommet.getSommet().equals(sommetDepart.getSommet())){
                            System.out.println(sommet.getSommet());
                            System.out.println(sommetDepart.getSommet());
                            System.out.println("---------------");
                            sommet.addRue(rue);
                        }
                    }
                    //System.out.println(sommetDepart.getRueConnecte());

                    listArete.add(rue);
                }
            }



            Carte carte = new Carte((ArrayList<Sommet>) listSommet, (ArrayList<Rue>) listArete);
            Sommet startSommet = listSommet.get(0);
            startSommet.setVisited(true) ;
            PriorityQueue<Sommet> sommetPriorityQueue = new PriorityQueue<>();
            /*sommetPriorityQueue.addAll((Collection<? extends Sommet>) startSommet);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


