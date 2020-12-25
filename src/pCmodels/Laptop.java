package pCmodels;


public class Laptop extends PC {
    private String model;
    private char buildInCam;
    private double screenSize;

    public Laptop() {
        super();
        model = "Toshiba";
        screenSize = 21.5;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.length() != 0) {
            this.model = model;
        }
    }

    public char getBuildInCam() {
        return buildInCam;
    }

    public void setBuildInCam(char buildInCam) {
        if (buildInCam == 'y' || buildInCam == 'n') {
            this.buildInCam = buildInCam;
        }
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        if (screenSize >= 0) {
            this.screenSize = screenSize;
        }
    }

    public void printLaptopInfo() {
        System.out.println("Laptops model: " + this.getModel());
        System.out.println("Laptops processor unit model: " + this.getProcModel());
        System.out.println("Laptops video card model: " + this.getvCard());
        System.out.println("Laptops ROM (in GB): " + this.getrOM());
        System.out.println("Laptops RAM (in GB): " + this.getrAM());
        System.out.println("Build in camera: " + this.getBuildInCam());
        System.out.println("Laptops screen size: " + this.getScreenSize());
        System.out.println("price of Laptop: " + this.getPrice());
        System.out.println("--------------------------------------------");
    }
}
