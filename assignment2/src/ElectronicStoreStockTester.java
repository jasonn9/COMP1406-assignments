public class ElectronicStoreStockTester{
    public static void main(String[] args){
        ElectronicStore store1 = createStore1();
        ElectronicStore store2 = createStore2();
        ElectronicStore store3 = createStore3();

        System.out.println(store1.getName() + "'s Stock Is:");
        store1.printStock();
        System.out.println(store2.getName() + "'s Stock Is:");
        store2.printStock();
        System.out.println(store3.getName() + "'s Stock Is:");
        store3.printStock();
    }

    public static ElectronicStore createStore1(){
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }

    public static ElectronicStore createStore2(){
        ElectronicStore store2 = new ElectronicStore("Buy-nary Computing");
        Desktop de1 = new Desktop(150, 5, 3.0, 16, true, 250, "Compact");
        Desktop de2 = new Desktop(250, 5, 3.5, 32, true, 500, "Server");
        Laptop la1 = new Laptop(100, 15, 2.5, 16, false, 250, 15);
        Laptop la2 = new Laptop(175, 15, 3.5, 24, true, 500, 16);
        Fridge fr1 = new Fridge(350, 10, 250, "Black", "Sub Zero", 15.5, false);
        Fridge fr2 = new Fridge(600, 10, 125, "White", "Sub Zero", 23, true);
        ToasterOven to1 = new ToasterOven(25, 10, 50, "Graphite", "Danby", 6, false);
        ToasterOven to2 = new ToasterOven(75, 10, 50, "Red", "Toasty", 10, true);
        store2.addProduct(de1);
        store2.addProduct(de2);
        store2.addProduct(la1);
        store2.addProduct(la2);
        store2.addProduct(fr1);
        store2.addProduct(fr2);
        store2.addProduct(to1);
        store2.addProduct(to2);
        return store2;
    }

    public static ElectronicStore createStore3(){
        ElectronicStore store3 = new ElectronicStore("Ohm-y Goodness Electronics");
        Desktop des1 = new Desktop(175, 10, 3.0, 16, true, 250, "Low-Profile");
        Desktop des2 = new Desktop(150, 15, 3.5, 32, false, 1000, "Standard");
        Laptop lap1 = new Laptop(350, 5, 3.5, 16, true, 500, 16);
        Laptop lap2 = new Laptop(500, 5, 2.5, 8, true, 125, 13);
        Fridge fri1 = new Fridge(250, 5, 250, "Black", "Sub Zero", 12, false);
        Fridge fri2 = new Fridge(275, 5, 125, "White", "Sub Zero", 15, false);
        ToasterOven toa1 = new ToasterOven(30, 10, 50, "Graphite", "Danby", 8, false);
        ToasterOven toa2 = new ToasterOven(80, 10, 50, "Red", "Toasty", 12, true);
        Desktop des3 = new Desktop(175, 10, 3.0, 16, true, 250, "Low-Profile");
        Desktop des4 = new Desktop(150, 15, 3.5, 32, false, 1000, "Standard");
        Laptop lap3 = new Laptop(350, 5, 3.5, 16, true, 500, 16);
        Laptop lap4 = new Laptop(500, 5, 2.5, 8, true, 125, 13);
        Fridge fri3 = new Fridge(250, 5, 250, "Black", "Sub Zero", 12, false);
        Fridge fri4 = new Fridge(275, 5, 125, "White", "Sub Zero", 15, false);
        ToasterOven toa3 = new ToasterOven(30, 10, 50, "Graphite", "Danby", 8, false);
        ToasterOven toa4 = new ToasterOven(80, 10, 50, "Red", "Toasty", 12, true);
        store3.addProduct(des1);
        store3.addProduct(des2);
        store3.addProduct(lap1);
        store3.addProduct(lap2);
        store3.addProduct(fri1);
        store3.addProduct(fri2);
        store3.addProduct(toa1);
        store3.addProduct(toa2);
        store3.addProduct(des3);
        store3.addProduct(des4);
        store3.addProduct(lap3);
        store3.addProduct(lap4);
        store3.addProduct(fri3);
        store3.addProduct(fri4);
        store3.addProduct(toa3);
        store3.addProduct(toa4);
        return store3;
    }
}