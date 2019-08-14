public class Desktop extends Product{
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private String profile;

    public Desktop(double p, int q, double cpu, int r, boolean s, int store, String prof){
        super(p, q);
        cpuSpeed = cpu;
        ram = r;
        ssd = s;
        storage = store;
        profile = prof;
    }


    public String toString() {
        String ssdType;
        if (ssd == true){
            ssdType = "SSD";
        }
        else{
            ssdType = "HDD";
        }
        return profile +" Desktop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB "
                + ssdType +" drive." + " (" + getQuantity() + " in stock, " + getPrice() + " dollars each)";
    }

}
