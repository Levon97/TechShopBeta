package sellersService;

import mobileDevicesModels.SmartWatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class SmartWatchSeller {
    private static final String FILE2 = "smartWatchList.txt";
    private static List<String> lines;
    private static String[] splitLine;
    private static String a;


    private static SmartWatch[] readerWatch() throws IOException {
        lines =(Files.readAllLines(Paths.get(FILE2)));
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
