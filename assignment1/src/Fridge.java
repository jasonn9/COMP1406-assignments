public class Fridge {
    double size;
    boolean freezer;
    String color;

    public Fridge(double sizeNum, boolean freezerTF, String colorS){
        size = sizeNum;
        freezer = freezerTF;
        color = colorS;
    }

    public String toString() {
        String freezerBool;
        if (freezer == true){
            freezerBool = " with Freezer ";
        }
        else{
            freezerBool = " ";
        }
        return size + " cu. ft. Fridge" + freezerBool + "(" + color + ")";
    }




}
