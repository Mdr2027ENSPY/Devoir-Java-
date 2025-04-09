public class AlerteService {
    public static void notifierProprietaire(Objet objet) {
        Proprietaire proprietaire = objet.getProprietaire();
        System.out.println("⚠️ Alerte : cet objet est volé !");
        System.out.println("Propriétaire : " + proprietaire.getNom() + " | Email : " + proprietaire.getEmail());
    }
}
