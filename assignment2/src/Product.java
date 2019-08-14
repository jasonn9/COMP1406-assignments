public class Product {
    private double price;
    private int quantity;

    public Product (double p, int q){
        price = p;
        quantity = q;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public double sellUnits(int amount){
        double revenue = 0;
        if (quantity >= amount){
            quantity -= amount;
            revenue = price * amount;
        }
        else if (quantity < amount){

        }
        return revenue;
    }


}
