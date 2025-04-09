import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnees {
    private static final String FICHIER = "objets.dat";
    private List<Objet> objets;

    public BaseDeDonnees() {
        objets = charger();
    }

    @SuppressWarnings("unchecked")
    private List<Objet> charger() {
        File fichier = new File(FICHIER);
        if (!fichier.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            return (List<Objet>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void sauvegarder() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHIER))) {
            oos.writeObject(objets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterObjet(Objet obj) {
        objets.add(obj);
        sauvegarder();
    }

    public Objet rechercherParId(String id) {
        for (Objet o : objets) {
            if (o.getId().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

    public List<Objet> getObjets() {
        return objets;
    }
}
