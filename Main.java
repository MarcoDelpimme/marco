import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FunzioniUtente funzioniUtente = new FunzioniUtente();
        boolean exit = false;
        Utente utenteRegister = new Utente();
        System.out.println("Benvenuto, cosa vuoi fare?");
        while (!exit) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Visualizza utenti");
            System.out.println("4. Logout");
            System.out.println("5. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci username: ");
                    utenteRegister.setUsername(scanner.nextLine());
                    System.out.println("Inserisci password: ");
                    utenteRegister.setPassword(scanner.nextLine());
                    funzioniUtente.registra(utenteRegister);
                    break;
                case 2:
                    int sceltaTask;
                    Utente utenteLogin = new Utente();
                    boolean exitFromTasks = false;
                    // Task task = new Task();
                    System.out.println("Inserisci username: ");
                    utenteLogin.setUsername(scanner.nextLine());
                    System.out.println("Inserisci password: ");
                    String passwordLogin = scanner.nextLine();
                    utenteLogin.setPassword(passwordLogin);
                    boolean login = funzioniUtente.login(utenteLogin, passwordLogin);
                    if (login) {
                        while (!exitFromTasks) {
                            String task;
                            System.out.println("1. Aggiungi task");
                            System.out.println("2. Rimuovi Task");
                            System.out.println("3. Visualizza task");
                            System.out.println("4. Esci");
                            sceltaTask = scanner.nextInt();
                            scanner.nextLine();
                            // while (!exitFromTasks) {
                            switch (sceltaTask) {
                                case 1:
                                    System.out.println("Inserisci task: ");
                                    task = scanner.nextLine();
                                    funzioniUtente.aggiungiTask(utenteLogin, task);
                                    break;
                                case 2:
                                    System.out.println("Inserisci task: ");
                                    task = scanner.nextLine();
                                    funzioniUtente.rimuoviTask(utenteLogin, task);
                                    break;
                                case 3:
                                    funzioniUtente.visualizzaTask(utenteLogin); // TODO DA AGGIUSTARE
                                    break;
                                case 4:
                                    exitFromTasks = true;
                                    System.out.println("Esci dalle task.");
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    funzioniUtente.visualizzaUtenti();
                    break;
                case 4:
                    Utente utenteLogout = new Utente();
                    System.out.println("Inserisci username: ");
                    String username = scanner.nextLine();
                    utenteLogout.setUsername(username);
                    System.out.println("Inserisci password: ");
                    String passwordLogout = scanner.nextLine();
                    utenteLogout.setPassword(passwordLogout);
                    funzioniUtente.logout(utenteLogout, passwordLogout);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Arrivederci");
                    break;
            }
        }
    }
}
