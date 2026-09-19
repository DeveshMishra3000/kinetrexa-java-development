import java.util.*;

class Student {
    private int id;
    private String name;
    private String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Department: " + department;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Aarav Sharma", "Computer Science"));
        students.add(new Student(102, "Rohan Verma", "Information Tech"));

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. View All Students\n2. Add Student\n3. Search Student\n4. Delete Student\n5. Exit");
            System.out.print("Enter choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            if (choice == 1) {
                if (students.isEmpty()) System.out.println("No records found.");
                else students.forEach(System.out::println);
            } else if (choice == 2) {
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Department: ");
                String dept = scanner.nextLine();
                students.add(new Student(id, name, dept));
                System.out.println("Student added successfully!");
            } else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int searchId = Integer.parseInt(scanner.nextLine());
                students.stream().filter(s -> s.getId() == searchId).findFirst()
                    .ifPresentOrElse(System.out::println, () -> System.out.println("Student not found."));
            } else if (choice == 4) {
                System.out.print("Enter ID to delete: ");
                int delId = Integer.parseInt(scanner.nextLine());
                students.removeIf(s -> s.getId() == delId);
                System.out.println("Operation completed.");
            } else if (choice == 5) {
                System.out.println("Exiting application.");
                break;
            }
        }
        scanner.close();
    }
}
