import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Han
 */
class ClientControlTest {
    ClientControl clientControl = new ClientControl();

    @Test
    public void ajoutMembre() {
        String numMembre1 = clientControl.ajoutMembre("Maxime Lapoutine", "3200 rue Jean-Brillant", "Montreal", "QC", "H3T 1N8", "max@gmail.com");
        assertEquals("Maxime Lapoutine", clientControl.getMembre(numMembre1).getContenu("nom"));
    }

    @Test
    void ajoutPro() {
        String numPro1 = clientControl.ajoutPro("Frank Leclair", "2047 rue Ontario Ouest", "Montreal", "QC", "H2X 1Y8", "frank@gmail.com");
        assertEquals("Frank Leclair", clientControl.getPro(numPro1).getContenu("nom"));
    }

    @Test
    void modifierMembre() {
        String numMembre2 = clientControl.ajoutMembre("Han LaZhang", "3460 Place Decelles", "Montreal", "QC", "H3S 1X4", "han@gmail.com");
        clientControl.modifierMembre(numMembre2, "email", "hanzhang@gmail.com");
        assertEquals("hanzhang@gmail.com", clientControl.getMembre(numMembre2).getContenu("email"));
    }

    @Test
    void modifierPro() {
        String numPro2 = clientControl.ajoutPro("Greg  Watkins", "291 Queens Sq", "Toronto", "ON", "N3C 1H3", "greg@gmail.com");
        clientControl.modifierPro(numPro2, "adresse", "1832 Carlson Road");
        assertEquals("1832 Carlson Road", clientControl.getPro(numPro2).getContenu("adresse"));
    }

    @Test
    void supMembre() {
        String numMembre3 = clientControl.ajoutMembre("Ruth  Goff", "2804 Campsite Road", "Montreal", "QC", "H2X 1Y8", "ruth@gmail.com");
        clientControl.supMembre(numMembre3);
        assertFalse(clientControl.validationNumM(numMembre3));
    }

    @Test
    void supPro() {
        String numPro3 = clientControl.ajoutPro("Irene Harris", "814 rue Levy", "Montreal", "QC", "H3C 5K4", "irene@gmail.com");
        clientControl.supPro(numPro3);
        assertFalse(clientControl.validationNumP(numPro3));
    }

    @Test
    void validationAcces() {
        String numMembre4 = clientControl.ajoutMembre("Mary Foreman", "2971 Papineau Avenue", "Montreal", "QC", "H2K 4J5", "mary@gmail.com");
        assertEquals("Validé.\nBonjour, Mary Foreman.", clientControl.validationAcces(numMembre4, "mary@gmail.com"));
    }
}