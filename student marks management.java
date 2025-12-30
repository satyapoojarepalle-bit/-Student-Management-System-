import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

// Main class
public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Add student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    // Search student by ID
    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int searchId = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == searchId) {
                System.out.println("Student found:");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // Calculate average marks
    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate average!");
            return;
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.marks;
        }

        double avg = sum / students.size();
        System.out.println("Average Marks: " + avg);
    }
}
