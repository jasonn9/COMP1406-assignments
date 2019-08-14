public class Desktop {
    double cpu;
    int ram;
    int storage;
    boolean storageType;

    public Desktop (double cpuNum, int ramNum, int storageNum, boolean storageTF){
        cpu = cpuNum;
        ram = ramNum;
        storage = storageNum;
        storageType = storageTF;
    }

    public String toString() {
        String storageTyper;
        if (storageType == true){
            storageTyper = "SSD";
        }
        else{
            storageTyper = "HDD";
        }
        return "Desktop PC with " + cpu + "ghz CPU, " + ram + "GB RAM, " + storage + "GB " + storageTyper +" drive.";
    }
}
