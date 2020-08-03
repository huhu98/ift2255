public class Presence {
    private boolean present;
    private String code;
    private String numM;
    private String numPro;
    private String comment;

    // TODO
    public Presence(boolean present, String code, String numM, String numPro) {
        this.present = present;
        this.code = code;
        this.numM = numM;
        this.numPro = numPro;
    }
    // pas sur

    public boolean isPresent() {
        present = true;
        return present;
    }

    public boolean notPresent() {
        present = false;
        return present;
    }

    public boolean getPresence(boolean present) {
        return present;
    }

    public void setPresence(String present, boolean state) {
        switch (present) {
            case "oui":
                isPresent();
                break;
            case "non":
                notPresent();
                break;
        }
    }

}
