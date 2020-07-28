public class Client {
    private String nom;
    private String adresse;
    private String email;
    private String codePostal;
    private String numero;
    private String province;
    private String ville;

    public Client(String nom, String adresse, String email, String codePostal, String numero, String ville, String province) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.email = email;
        this.nom = nom;
        this.numero = numero;
        this.ville = ville;
        this.province = province;
    }

    public Client(String nom, String adresse, String email, String codePostal, String ville, String province) {
    }

    public String getContenu(String champ){
        String val = "";
        switch (champ) {
         case "nom":
             val = this.nom;
             break;
         case "adresse":
             val = this.adresse;
             break;
         case "email":
             val = this.email;
             break;
         case "codePostal":
             val = this.codePostal;
             break;
         case "numero":
             val = this.numero;
             break;
         case "ville":
             val = this.ville;
             break;
         case "province":
             val = this.province;
             break;
     }
         return val;
    }

    public void setContenu(String champ, String value){
        String val = "";
        switch(champ) {
           case "nom":
               val = value;
               break;
           case "adresse":
               val = value;
               break;
           case "email":
               val = value;
               break;
           case "codePostal":
               val = value;
               break;
           case "numero":
               val = value;
               break;
           case "ville":
               val = value;
               break;
           case "province":
               val = value;
               break;
       }
    }

}
