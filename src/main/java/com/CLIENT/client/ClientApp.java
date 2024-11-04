package com.CLIENT.client;

import com.itroi.itroi.serviceimpl.*;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientApp {
    private static UserService userService;
    private static CartService cartService;
    private static ProductService productService;
    private static User loggedInUser;


    public static void main(String[] args) {

        try {
            //adding some data
            //and getting services
            initializeServices();
            loadUsers();
            loadProducts();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Вхід");
                System.out.println("2. Реєстрація");
                System.out.println("3. Вихід");
                System.out.print("Виберіть опцію: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

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

    private static void register(Scanner scanner)  {
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
        String type = "User";

        int newUserId = userService.generateUniqueUserId();
        User newUser = new User();
        newUser.setName(name);
        newUser.setType(type);
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setPhone(phone);
        newUser.setEmail(email);
        newUser.setID(newUserId);

        try {
            userService.createUser(newUser);
            System.out.println("Користувача зареєстровано.");
            loggedInUser = newUser;
            userMenu(scanner);
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }
    private static void initializeServices() throws Exception {
        URL productServiceWsdlURL = new URL("http://localhost:8081/ws/products?wsdl");
        URL userServiceWsdlURL = new URL("http://localhost:8081/ws/users?wsdl");
        URL cartServiceWsdlURL = new URL("http://localhost:8081/ws/carts?wsdl");

        QName productQName = new QName("http://serviceimpl.itroi.itroi.com/", "productImplementationService");
        QName userQName = new QName("http://serviceimpl.itroi.itroi.com/", "userImplementationService");
        QName cartQName = new QName("http://serviceimpl.itroi.itroi.com/", "cartImplementationService");

        jakarta.xml.ws.Service productServiceInstance = jakarta.xml.ws.Service.create(productServiceWsdlURL, productQName);
        jakarta.xml.ws.Service userServiceInstance = jakarta.xml.ws.Service.create(userServiceWsdlURL, userQName);
        jakarta.xml.ws.Service cartServiceInstance = jakarta.xml.ws.Service.create(cartServiceWsdlURL, cartQName);

        productService = productServiceInstance.getPort(ProductService.class);
        userService = userServiceInstance.getPort(UserService.class);
        cartService = cartServiceInstance.getPort(CartService.class);
    }


    private static void login(Scanner scanner) {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        try {
            loggedInUser = userService.getUserforAuth(password, login);
            if (loggedInUser != null) {
                if (loggedInUser.getType().equals("Admin")) {
                    adminMenu(scanner);
                } else {
                    userMenu(scanner);
                }
            } else {
                System.out.println("Неправильний логін або пароль.");
            }
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }
    private static void adminMenu(Scanner scanner) throws ClientFaultException_Exception {
        while (true) {
            System.out.println("\n--- Меню Адміністратора ---");
            System.out.println("1. Додати продукт");
            System.out.println("2. Оновити продукт");
            System.out.println("3. Видалити продукт");
            System.out.println("4. Переглянути усі продукти");
            System.out.println("5. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }
    private static void userMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Меню Користувача ---");
            System.out.println("1. Переглянути всі продукти");
            System.out.println("2. Додати продукт до кошика");
            System.out.println("3. Видалити продукт з кошика");
            System.out.println("4. Завершити замовлення");
            System.out.println("5. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAllProducts();
                    break;
                case 2:
                    addProductToCart(scanner);
                    break;
                case 3:
                    removeProductFromCart(scanner);
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }


    private static void addProduct(Scanner scanner)  {
        System.out.print("Введіть назву продукту: ");
        String name = scanner.nextLine();

        System.out.print("Введіть опис продукту: ");
        String description = scanner.nextLine();

        double price = 0.0;
        while (true) {
            System.out.print("Введіть ціну продукту: ");
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price <= 0) {
                    System.out.println("Ціна повинна бути більше 0. Спробуйте ще раз.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат. Введіть число.");
                scanner.nextLine();
            }
        }

        System.out.print("Введіть категорію продукту: ");
        String category = scanner.nextLine();

        int countInStock = 0;
        while (true) {
            System.out.print("Введіть кількість на складі: ");
            try {
                countInStock = scanner.nextInt();
                scanner.nextLine();
                if (countInStock < 0) {
                    System.out.println("Кількість не може бути від'ємною. Спробуйте ще раз.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат. Введіть ціле число.");
                scanner.nextLine();
            }
        }
        int newProductId = productService.generateUniqueProductId();
        Product newProduct = new Product();
        newProduct.setID(newProductId);
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setCategory(category);
        newProduct.setCountInStock(countInStock);

        try {
            productService.addProduct(newProduct);
            System.out.println("Продукт додано.");
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }


    private static void updateProduct(Scanner scanner) {
        System.out.print("Введіть ID продукту для оновлення: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        try {
            Product product = productService.getProductById(productId);
            if (product != null) {
                System.out.print("Введіть нову назву продукту (поточна: " + product.getName() + "): ");
                String name = scanner.nextLine();

                System.out.print("Введіть новий опис продукту (поточний: " + product.getDescription() + "): ");
                String description = scanner.nextLine();

                double price = 0.0;
                while (true) {
                    System.out.print("Введіть нову ціну продукту (поточна: " + product.getPrice() + "): ");
                    try {
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        if (price <= 0) {
                            System.out.println("Ціна повинна бути більше 0. Спробуйте ще раз.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Невірний формат. Введіть число.");
                        scanner.nextLine();
                    }
                }

                System.out.print("Введіть нову категорію продукту (поточна: " + product.getCategory() + "): ");
                String category = scanner.nextLine();

                int countInStock = 0;
                while (true) {
                    System.out.print("Введіть нову кількість на складі (поточна: " + product.getCountInStock() + "): ");
                    try {
                        countInStock = scanner.nextInt();
                        scanner.nextLine();
                        if (countInStock < 0) {
                            System.out.println("Кількість не може бути від'ємною. Спробуйте ще раз.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Невірний формат. Введіть ціле число.");
                        scanner.nextLine();
                    }
                }

                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                product.setCategory(category);
                product.setCountInStock(countInStock);

                productService.updateProduct(product);
                System.out.println("Продукт оновлено.");
            } else {
                System.out.println("Продукт не знайдено.");
            }
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }

    private static void viewAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            System.out.println("--- Усі продукти ---");
            for (Product product : products) {
                System.out.println(product.getID() + ". " + product.getName() + " - " + product.getPrice() + " грн.");
            }
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Введіть ID продукту для видалення: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        try {
            productService.deleteProduct(productId);
            System.out.println("Продукт видалено.");
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }

    private static void addProductToCart(Scanner scanner) {
        System.out.print("Введіть ID продукту для додавання до кошика: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        try {
            Product product = productService.getProductById(productId);
            if (product != null) {
                cartService.addProductToCart(loggedInUser.getID(), product.getID());
                System.out.println("Продукт додано до кошика.");
            } else {
                System.out.println("Продукт не знайдено.");
            }
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }


    private static void removeProductFromCart(Scanner scanner) {
        System.out.print("Введіть ID продукту для видалення з кошика: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        try {
            cartService.removeProductFromCart(loggedInUser.getID(), productId);
            System.out.println("Продукт видалено з кошика.");
        } catch (ClientFaultException_Exception e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }

    private static void checkout() {
        try {
            List<Product> products = productService.getAllProducts();
            Cart cart =cartService.checkout(loggedInUser.getID());
            System.out.println("Замовлення успішно оформлено.");
            System.out.println("ID користувача: " + cart.getUserID());
            System.out.println("Загальна сума: " + cart.getTotalAmount());

                System.out.println("User ID: " + cart.getUserID());
                List<Integer> productIDs = cart.getProductIDs().getProductID();

                System.out.print("Product IDs: ");
                for (Integer productId : productIDs) {
                    System.out.print(productId + " ");

                    for (Product product : products) {
                        if (product.getID() == productId) {
                            System.out.println(" (Назва продукту: " + product.getName() + ")");
                            break;
                        }
                    }
                }
                System.out.println("Status: " + cart.getStatus());
                System.out.println("----------------------------");

        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }
    public static void loadProducts() throws ClientFaultException_Exception {
        Product product1 = new Product();
        product1.setCategory("Dog Food");
        product1.setCountInStock(50);
        product1.setDescription("Premium dog food");
        product1.setID(1);
        product1.setName("Royal Canin");
        product1.setPrice(30.0);
        productService.addProduct(product1);

        Product product2 = new Product();
        product2.setCategory("Cat Food");
        product2.setCountInStock(30);
        product2.setDescription("Healthy cat food");
        product2.setID(2);
        product2.setName("Whiskas");
        product2.setPrice(20.0);
        productService.addProduct(product2);

        Product product3 = new Product();
        product3.setCategory("Bird Food");
        product3.setCountInStock(15);
        product3.setDescription("Nutrient-rich food for birds");
        product3.setID(3);
        product3.setName("Versele-Laga");
        product3.setPrice(10.0);
        productService.addProduct(product3);
    }

    public static void loadUsers() throws ClientFaultException_Exception {
        User admin = new User();
        admin.setEmail("admin@example.com");
        admin.setID(userService.generateUniqueUserId());
        admin.setLogin("admin");
        admin.setName("Admin User");
        admin.setPassword("admin123");
        admin.setPhone("123-456-7890");
        admin.setType("Admin");
        userService.createUser(admin);

        User user1 = new User();
        user1.setEmail("user1@example.com");
        user1.setID(userService.generateUniqueUserId());
        user1.setLogin("user1");
        user1.setName("User One");
        user1.setPassword("password1");
        user1.setPhone("321-654-0987");
        user1.setType("User");
        userService.createUser(user1);

        User user2 = new User();
        user2.setEmail("user2@example.com");
        user2.setID(userService.generateUniqueUserId());
        user2.setLogin("user2");
        user2.setName("User Two");
        user2.setPassword("password2");
        user2.setPhone("987-654-3210");
        user2.setType("User");
        userService.createUser(user2);
    }
}


