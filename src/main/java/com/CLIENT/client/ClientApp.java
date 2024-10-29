package com.CLIENT.client;

import com.itroi.itroi.serviceimplementation.*;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Scanner;

public class ClientApp {
    private static UserService userService;
    private static CartService cartService;
    private static ProductService productService;
    private static User loggedInUser;
    public static void main(String[] args) {

        try {

            URL productServiceWsdlURL = new URL("http://localhost:8081/ws/products?wsdl");
            URL userServiceWsdlURL = new URL("http://localhost:8081/ws/users?wsdl");
            URL cartServiceWsdlURL = new URL("http://localhost:8081/ws/carts?wsdl");

            QName productQName = new QName("http://ServiceImplementation.itroi.itroi.com/", "ProductServiceImplService");
            QName userQName = new QName("http://ServiceImplementation.itroi.itroi.com/", "UserServiceImplService");
            QName cartQName = new QName("http://ServiceImplementation.itroi.itroi.com/", "CartServiceImplService");

            jakarta.xml.ws.Service productServiceInstance = jakarta.xml.ws.Service.create(productServiceWsdlURL, productQName);
            jakarta.xml.ws.Service userServiceInstance  = jakarta.xml.ws.Service.create(userServiceWsdlURL, userQName);
            jakarta.xml.ws.Service cartServiceInstance  = jakarta.xml.ws.Service.create(cartServiceWsdlURL, cartQName);

            productService = productServiceInstance.getPort(ProductService.class);
            userService = userServiceInstance.getPort(UserService.class);
            cartService = cartServiceInstance.getPort(CartService.class);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Вхід");
                System.out.println("2. Реєстрація");
                System.out.println("3. Вихід");
                System.out.print("Виберіть опцію: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очищення буфера

                switch (choice) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        register(scanner);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неправильний вибір. Спробуйте ще раз.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void register(Scanner scanner) {
        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();
        System.out.print("Введіть електронну пошту: ");
        String email = scanner.nextLine();
        System.out.print("Введіть номер телефону: ");
        String phone = scanner.nextLine();
        String type="Користувач";

        int userId = generateUniqueUserId();
        User newUser = new User();
        newUser.setName(name);
        newUser.setType(type);
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setPhone(phone);
        newUser.setEmail(email);
        newUser.setID(userId);
        userService.createUser(newUser);
        System.out.println("Користувача зареєстровано.");
        loggedInUser = newUser;
    }
    //generate unique userID
    private static int generateUniqueUserId() {
        int userId = 1;

        while (userService.getUserById(userId) != null) {
            userId++;
        }

        return userId;
    }
    private static void login(Scanner scanner) {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();
        ///add getUserByLoginAndPassword method to server
        ///
    }


}


