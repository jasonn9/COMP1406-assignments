public class Laptop {
    double cpu;
    int ram;
    int storage;
    boolean storageType;
    int screen;

    public Laptop (double cpuNum, int ramNum, int storageNum, boolean storageTF, int screenSize){
        cpu = cpuNum;
        ram = ramNum;
        storage = storageNum;
        storageType = storageTF;
        screen = screenSize;
    }

    public String toString() {
        String storageTyper;
        if (storageType == true){
            storageTyper = "SSD";
        }
        else{
            storageTyper = "HDD";
        }
        return screen + "\" Laptop PC with " + cpu + "ghz CPU, " + ram + "GB RAM, " + storage + "GB " + storageTyper +" drive.";
    }
}
