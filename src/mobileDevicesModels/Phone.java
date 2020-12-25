package mobileDevicesModels;

public class Phone extends MobileDevice {
    private double screenSize;
    private String screenResolution;   //HD,UHD ...

    public Phone() {
        super();
        screenSize = 6.01;
        screenResolution = "UHD";
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        if (screenSize >= 0) {
            this.screenSize = screenSize;
        }
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        if (screenResolution.length() > 0) {
            this.screenResolution = screenResolution;
        }
    }

    public void printPhoneInfo() {
        System.out.println("Phone model: " + this.getModel());
        System.out.println("Phone battery capacity: " + this.getBatteryCap());
        System.out.println("Phone screen size: " + this.getScreenSize());
        System.out.println("Phone resolution: " + this.getScreenResolution());
        System.out.println("Price of a phone: " + this.getPrice());
        System.out.println("--------------------------------------------");
    }
}
