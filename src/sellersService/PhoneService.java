package sellersService;

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

public abstract class PhoneService {
    private static final String FILE1 = "phoneList.txt";
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


}
