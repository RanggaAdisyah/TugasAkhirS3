package view;

import controller.AdminController;
import controller.UserController;
import model.Admin;
import model.User;

import java.util.Scanner;

public class LoginView {
    private AdminController adminController;
    private UserController userController;
    private Scanner scanner;

    public LoginView(AdminController adminController, UserController userController) {
        this.adminController = adminController;
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }

    public void displayLogin() {
        int userType;
        do {
            System.out.println("\nLogin:");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            userType = scanner.nextInt();
            scanner.nextLine();

            switch (userType) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userType != 0);
    }

    private void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        Admin admin = new Admin(username, password);

        if (admin.getUsername().equals("admin") && admin.getPassword().equals("adminpass")) {
            System.out.println("Admin Login Successful!");
            AdminView adminView = new AdminView(adminController);
            adminView.displayMainMenu();
        } else {
            System.out.println("Invalid credentials. Admin login failed.");
        }
    }

    private void userLogin() {
        System.out.print("Enter User Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter User Password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);

        if (user.getUsername().equals("user") && user.getPassword().equals("userpass")) {
            System.out.println("User Login Successful!");
            UserView userView = new UserView(userController);
            userView.displayMainMenu();
        } else {
            System.out.println("Invalid credentials. User login failed.");
        }
    }
}
