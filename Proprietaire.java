import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Proprietaire implements Serializable {
    private String nom;
    private String email;
    private List<Objet> objetsPossedes;

    public Proprietaire(String nom, String email) {
        this.nom = nom;
        this.email = email;
        this.objetsPossedes = new ArrayList<>();
    }

    public void ajouterObjet(Objet obj) {
        objetsPossedes.add(obj);
    }

    // Getters

    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public List<Objet> getObjetsPossedes() { return objetsPossedes; }

    @Override
    public String toString() {
        return nom + " | " + email;
    }
}
