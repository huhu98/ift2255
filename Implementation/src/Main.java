public class Main {

    public static void main(String[] args) {
        ClientControl cc = new ClientControl();
        ServiceControl sc = new ServiceControl();
        Menu m = new Menu(cc, sc);
        m.menuMain();
    }
}
