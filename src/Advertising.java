
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Advertising {
    static List<Sommet> listSommet = new ArrayList<>();
    static List<Rue> listArete = new ArrayList<>();
    static List <String> printArete= new ArrayList<>();
    static List<String> outputPrint = new ArrayList<>();
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Fournissez les noms des fichiers d'entrée et de sortie.");
            return;
        }
        String inputFile= "./src/OutInFile/" + args[0];
        String outputFile = "./src/OutInFile/" + args[1];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader .readLine()) != null) {
                //si une ligne  commence  par une lettre et que la longueur de la ligne >=6
                // alors c'est surement une rue (une arête)
                if (line.length() <= 4 && (Character.isLetter(line.charAt(0)))){
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
                    Rue rue = new Rue(nomArete,sommetDepart,sommetArrivee,poidsArete);
                    //ajoute a chaque rue (arête)ses deux sommets(de départ et d'arrivé)
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

            //le sommet de depart choisit est le premier élément de notre liste de sommets
            Sommet startSommet = listSommet.get(0);
            startSommet.setVisited(true);
            PriorityQueue<Rue> ruePriorityQueue = new PriorityQueue<>();
            //on ajoute tous les arêtes de notre sommet de départ à notre priorityQueue en suivant une  priorité
            //lié au poids ensuite a l'ordre alphanumerique
            for (Rue rue: startSommet.getRueConnecte()){
                ruePriorityQueue.add(rue);
            }
            int compteur = 0;
            int poids = 0;
            //implementation l’algorithme de Prim-Jarnik.
            while (!(ruePriorityQueue.isEmpty()) ) {
                Rue ruePrise = ruePriorityQueue.poll();
                compteur +=1;
                //si les deux sommets sont déjà visités la condition permet d'ignorer l'arête
                if ((ruePrise.getSommetArrivee().isVisited()) && (ruePrise.getSommetDepart().isVisited())) {
                    continue;
                }
                //changer la valeur du sommet courant en True
                ruePrise.setVisited(true);
               try (BufferedWriter writerSommet = new BufferedWriter(new FileWriter(outputFile, true))) {
                   //la condition permet écrire les sommets selon leurs ordres de lecture et si un sommet de depart
                   //est déjà lu alors on écrit le sommet d'arrivé
                   String printAreteString = ruePrise.getSommetDepart().getSommet();
                   boolean b = !(printArete.contains(printAreteString));
                   if (b) {
                        printArete.add(printAreteString);
                        writerSommet.write(printAreteString);
                        writerSommet.newLine();
                   }else{
                       printAreteString=ruePrise.getSommetArrivee().getSommet();
                       printArete.add(printAreteString);
                       writerSommet.write(printAreteString);
                       writerSommet.newLine();
                   }
                } catch (IOException e) {
                throw new RuntimeException(e);
                }
               //instancie avec un constructeur vide le prochain sommet pour éviter de prendre un sommet déjà
               //visité
                Sommet prochainSommet = new Sommet();
               //condition pour vérifier si le prochain sommet est déjà visité
                //si oui prendre le sommet d'arrivé
                if (ruePrise.getSommetArrivee().isVisited()) {
                    prochainSommet = ruePrise.getSommetDepart();
                } else {
                    prochainSommet = ruePrise.getSommetArrivee();
                }
                //changer la valeur du sommet de départ en True
                prochainSommet.setVisited(true);
                //les arête sont les rues ainsi on ajoute dans la priorityqueue,les rues qui n'ont pas encore été
                //visité avec comme sommet courant,le prochain sommet de notre sommet precedent
                for (Rue rue: prochainSommet.getRueConnecte()){
                    if (!(rue.isVisited())){
                        ruePriorityQueue.add(rue);
                    }
                }
                //itération du chemin déjà parcouru
                poids += ruePrise.getPoidsArete();
                //ajoute les informations lies a la rue dans une liste afin d'obtenir une sortie:
                //nom sommet + rue a chaque itération
                //mais sommets  ensuite toutes les rues
                outputPrint.add(ruePrise.getNomArete() +"  "+ ruePrise.getSommetDepart().getSommet() +
                        "  "+ ruePrise.getSommetArrivee().getSommet()+ "  " + ruePrise.getPoidsArete());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
                writer.write("---");
                writer.newLine();
                for (String element : outputPrint) {
                    writer.write(element);
                    writer.newLine();
                }
                writer.write("---");
                writer.newLine();
                writer.write(String.valueOf(poids));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


