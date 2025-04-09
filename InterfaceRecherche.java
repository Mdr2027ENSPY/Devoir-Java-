import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceRecherche extends JFrame {

    private JTextField champId;
    private JTextArea zoneResultat;
    private BaseDeDonnees base;

    public InterfaceRecherche() {
        super("Vérification d’objet volé");

        base = new BaseDeDonnees();

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        champId = new JTextField(20);
        JButton boutonVerifier = new JButton("Vérifier");
        zoneResultat = new JTextArea();
        zoneResultat.setEditable(false);
        zoneResultat.setLineWrap(true);

        JPanel panelHaut = new JPanel();
        panelHaut.add(new JLabel("ID de l’objet :"));
        panelHaut.add(champId);
        panelHaut.add(boutonVerifier);

        add(panelHaut, BorderLayout.NORTH);
        add(new JScrollPane(zoneResultat), BorderLayout.CENTER);

        boutonVerifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifierObjet();
            }
        });
    }

    private void verifierObjet() {
        String id = champId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un identifiant.");
            return;
        }

        Objet obj = base.rechercherParId(id);
        if (obj != null) {
            zoneResultat.setText(obj.toString());
            if (obj.isEstVole()) {
                JOptionPane.showMessageDialog(this,
                        "⚠ Cet objet est déclaré volé !\nPropriétaire : " +
                                obj.getProprietaire().getNom() +
                                "\nEmail : " + obj.getProprietaire().getEmail(),
                        "Alerte",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            zoneResultat.setText("❌ Objet non trouvé.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceRecherche().setVisible(true));
    }
}
