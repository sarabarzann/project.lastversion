package club.system;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Session {
    private String sessionName;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private Coach instructor;
    private int maxParticipants;
    private ArrayList<Players> participants;

    public Session() {
        this.participants = new ArrayList<>();
    }

    public void setSessionDetails(String sessionName, String startTime, String endTime, Coach instructor, int maxParticipants) {
        this.sessionName = sessionName;
        this.date = LocalDate.now();
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructor = instructor;
        this.maxParticipants = maxParticipants;
    }

    public void input(Scanner scanner, boolean isSample) {
        System.out.print("Enter Session Name: ");
        sessionName = scanner.nextLine();
        System.out.print("Enter Start Time (HH:mm): ");
        startTime = scanner.nextLine();
        System.out.print("Enter End Time (HH:mm): ");
        endTime = scanner.nextLine();
        System.out.print("Enter Max Participants: ");
        maxParticipants = scanner.nextInt(); // Reading integer directly
        scanner.nextLine(); // Consume the leftover newline

        if (!isSample) {
            System.out.print("Enter Instructor Name: ");
            String instructorName = scanner.nextLine();
            instructor = new Coach();
            instructor.setMemberDetails(instructorName, "No Contact");
        } else {
            instructor = null; 
        }

        setSessionDetails(sessionName, startTime, endTime, instructor, maxParticipants);
    }

    @Override
    public String toString() {
        return "Session Name: " + sessionName 
                + "\nDate: " + date 
                + "\nStart Time: " + startTime 
                + "\nEnd Time: " + endTime 
                + "\nInstructor: " + (instructor != null ? instructor.getName() : "Not Assigned") 
                + "\nMax Participants: " + maxParticipants 
                + "\nParticipants Count: " + participants.size();
    }
}
