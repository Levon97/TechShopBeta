package mobileDevicesModels;

public class SmartWatch extends MobileDevice {
    private char heartRateSensor;
    private double strapLength;

    public SmartWatch() {
        super();
        strapLength = 30;
        heartRateSensor = 'y';
    }

    public char getHeartRateSensor() {
        return heartRateSensor;
    }

    public void setHeartRateSensor(char heartRateSensor) {
        if (heartRateSensor == 'y' || heartRateSensor == 'n') {
            this.heartRateSensor = heartRateSensor;
        }
    }

    public double getStrapLength() {
        return strapLength;
    }

    public void setStrapLength(double strapLength) {
        if (strapLength >= 0) {
            this.strapLength = strapLength;
        }
    }

    public void printWatchInfo() {
        System.out.println("Smart watch model: " + this.getModel());
        System.out.println("Smart watch battery capacity: " + this.getBatteryCap());
        System.out.println("Smart watch strap length: " + this.getStrapLength());
        System.out.println("Build in heart rate sensor: " + this.getHeartRateSensor());
        System.out.println("Price of smart watch: " + this.getPrice());
        System.out.println("--------------------------------------------");
    }
}
