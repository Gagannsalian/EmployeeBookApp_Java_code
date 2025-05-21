import java.util.Scanner;

enum MaritalStatus {
    MARRIED, UNMARRIED
}


class Employee {
    int id;
    String name;
    String department;
    String designation;
    String dateOfJoining;
    String dateOfBirth;
    MaritalStatus maritalStatus;
    String dateOfMarriage;

   
    public void enterData(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Department: ");
        department = sc.nextLine();

        System.out.print("Enter Designation: ");
        designation = sc.nextLine();

        System.out.print("Enter Date of Joining (DD-MM-YYYY): ");
        dateOfJoining = sc.nextLine();

        System.out.print("Enter Date of Birth (DD-MM-YYYY): ");
        dateOfBirth = sc.nextLine();

        System.out.print("Enter Marital Status (MARRIED/UNMARRIED): ");
        maritalStatus = MaritalStatus.valueOf(sc.nextLine().toUpperCase());

        if (maritalStatus == MaritalStatus.MARRIED) {
            System.out.print("Enter Date of Marriage (DD-MM-YYYY): ");
            dateOfMarriage = sc.nextLine();
        } else {
            dateOfMarriage = "N/A";
        }
    }

    // Method to display data
    public void displayData() {
        System.out.println("\nEmployee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Date of Joining: " + dateOfJoining);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Marital Status: " + maritalStatus);
        System.out.println("Date of Marriage: " + dateOfMarriage);
    }
}


public class EmployeeBookApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[100]; // Array to store employees
        int count = 0;

        while (true) {
            System.out.println("\n--- Employee Book Menu ---");
            System.out.println("1. Enter Data");
            System.out.println("2. View Data");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (count == employees.length) {
                        System.out.println("Employee storage full! Cannot add more.");
                    } else {
                        employees[count] = new Employee();
                        employees[count].enterData(sc);
                        count++;
                        System.out.println("Employee data added successfully.");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No employee data available.");
                    } else {
                        System.out.println("\n--- Employee Details ---");
                        for (int i = 0; i < count; i++) {
                            employees[i].displayData();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
