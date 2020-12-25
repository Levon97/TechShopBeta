package pCmodels;

public class Desktop extends PC {
    private String monitorModel;
    private double monitorPrice;
    private String motherBoard;

    public Desktop() {
        super();
        motherBoard = "Asus rog";
        monitorModel = "LG";
        monitorPrice = 120;

    }

    public String getMonitorModel() {
        return monitorModel;
    }

    public void setMonitorModel(String monitorModel) {
        this.monitorModel = monitorModel;
    }

    public double getMonitorPrice() {
        return monitorPrice;
    }

    public void setMonitorPrice(double monitorPrice) {
        if (monitorPrice >= 0) {
            this.monitorPrice = monitorPrice;
        }
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        if (motherBoard.length() != 0) {
            this.motherBoard = motherBoard;
        }
    }

    public static void printDesktopInfo(Desktop desktop) {
        System.out.println("Processor unit model: " + desktop.getProcModel());
        System.out.println("Video card model: " + desktop.getvCard());
        System.out.println("Mother board model: " + desktop.getMotherBoard());
        System.out.println("Monitor model: " + desktop.getMonitorModel());
        System.out.println("ROM in GB: " + desktop.getrOM());
        System.out.println("RAM in GB: " + desktop.getrAM());
        System.out.println("Monitor price: " + desktop.getMonitorPrice());
        System.out.println("Desktop price: " + desktop.getPrice());
    }
}
