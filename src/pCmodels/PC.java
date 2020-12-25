package pCmodels;



public abstract class PC  {
    private double price;
    private String procModel;
    private String vCard;
    private int rOM;
    private int rAM;

    public PC() {
        price = 500.5;
        procModel = "intel Xenon";
        vCard = "AMD RDNA";
        rOM = 1024;
        rAM = 16;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public String getProcModel() {
        return procModel;
    }

    public void setProcModel(String procModel) {
        if (procModel.length() != 0) {
            this.procModel = procModel;
        }
    }

    public String getvCard() {
        return vCard;
    }

    public void setvCard(String vCard) {
        if (vCard.length() != 0) {
            this.vCard = vCard;
        }
    }

    public int getrOM() {
        return rOM;
    }

    public void setrOM(int rOM) {
        if (rOM >= 0) {
            this.rOM = rOM;
        }
    }

    public int getrAM() {
        return rAM;
    }

    public void setrAM(int rAM) {
        if (rAM >= 0) {
            this.rAM = rAM;
        }
    }
}
