import java.util.*;

class Book {
    private int id;
    private String title;
    private boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean status) { this.isIssued = status; }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Status: " + (isIssued ? "Issued" : "Available");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Core Java Volume I"));
        books.add(new Book(2, "Data Structures in Java"));

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. View Catalog\n2. Add Book\n3. Issue Book\n4. Return Book\n5. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            if (choice == 1) {
                books.forEach(System.out::println);
            } else if (choice == 2) {
                System.out.print("Enter Book ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                books.add(new Book(id, title));
                System.out.println("Book cataloged!");
            } else if (choice == 3) {
                System.out.print("Enter Book ID to issue: ");
                int id = Integer.parseInt(scanner.nextLine());
                books.stream().filter(b -> b.getId() == id).findFirst().ifPresentOrElse(b -> {
                    if (b.isIssued()) System.out.println("Already issued!");
                    else { b.setIssued(true); System.out.println("Book issued successfully!"); }
                }, () -> System.out.println("Book not found."));
            } else if (choice == 4) {
                System.out.print("Enter Book ID to return: ");
                int id = Integer.parseInt(scanner.nextLine());
                books.stream().filter(b -> b.getId() == id).findFirst().ifPresentOrElse(b -> {
                    b.setIssued(false);
                    System.out.println("Book returned successfully!");
                }, () -> System.out.println("Book not found."));
            } else if (choice == 5) {
                break;
            }
        }
        scanner.close();
    }
}
