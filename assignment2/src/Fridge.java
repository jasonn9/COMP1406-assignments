public class Fridge extends Product {
    private int wattage;
    private String color;
    private String brand;
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double p, int q, int w, String c, String b, double cube, boolean freezer) {
        super(p,q);
        wattage = w;
        color = c;
        brand = b;
        cubicFeet = cube;
        hasFreezer = freezer;
    }

    public String toString() {
        String boolf;
        if (hasFreezer){
            boolf = " with Freezer ";
        }
        else{
            boolf = " ";
        }
        return cubicFeet + " cu. ft. " + brand + " Fridge" + boolf + "(" + color + ", "
                + wattage + " watts)" + " (" + getQuantity() + " in stock, " + getPrice() + " dollars each)";
    }
}

