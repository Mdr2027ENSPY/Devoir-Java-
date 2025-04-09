import java.io.Serializable;

public class Objet implements Serializable {
    private String id;
    private String type;
    private String description;
    private boolean estVole;
    private Proprietaire proprietaire;

    public Objet(String id, String type, String description, boolean estVole, Proprietaire proprietaire) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.estVole = estVole;
        this.proprietaire = proprietaire;
    }

    // Getters et setters

    public String getId() { return id; }
    public boolean isEstVole() { return estVole; }
    public Proprietaire getProprietaire() { return proprietaire; }

    @Override
    public String toString() {
        return type + " | ID : " + id + " | Volé : " + estVole + "\nDescription : " + description;
    }
}
