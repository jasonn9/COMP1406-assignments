public class ElectronicStore {
    Desktop[] desktops = new Desktop[3];
    Laptop[] laptops = new Laptop[3];
    Fridge[] fridges = new Fridge[3];

    public ElectronicStore() {
        Desktop d1,d2,d3;
        Laptop l1,l2,l3;
        Fridge f1,f2,f3;

        d1 = new Desktop(3.5,8,500,false);
        d2 = new Desktop(3.0,16,250,true);
        d3 = new Desktop(4.3,32,500,true);
        l1 = new Laptop(3.1,32,500,true,15);
        l2 = new Laptop(2.5,8,250,false,13);
        l3 = new Laptop(3.0,16,250,true,15);
        f1 = new Fridge(16.5,true, "Black");
        f2 = new Fridge(12.0,false, "White");
        f3 = new Fridge(23.0,true, "Stainless Steel");

        desktops[0] = d1;
        desktops[1] = d2;
        desktops[2] = d3;
        laptops[0] = l1;
        laptops[1] = l2;
        laptops[2] = l3;
        fridges[0] = f1;
        fridges[1] = f2;
        fridges[2] = f3;

    }

    public void printStock(){
        System.out.println("This store stock includes:");
        for (Desktop i: desktops){
            System.out.println(i.toString());
        }
        for (Laptop x: laptops){
            System.out.println(x.toString());
        }
        for (Fridge y: fridges){
            System.out.println(y.toString());
        }
    }



}
