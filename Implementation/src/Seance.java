public class Seance {

    private String date;
    private Services services;
    private String codeSeance;
    private String[] inscriptions = new String[30];
    private String[] presences = new String[30];

    public void Seance(Services services, String date, String codeSeance, String[] inscriptions, String[] presences) {
        this.date = date;
        this.codeSeance = codeSeance;
        this.presences = presences;
        this.inscriptions = inscriptions;
        this.services = services;

    }
    public void ajoutPresence(String numM) {
        for (int i = 0; i <= presences.length; i++) {
            presences[i] = numM;
        }
    }

    public void ajoutInscrit(String numM) {
        for (int i = 0; i <= inscriptions.length; i++) {
            inscriptions[i] = numM;
        }
    }
    public String getContenu(String champ) {
        String value = "";
        switch (champ) {
            case "presences":
                value = presences.toString();
                break;
            case "inscriptions":
                value = inscriptions.toString();
                break;
            case "date":
                value = date;
                break;
            case "codeSeance":
                value = codeSeance;
                break;
            case "services":
                value = services.toString();
        }
        return value;
    }
}
