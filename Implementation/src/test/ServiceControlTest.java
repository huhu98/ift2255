import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceControlTest {

    ServiceControl serviceControl = new ServiceControl();
    ClientControl clientControl = new ClientControl();

    @Test
    void ajoutService() {
        String numS = serviceControl.ajoutService("Badminton", "123456700", "20-08-2020", "30-08-2020", "10:00", "1", "10", "25", "");
        assertTrue(serviceControl.serviceExist(numS));
    }

    @Test
    void modifierService() {
        String numS = serviceControl.ajoutService("Badminton", "123456700", "20-08-2020", "30-08-2020", "10:00", "1", "10", "25", "");
        serviceControl.modifierService(numS, "debut", "21-08-2020");
        assertEquals("21-08-2020", serviceControl.getService(numS).getContenu("debut"));
    }

    @Test
    void supService() {
        String numS = serviceControl.ajoutService("Badminton", "123456700", "20-08-2020", "30-08-2020", "10:00", "1", "10", "25", "");
        serviceControl.supService(numS);
        assertFalse(serviceControl.serviceExist(numS));
    }

    @Test
    void inscritSeance() {
        String numS = serviceControl.ajoutService("Badminton", "123456700", "20-08-2020", "30-08-2020", "10:00", "1", "10", "25", "");
        String numMembre1 = clientControl.ajoutMembre("Maxime Lapoutine", "3200 rue Jean-Brillant", "Montreal", "QC", "H3T 1N8", "max@gmail.com");
        serviceControl.inscritSeance("numMembre1", numS + "0000");
        assertTrue(serviceControl.getRepInscrit().containsKey("numMembre1"));
    }

    @Test
    void confirmPresence() {
        String numS = serviceControl.ajoutService("Badminton", "123456700", "20-08-2020", "30-08-2020", "10:00", "1", "10", "25", "");
        String numMembre1 = clientControl.ajoutMembre("Maxime Lapoutine", "3200 rue Jean-Brillant", "Montreal", "QC", "H3T 1N8", "max@gmail.com");
        serviceControl.inscritSeance("numMembre1", numS + "0000");
        serviceControl.confirmPresence(numMembre1, numS + "0000");
        assertTrue(serviceControl.getRepFournie().containsKey(numS));
    }
}