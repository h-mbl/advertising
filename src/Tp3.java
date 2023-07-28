import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                    Sommet sommet= new Sommet(line, false);
                    listSommet.add(sommet);
                }
                else if(Character.isLetter(line.charAt(0))) {
                    line = line.replace(";", "");
                    line = line.replace(":", "");
                    line = line.trim().replaceAll("\\s+", " ");
                    String[] newLine = line.split(" ");
                    String nomArete = newLine[0];
                    String sommetDepart = newLine[1];
                    String sommetArrivee = newLine[2];
                    int poidsArete = Integer.parseInt(newLine[3]);
                    Rue rue = new Rue(nomArete,sommetDepart,sommetArrivee,poidsArete);
                    listArete.add(rue);
                }
            }
            Carte carte = new Carte((ArrayList<Sommet>) listSommet, (ArrayList<Rue>) listArete);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


