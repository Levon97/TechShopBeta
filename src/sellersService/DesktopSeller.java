package sellersService;

import pCmodels.Desktop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class DesktopSeller {

    private static String a;
    private static final String FILE = "desktopList.txt";
    public static Desktop[] readerDesktop() throws IOException {
        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(FILE)));
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

    public static void printDesktopInfo() throws IOException {
        System.out.println("-------------Desktops parameters-------------");
        for (Desktop x : readerDesktop()) {
            Desktop.printDesktopInfo(x);
        }
    }

    public static void writeDesktop(Desktop x) throws IOException {
        a =String.join(",",x.getProcModel(), x.getvCard(),x.getMotherBoard(),x.getMonitorModel(),Integer.toString(x.getrOM()),Integer.toString(x.getrAM()),Double.toString(x.getMonitorPrice()),Double.toString(x.getPrice()))  + "\n";
        Files.write(Paths.get(FILE), (a).getBytes(), StandardOpenOption.APPEND);
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
