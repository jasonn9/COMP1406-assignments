public class ToasterOven extends Product {
    private int wattage;
    private String color;
    private String brand;
    private int width;
    private boolean convection;

    public ToasterOven (double p, int q, int w, String c, String b, int wid, boolean conv){
        super(p,q);
        wattage = w;
        color = c;
        brand = b;
        width = wid;
        convection = conv;
    }

    public String toString(){
        String boolc;
        if (convection = true){
            boolc = " with convection ";
        }
        else{
            boolc = " ";
        }
        return width + " inch " + brand + " Toaster (" + color + ", " + wattage + " watts)" + " ("
                + getQuantity() + " in stock, " + getPrice() + " dollars each)";}
}
