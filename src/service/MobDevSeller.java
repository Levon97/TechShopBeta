package service;

import mobileDevicesModels.Phone;
import mobileDevicesModels.SmartWatch;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public abstract class MobDevSeller {
    private static final String FILE1 = "phoneList.txt";
    private static final String FILE2 = "smartWatchList.txt";
    private static ArrayList<String> lines;
    private static String[] splitLine;
    private static String a;

    public static Phone[] readerPhone() throws IOException {
        lines = new ArrayList<>(Files.readAllLines(Paths.get(FILE1)));
        Phone[] arr = new Phone[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            splitLine = lines.get(i).split(",");
            Phone phone = new Phone();
            phone.setModel(splitLine[0]);
            phone.setBatteryCap(Integer.parseInt(splitLine[1]));
            phone.setScreenSize(Double.parseDouble(splitLine[2]));
            phone.setScreenResolution(splitLine[3]);
            phone.setPrice(Double.parseDouble(splitLine[4]));
            arr[i] = phone;
        }
        return arr;
    }

    // Adding in list new Phone
    public static void write(Phone x) throws IOException {
        a = String.join(",", x.getModel(), Integer.toString(x.getBatteryCap()), Double.toString(x.getScreenSize()), x.getScreenResolution(), Double.toString(x.getPrice())) + "\n";
        Files.write(Paths.get(FILE1), (a).getBytes(), StandardOpenOption.APPEND);
    }

    public static void getByPricePhone(double price1, double price2) throws IOException {
        System.out.println("----------Phones parameters between " + price1 + "to" + price2 + " " + "----------");

        for (Phone x : readerPhone()) {
            if (price2 > price1) {
                if (x.getPrice() >= price1 && x.getPrice() <= price2) {
                    ;
                    x.printPhoneInfo();

                }
            } else {
                if (x.getPrice() <= price1 && x.getPrice() >= price2) {

                    x.printPhoneInfo();

                }
            }
        }
    }

    public static void printPhoneInfo() throws IOException {
        System.out.println("--------------Phones parameters--------------");
        for (Phone x : readerPhone()) {
            x.printPhoneInfo();
        }
    }

    public static Phone getMostExpensivePhone() throws IOException {
        System.out.println("------Most expensive phone parameters------");

        return Arrays.stream(readerPhone()).max(Comparator.comparing(phone -> phone.getPrice())).get();
    }

    public static Phone getCheapestPhone() throws IOException {
        System.out.println("-------Lowest price phone parameters-------");

        return Arrays.stream(readerPhone()).min(Comparator.comparing(phone -> phone.getPrice())).get();
    }

    public static Phone createPhone() {
        Phone l = new Phone();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter model");
        l.setModel(s.nextLine());
        System.out.println("Enter Battery capacity");
        l.setBatteryCap(s.nextInt());
        System.out.println("Enter screen size");
        l.setScreenSize(s.nextDouble());
        s.nextLine();
        System.out.println("Enter screen resolution");
        l.setScreenResolution(s.nextLine());
        System.out.println("Enter the price");
        l.setPrice(s.nextDouble());
        return l;
    }

    private static SmartWatch[] readerWatch() throws IOException {
        lines = new ArrayList<>(Files.readAllLines(Paths.get(FILE2)));
        SmartWatch[] arr = new SmartWatch[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            splitLine = lines.get(i).split(",");
            SmartWatch watch = new SmartWatch();
            watch.setModel(splitLine[0]);
            watch.setBatteryCap(Integer.parseInt(splitLine[1]));
            watch.setStrapLength(Double.parseDouble(splitLine[2]));
            watch.setHeartRateSensor(splitLine[3].charAt(0));
            watch.setPrice(Double.parseDouble(splitLine[4]));
            arr[i] = watch;
        }
        return arr;
    }

    // Adding in list new Smart watch
    public static void write(SmartWatch x) throws IOException {
        a = String.join(",", x.getModel(), Integer.toString(x.getBatteryCap()), Double.toString(x.getStrapLength()), Character.toString(x.getHeartRateSensor()), Double.toString(x.getPrice())) + "\n";
        Files.write(Paths.get(FILE2), (a).getBytes(), StandardOpenOption.APPEND);
    }

    public static void getByPriceWatch(double price1, double price2) throws IOException {
        System.out.println("-------------Smart watch parameters between " + price1 + "to" + price2 + "-------------");

        for (SmartWatch x : readerWatch()) {
            if (price2 > price1) {
                if (x.getPrice() >= price1 && x.getPrice() <= price2) {
                    x.printWatchInfo();

                }
            } else {
                if (x.getPrice() <= price1 && x.getPrice() >= price2) {
                    x.printWatchInfo();

                }
            }
        }
    }

    public static void printWatchInfo() throws IOException {
        System.out.println("-------------Smart watches parameters-------------");
        for (SmartWatch x : readerWatch()) {
            x.printWatchInfo();
        }
    }

    public static SmartWatch getMostExpensiveWatch() throws IOException {
        System.out.println("------Most expensive Smart watch parameters------");

        return Arrays.stream(readerWatch()).max(Comparator.comparing(watch -> watch.getPrice())).get();
    }

    public static SmartWatch getCheapestWatch() throws IOException {
        System.out.println("-------Lowest price smart watch parameters-------");

        return Arrays.stream(readerWatch()).min(Comparator.comparing(watch -> watch.getPrice())).get();
    }

    public static SmartWatch createWatch() {
        SmartWatch l = new SmartWatch();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter model");
        l.setModel(s.nextLine());
        System.out.println("Enter Battery capacity");
        l.setBatteryCap(s.nextInt());
        System.out.println("Enter strap length in SM");
        l.setStrapLength(s.nextDouble());
        System.out.println("Build in heart rate sensor (y or n)");
        l.setHeartRateSensor(s.next().charAt(0));
        System.out.println("Enter the price");
        l.setPrice(s.nextDouble());
        return l;
    }
}
