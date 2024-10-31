import java.util.ArrayList;

public class FunzioniUtente {
    ArrayList<Utente> utenti;

    public FunzioniUtente() {
        utenti = new ArrayList<>();
        utenti.add(new Utente("admin", "admin"));
    }

    public void registra(Utente utente) {
        boolean userFound = getUserByUsername(utente);
        if (userFound) {
            System.out.println("\n -- Utente gia' registrato. --");
        } else {
            utenti.add(utente);
            System.out.println("\n -- Utente registrato. --");
        }
    }

    public boolean login(Utente utente, String password) {
        boolean userFound = getUserByUsername(utente);
        if (userFound) {
            System.out.println("\n -- Login effettuato. --");
            return true;
        } else {
            System.out.println("\n -- Credenziali non valide. --");
            return false;
        }
    }

    public boolean getUserByUsername(Utente utente) {
        boolean userFound = false;
        for (int i = 0; i < utenti.size(); i++) {
            if (utenti.get(i).getUsername().equals(utente.getUsername())) {
                userFound = true;
            } else {
                userFound = false;
            }
        }
        return userFound;
    }

    public void aggiungiTask(Utente utente, String task) {
        boolean userFound = getUserByUsername(utente);
        if (userFound) {
            utente.addTask((task));
            System.out.println("\n -- Task " + task + " aggiunto. --");
        } else {
            System.out.println("\n -- Utente non trovato. --");
        }
    }

    public void rimuoviTask(Utente utente, String task) {
        boolean userFound = getUserByUsername(utente);
        if (userFound) {
            utente.removeTask(task);
            System.out.println("\n -- Task " + task + " rimossa. --");
        } else {
            System.out.println("\n -- Utente non trovato. --");
        }
    }

    public void visualizzaTask(Utente utente) {
        boolean userFound = getUserByUsername(utente);
        if (userFound) {
            utente.viewAllTasks();
        } else {
            System.out.println("\n -- Utente non trovato. --");
        }
    }

    public boolean logout(Utente utente, String password) {
        boolean userFound = false;
        for (int i = 0; i < utenti.size(); i++) {
            if (utenti.get(i).getUsername().equals(utente.getUsername()) && utenti.get(i).checkPassword(password)) {
                userFound = true;
            } else {
                userFound = false;
            }
        }
        if (userFound) {
            System.out.println("\n -- Logout effettuato. --");
            return true;
        } else {
            System.out.println(" -- Credenziali non valide. --");
            return false;
        }
    }

    public void visualizzaUtenti() {
        System.out.println("\n -- Utenti registrati: ");
        for (Utente utente : utenti) {
            System.out.println("| " + utente.getUsername() + " |");
        }
    }
}