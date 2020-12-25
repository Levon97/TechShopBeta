package service;


import pCmodels.Desktop;
import pCmodels.Laptop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public abstract class PCSeller {
    private static final String FILE = "laptopList.txt";
    private static final String FILE3 = "desktopList.txt";

    private static String a;

    public static Laptop[] readerLaptop() throws IOException {
        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(FILE)));
        Laptop[] list = new Laptop[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(",");
            Laptop laptop = new Laptop();
            laptop.setModel(splitLine[0]);
            laptop.setProcModel(splitLine[1]);
            laptop.setvCard(splitLine[2]);
            laptop.setrOM(Integer.parseInt(splitLine[3]));
            laptop.setrAM(Integer.parseInt(splitLine[4]));
            laptop.setBuildInCam(splitLine[5].charAt(0));
            laptop.setScreenSize(Double.parseDouble(splitLine[6]));
            laptop.setPrice(Double.parseDouble(splitLine[7]));
            list[i] = laptop;
        }

        return list;
    }

    public static Desktop[] readerDesktop() throws IOException {
        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(FILE3)));
        Desktop[] list = new Desktop[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(",");
            Desktop desktop = new Desktop();
            desktop.setProcModel(splitLine[0]);
            desktop.setvCard(splitLine[1]);
            desktop.setMotherBoard(splitLine[2]);
            desktop.setMonitorModel(splitLine[3]);
            desktop.setrOM(Integer.parseInt(splitLine[4]));
            desktop.setrAM(Integer.parseInt(splitLine[5]));
            desktop.setMonitorPrice(Double.parseDouble(splitLine[6]));
            desktop.setPrice(Double.parseDouble(splitLine[7]));
            list[i] = desktop;
        }
        return list;
    }

    public static void writeDesktop(Desktop x) throws IOException {
        a =String.join(",",x.getProcModel(), x.getvCard(),x.getMotherBoard(),x.getMonitorModel(),Integer.toString(x.getrOM()),Integer.toString(x.getrAM()),Double.toString(x.getMonitorPrice()),Double.toString(x.getPrice()))  + "\n";
        Files.write(Paths.get(FILE3), (a).getBytes(), StandardOpenOption.APPEND);
    }

    // Adding in list new Laptop
    public static void writeLaptop(Laptop x) throws IOException {
        a = String.join(",",x.getModel(), x.getProcModel(), x.getvCard(), Integer.toString(x.getrOM()),Integer.toString(x.getrAM()),Character.toString(x.getBuildInCam()),Double.toString(x.getScreenSize()), Double.toString(x.getPrice())) + "\n";
        Files.write(Paths.get(FILE), (a).getBytes(), StandardOpenOption.APPEND);
    }

    public static void getByPrice(double price1, double price2) throws IOException {
        System.out.println("-------------Laptops parameters between " + price1 + "to" + price2 + "-------------");
        boolean k = true;
        for (Laptop x : readerLaptop()) {
            if (price2 > price1) {
                if (x.getPrice() >= price1 && x.getPrice() <= price2) {
                    x.printLaptopInfo();
                    k = false;
                }
            } else {
                if (x.getPrice() <= price1 && x.getPrice() >= price2) {
                    x.printLaptopInfo();
                    k = false;
                }
            }
        }
        if (k) {
            System.out.println("No laptops in this price segment");
        }
    }

    public static void printLaptopInfo() throws IOException {
        System.out.println("-------------Laptops parameters-------------");
        for (Laptop x : readerLaptop()) {
           x.printLaptopInfo();
        }
    }

    public static void printDesktopInfo() throws IOException {
        System.out.println("-------------Desktops parameters-------------");
        for (Desktop x : readerDesktop()) {
            Desktop.printDesktopInfo(x);
        }
    }

    public static Laptop getMostExpensiveLaptop() throws IOException {
        System.out.println("------Most expensive laptop parameters------");

        return Arrays.stream(readerLaptop()).max(Comparator.comparing(laptop -> laptop.getPrice())).get();
    }

    public static Laptop getCheapestLaptop() throws IOException {
        System.out.println("-------Lowest price laptop parameters-------");

        return Arrays.stream(readerLaptop()).min(Comparator.comparing(laptop -> laptop.getPrice())).get();
    }

    public static Laptop createLaptop() {
        Laptop l = new Laptop();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter model");
        l.setModel(s.nextLine());
        System.out.println("Enter processor unit model");
        l.setProcModel(s.nextLine());
        System.out.println("Enter video card model");
        l.setvCard(s.nextLine());
        System.out.println("Enter ROM capacity in GB");
        l.setrOM(s.nextInt());
        System.out.println("Enter RAM capacity in GB");
        l.setrAM(s.nextInt());
        System.out.println("Build in camera (y or n)");
        l.setBuildInCam(s.next().charAt(0));
        System.out.println("Enter screen size");
        l.setScreenSize(s.nextDouble());
        System.out.println("Enter the price");
        l.setPrice(s.nextDouble());
        return l;
    }

    public static Desktop createDesktop() {
        Desktop l = new Desktop();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter processor unit model");
        l.setProcModel(s.nextLine());
        System.out.println("Enter video card model");
        l.setvCard(s.nextLine());
        System.out.println("Enter Mother board model");
        l.setMotherBoard(s.nextLine());
        System.out.println("Enter Monitor model");
        l.setMonitorModel(s.nextLine());
        System.out.println("Enter ROM capacity in GB");
        l.setrOM(s.nextInt());
        System.out.println("Enter RAM capacity in GB");
        l.setrAM(s.nextInt());
        System.out.println("Enter monitor price");
        l.setMonitorPrice(s.nextDouble());
        System.out.println("Enter the price");
        l.setPrice(s.nextDouble());
        return l;
    }
}
