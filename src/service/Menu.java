package service;

import sellersService.DesktopSeller;
import sellersService.LaptopSeller;
import sellersService.PhoneService;
import sellersService.SmartWatchSeller;

import java.io.IOException;
import java.util.Scanner;


public class Menu {

    public static void authorizationMenu() throws IOException {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);

        while (isMenuActive) {
            System.out.println("\nWelcome to TechShop");
            System.out.println("1: For Login (Entering user name and password):");
            System.out.println("2: For registration:");
            System.out.println("3: Exit");

            int i = s.nextInt();
            switch (i) {
                case 1:
                    Authorization.login();
                    break;
                case 2:
                    try {
                        Authorization.registration();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    isMenuActive = false;
                    System.out.println("Exiting shop");
                    break;
                default:
                    System.out.println("there is no such a command as " + i);
            }
        }
    }

    public static void mainMenu() {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);

        while (isMenuActive) {
            System.out.println("1: For laptops");
            System.out.println("2: For Desktops");
            System.out.println("3: For phones");
            System.out.println("4: For smart watches");
            System.out.println("5: Back to Registration-Login menu");

            int i = s.nextInt();
            switch (i) {
                case 1:
                    laptopMenu();
                    break;
                case 2:
                    desktopMenu();
                    break;
                case 3:
                    phoneMenu();
                    break;
                case 4:
                    watchMenu();
                    break;
                case 5:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("there is no such a command as " + i);
            }
        }
    }

    public static void laptopMenu() {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);
        while (isMenuActive) {
            System.out.println("\nMenu for Laptops");
            System.out.println("1: List of available laptops with parameters");
            System.out.println("2: List of devices within specified limits of price ");
            System.out.println("3: Most expensive laptop");
            System.out.println("4: Lowest priced Laptop");
            System.out.println("5: Add laptop");
            System.out.println("6: Back to main menu");
            int j = s.nextInt();
            switch (j) {
                case 1:
                    try {
                        LaptopSeller.printLaptopInfo();
                        System.out.println("End of the list");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    double a, b;
                    System.out.println("Enter price limit");

                    a = s.nextDouble();
                    System.out.println("Enter the other limit");
                    b = s.nextDouble();
                    try {
                        LaptopSeller.getByPrice(a, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        LaptopSeller.getMostExpensiveLaptop().printLaptopInfo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        LaptopSeller.getCheapestLaptop().printLaptopInfo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                       LaptopSeller.writeLaptop(LaptopSeller.createLaptop());
                        System.out.println("Device added to list.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("there is no such a command as " + j);
            }
        }
    }

    public static void desktopMenu() {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);
        while (isMenuActive) {
            System.out.println("\nMenu for Desktops");
            System.out.println("1: List of available Desktop builds");
            System.out.println("2: Build and add Desktop to list");
            System.out.println("3: Back to main menu");
            int j = s.nextInt();
            switch (j) {
                case 1:
                    try {
                        DesktopSeller.printDesktopInfo();
                        System.out.println("End of the list");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        DesktopSeller.writeDesktop(DesktopSeller.createDesktop());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("there is no such a command as " + j);

            }
        }
    }

    public static void phoneMenu() {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);
        while (isMenuActive) {
            System.out.println("\nMenu for phones");
            System.out.println("1: List of available phones with parameters");
            System.out.println("2: List of devices within specified limits of price ");
            System.out.println("3: Most expensive phone in list");
            System.out.println("4: Lowest priced phone in list");
            System.out.println("5: Add phone to list");
            System.out.println("6: Back to main menu");
            int j = s.nextInt();
            switch (j) {
                case 1:
                    try {
                        PhoneService.printPhoneInfo();
                        System.out.println("End of the list");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    double a, b;
                    System.out.println("Enter price limit");

                    a = s.nextDouble();
                    System.out.println("Enter the other limit");
                    b = s.nextDouble();
                    try {
                        PhoneService.getByPricePhone(a, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        PhoneService.getMostExpensivePhone().printPhoneInfo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        PhoneService.getCheapestPhone().printPhoneInfo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        PhoneService.write(PhoneService.createPhone());
                        System.out.println("Device added to list.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("there is no such a command as " + j);
            }
        }
    }

    public static void watchMenu() {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);
        while (isMenuActive) {
            System.out.println("\nMenu for smart watches");
            System.out.println("1: List of available smart watches with parameters");
            System.out.println("2: List of devices within specified limits of price ");
            System.out.println("3: Most expensive smart watch in list");
            System.out.println("4: Lowest priced smart watch in list");
            System.out.println("5: Add smart watch to list");
            System.out.println("6: Back to main menu");
            int j = s.nextInt();
            switch (j) {
                case 1:
                    try {
                        SmartWatchSeller.printWatchInfo();
                        System.out.println("End of the list");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    double a, b;
                    System.out.println("Enter price limit");

                    a = s.nextDouble();
                    System.out.println("Enter the other limit");
                    b = s.nextDouble();
                    try {
                        SmartWatchSeller.getByPriceWatch(a, b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        SmartWatchSeller.getMostExpensiveWatch().printWatchInfo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        SmartWatchSeller.getCheapestWatch().printWatchInfo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        SmartWatchSeller.write(SmartWatchSeller.createWatch());
                        System.out.println("Device added to list.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("there is no such a command as " + j);
            }
        }
    }
}
