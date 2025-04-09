import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfaceAjoutObjet extends JFrame {

    private JTextField champNom, champEmail, champId, champType;
    private JTextArea champDescription;
    private JCheckBox checkVole;
    private BaseDeDonnees base;

    public InterfaceAjoutObjet() {
        super("Déclaration d’objet");

        base = new BaseDeDonnees();
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        champNom = new JTextField(20);
        champEmail = new JTextField(20);
        champId = new JTextField(15);
        champType = new JTextField(15);
        champDescription = new JTextArea(4, 20);
        champDescription.setLineWrap(true);
        checkVole = new JCheckBox("Objet déclaré volé");

        JButton boutonAjouter = new JButton("Ajouter");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nom du propriétaire :"));
        panel.add(champNom);
        panel.add(new JLabel("Email du propriétaire :"));
        panel.add(champEmail);
        panel.add(new JLabel("Type d’objet :"));
        panel.add(champType);
        panel.add(new JLabel("ID de l’objet :"));
        panel.add(champId);
        panel.add(new JLabel("Description :"));
        panel.add(new JScrollPane(champDescription));
        panel.add(checkVole);
        panel.add(boutonAjouter);

        add(panel);

        boutonAjouter.addActionListener((ActionEvent e) -> {
            ajouterObjet();
        });
    }

    private void ajouterObjet() {
        String nom = champNom.getText().trim();
        String email = champEmail.getText().trim();
        String id = champId.getText().trim();
        String type = champType.getText().trim();
        String desc = champDescription.getText().trim();
        boolean vole = checkVole.isSelected();

        if (nom.isEmpty() || email.isEmpty() || id.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous les champs sauf la description sont obligatoires.");
            return;
        }

        if (base.rechercherParId(id) != null) {
            JOptionPane.showMessageDialog(this, "Un objet avec cet ID existe déjà.");
            return;
        }

        Proprietaire prop = new Proprietaire(nom, email);
        Objet obj = new Objet(id, type, desc, vole, prop);
        prop.ajouterObjet(obj);
        base.ajouterObjet(obj);

        JOptionPane.showMessageDialog(this, "Objet ajouté avec succès !");
        dispose(); // Ferme la fenêtre après ajout
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceAjoutObjet().setVisible(true));
    }
}
