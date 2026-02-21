package api.kitabu.ui;

import api.kitabu.controller.ProfileController;
import api.kitabu.entity.ProfileEntity;

import java.util.Scanner;

public class StartUI {
    MenuUi menuUi = new MenuUi();
    ProfileController profileController = new ProfileController();

    public void run() {
        while (true) {
            int menu = menu();
            switch (menu) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    return;
                }
                default -> System.out.print("Invalid menu option");
            }
        }
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        ProfileEntity result = profileController.login(phone, password);
        if (result == null){
            System.out.println("Phone number or password is incorrect");
        }else {
            menuUi.checkUser(result);
        }
    }

    private void register() {
        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        String result = profileController.register(name, surname, password, phone);
        System.out.println(result);
    }

    public int menu() {
        String menu = """
                1.Login
                2.Register
                3.Exit
                """;
        System.out.println(menu);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }
}
