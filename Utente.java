import java.util.ArrayList;

public class Utente {
    public String username;
    public String password;
    public ArrayList<Task> tasks;

    public Utente(String username, String password) {
        this.username = username;
        this.password = password;
        this.tasks = new ArrayList<>();
    }

    public Utente() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void addTask(String task) {
            tasks.add(new Task(task));
    }

    public void removeTask(String task) {
            tasks.remove(new Task(task));
    }

    public void viewAllTasks() {
        //TODO da aggiustare per il null
        if (tasks.isEmpty() || tasks == null) {
        System.out.println("Nessuna task.");
        } else {
        for (Task task : tasks) {
        System.out.println(username + " le tue tasks sono: " +
        task.getDescrizione());
        }
        }
    }
}
