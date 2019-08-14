import java.util.Scanner;

public class ElectronicStore {
    private final int MAX_PRODUCTS = 10;
    int curProducts;
    private String name;
    private double revenue;
    Product[] stock;

    public ElectronicStore(String n){
        name = n;
        curProducts = 0;
        revenue = 0;
        stock = new Product[MAX_PRODUCTS];
    }

    public String getName() {
        return name;
    }


    public double getRevenue() {
        return revenue;
    }




    public boolean addProduct(Product p) {
        boolean added = false;
        for (int i = 0; i < stock.length; i++){
            if (stock[i] == null){
                stock[i] = p;
                added = true;
                curProducts++;
                break;
            }
        }
        return added;
    }

    public void sellProducts(int item, int amt){
        if (item < MAX_PRODUCTS){
            if (stock[item] != null){
                revenue += stock[item].sellUnits(amt);
                curProducts--;
            }
        }

    }

    public void sellProducts(){
        int userItem;
        int userAmt;
        printStock();
        System.out.println("Enter the index of item");
        userItem = new Scanner(System.in).nextInt();
        System.out.println("Enter the amount of items");
        userAmt = new Scanner(System.in).nextInt();
        sellProducts(userItem,userAmt);
    }

    public void printStock(){
        for (int i = 0; i < stock.length; i++){
            if (stock[i] != null){
                System.out.println(i + ". " + stock[i]);
            }
            else{

            }
        }
    }
}
