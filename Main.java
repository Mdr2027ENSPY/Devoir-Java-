import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        super("Application - Objets Volés");

        // Look & Feel Nimbus
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Titre stylisé
        JLabel titre = new JLabel("Bienvenue dans l'application", SwingConstants.CENTER);
        titre.setFont(new Font("SansSerif", Font.BOLD, 18));
        titre.setForeground(new Color(44, 62, 80));

        // Boutons
        JButton boutonRecherche = new JButton("🔍 Rechercher un objet");
        JButton boutonAjout = new JButton("➕ Déclarer un objet");

        // Style des boutons
        Font fontBtn = new Font("SansSerif", Font.BOLD, 14);
        Color bgBtn = new Color(52, 152, 219);
        Color fgBtn = Color.WHITE;

        boutonRecherche.setFont(fontBtn);
        boutonRecherche.setBackground(bgBtn);
        boutonRecherche.setForeground(fgBtn);
        boutonRecherche.setFocusPainted(false);

        boutonAjout.setFont(fontBtn);
        boutonAjout.setBackground(new Color(46, 204, 113));
        boutonAjout.setForeground(fgBtn);
        boutonAjout.setFocusPainted(false);

        // Actions
        boutonRecherche.addActionListener(e -> new InterfaceRecherche().setVisible(true));
        boutonAjout.addActionListener(e -> new InterfaceAjoutObjet().setVisible(true));

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(236, 240, 241));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonRecherche.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonAjout.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titre);
        panel.add(Box.createVerticalStrut(30));
        panel.add(boutonRecherche);
        panel.add(Box.createVerticalStrut(20));
        panel.add(boutonAjout);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
