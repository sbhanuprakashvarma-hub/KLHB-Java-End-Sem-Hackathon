
import java.util.ArrayList;

class Candidate {
    String name;
    long rollNumber;
    String position;
    int votes;

    
    Candidate() {
        name = "Unknown";
        rollNumber = 0;
        position = "Unknown";
        votes = 0;
    }

    
    Candidate(String name, long rollNumber, String position) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.position = position;
        this.votes = 0;
    }

    
    Candidate(String name, long rollNumber, String position, int votes) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.position = position;
        this.votes = votes;
    }

    
    void register() {
        display();
    }

    
    void register(int votes) {
        this.votes = votes;
        display();
    }

    
    void display() {
        System.out.println("\nCandidate Registered Successfully");
        System.out.printf("%-20s: %s%n",
                "Candidate Name", name.toUpperCase());
        System.out.printf("%-20s: %d%n",
                "Roll Number", rollNumber);
        System.out.printf("%-20s: %s%n",
                "Position", position.toUpperCase());
        System.out.printf("%-20s: %d%n",
                "Votes Received", votes);
    }
}

public class StudentCouncilElection {

    
    static boolean isDuplicate(ArrayList<Candidate> candidates,
                               String name) {
        for (Candidate c : candidates) {
            if (c.name.trim().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }

    
    static void announceWinner(ArrayList<Candidate> candidates,
                               String position) {
        Candidate winner = null;

        for (Candidate c : candidates) {
            if (c.position.equalsIgnoreCase(position)) {
                if (winner == null || c.votes > winner.votes) {
                    winner = c;
                }
            }
        }

        if (winner != null) {
            System.out.println("\n---------- ELECTION RESULTS ----------");
            System.out.printf("%-20s: %s%n",
                    "Position", position.toUpperCase());
            System.out.printf("%-20s: %s%n",
                    "Winning Candidate", winner.name.toUpperCase());
            System.out.printf("%-20s: %d%n",
                    "Total Votes", winner.votes);
            System.out.println("=============================================");
        } else {
            System.out.println("No candidates for " + position);
        }
    }

    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();

        System.out.println("========== STUDENT COUNCIL ELECTION ==========");

        
        Candidate c1 = new Candidate("Ananya", 101, "President", 125);
        Candidate c2 = new Candidate("Rahul", 102, "President", 98);

        
        if (!isDuplicate(candidates, c1.name)) {
            candidates.add(c1);
            c1.register();
        }

        
        if (!isDuplicate(candidates, c2.name)) {
            candidates.add(c2);
            c2.register();
        }

        
        String duplicateName = "ANANYA";

        System.out.println("\nDuplicate Candidate Check:");
        System.out.printf("%-20s: %s%n",
                "Candidate Name", duplicateName);

        if (isDuplicate(candidates, duplicateName)) {
            System.out.printf("%-20s: %s%n",
                    "Status", "Duplicate Nomination");
        } else {
            System.out.printf("%-20s: %s%n",
                    "Status", "New Nomination");
        }

        
        announceWinner(candidates, "President");
    }
}
