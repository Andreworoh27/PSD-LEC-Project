package authentication.view;

import java.util.Scanner;

import authentication.context.authentication_context.events.Login;
import authentication.context.authentication_context.events.Register;

public class AuthenticationPage {
    Scanner scan = new Scanner(System.in);

    protected AuthenticationPage() {
        int input = 0;
        do {
            System.out.println("Menu : ");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit app");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("invalid input");
            }
            scan.nextLine();
            switch (input) {
                case 1:
                    loginPage();
                    break;
                case 2:
                    registerPage();
                    break;
                default:
                    break;
            }
        } while (input <= 2);
    }

    protected void loginPage() {
        System.out.print("username :  ");
        String username = scan.nextLine();
        System.out.print("password : ");
        String password = scan.nextLine();
        if (Login.login(username, password)) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }

    protected void registerPage() {
        System.out.print("input your username : ");
        String username = scan.nextLine();
        System.out.print("input your first name : ");
        String firstName = scan.nextLine();
        System.out.print("input your last name : ");
        String lastName = scan.nextLine();
        System.out.print("input you password : ");
        String password = scan.nextLine();
        Register.register(username,firstName,lastName,password);
    }

    public static void main(String[] args) {
        new AuthenticationPage();
    }
}
