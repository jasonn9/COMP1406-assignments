public class Laptop extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private double screenSize;

    public Laptop (double p, int q, double c, int r, boolean s, int store, double size){
        super(p,q);
        cpuSpeed = c;
        ram = r;
        ssd = s;
        storage = store;
        screenSize = size;
    }

    public String toString() {
        String ssdType;
        if (ssd == true){
            ssdType = "SSD";
        }
        else{
            ssdType = "HDD";
        }
        return screenSize + " inch Laptop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB "
                + ssdType +" drive." + " (" + getQuantity() + " in stock, " + getPrice() + " dollars each)";
    }





}
