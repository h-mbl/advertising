import java.io.*;
import java.sql.SQLOutput;
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
        String inputFile= "./src/testsTP3E19/" + args[0];
        String outputFile = "./src/testsTP3E19/" + args[1];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader .readLine()) != null) {
                if (line.length() <= 2 && (Character.isLetter(line.charAt(0)))){
                    line = line.replace(" ","");
                    Sommet sommet= new Sommet(line, false, new ArrayList<Rue>());
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
                    System.out.println(sommetArrivee);
                    System.out.println(sommetDepart);
                    Rue rue = new Rue(nomArete,sommetDepart,sommetArrivee,poidsArete);
                    for (Sommet sommet: listSommet) {
                        if (sommet.getSommet().equals(sommetDepart.getSommet())){
                            sommet.addRue(rue);
                            rue.setSommetDepart(sommet);
                            break;
                        }
                    }
                    for (Sommet sommet: listSommet) {
                        if (sommet.getSommet().equals(sommetArrivee.getSommet())){
                            sommet.addRue(rue);
                            rue.setSommetArrivee(sommet);
                            break;
                        }
                    }
                    listArete.add(rue);
                }
            }

            Sommet startSommet = listSommet.get(0);
            startSommet.setVisited(true);
            PriorityQueue<Rue> ruePriorityQueue = new PriorityQueue<>();
            for (Rue rue: startSommet.getRueConnecte()){
                ruePriorityQueue.add(rue);
            }
            int compteur = 0;
            int poids = 0;
            while (compteur < listArete.size() && !(ruePriorityQueue.isEmpty()) ) {
                Rue ruePrise = ruePriorityQueue.poll();
                compteur +=1;
                if ((ruePrise.getSommetArrivee().isVisited()) && (ruePrise.getSommetDepart().isVisited())) {
                    continue;
                }
                ruePrise.setVisited(true);//
                Sommet prochainSommet = new Sommet();
                if (ruePrise.getSommetArrivee().isVisited()) {
                    prochainSommet = ruePrise.getSommetDepart();
                } else {
                    prochainSommet = ruePrise.getSommetArrivee();
                }
                prochainSommet.setVisited(true);
                for (Rue rue: prochainSommet.getRueConnecte()){
                    if (!(rue.isVisited())){
                        ruePriorityQueue.add(rue);
                    }
                }

                poids += ruePrise.getPoidsArete();
                try (BufferedWriter writerArm = new BufferedWriter(new FileWriter(outputFile, true))) {
                    writerArm.write(ruePrise.getNomArete() +" "+ ruePrise.getSommetDepart().getSommet() +
                           " "+ ruePrise.getSommetArrivee().getSommet()+ " " + ruePrise.getPoidsArete());
                    writerArm.newLine();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(poids);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


