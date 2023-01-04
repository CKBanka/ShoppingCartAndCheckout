import java.util.*;
class Admin{
    private String username="ElderDragon";
    private String password="12345";

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
public class Main extends Admin {
    ArrayList<Category> categories =new ArrayList<>();
    ArrayList<Combined> deals=new ArrayList<>();
    ArrayList<Customer> customers=new ArrayList<>();
    public static void displayMenu(Main m){
        Category c;
        Product p;
        for(int i=0;i<m.categories.size();i++){
            System.out.println(m.categories.get(i).getCategoryName()+":");
            c=m.categories.get(i);
            for(int j=0;j<c.products.size();j++){
                p=c.products.get(j);
                p.printProductDetails();
            }
        }
    }
    public static void displayDeals(Main m){
        Combined c;
        for(int i=0;i<m.deals.size();i++){
            System.out.println("Deal "+(i+1));
            c=m.deals.get(i);
            System.out.println("Offer Price for Elite,Prime and Normal Customer "+c.getPrice(2)+" "+c.getPrice(1)+" "+c.getPrice(0));
            c.getOne().printProductDetails();
            c.getTwo().printProductDetails();
            System.out.println();
            System.out.println();
        }

    }
    public static void main(String[] args) {
         {
            int flag=0;
            Category c=new Category();
            Customer cus=null;
            Main m = new Main();
            Scanner sc = new Scanner(System.in);
            int op1, op2, op3, op4, op5, op6, op7;
            Product p1 = null,p2=null;
            while(true){
                System.out.println("Welcome to Flipzon! ");
                System.out.println("1) Enter as Admin");
                System.out.println("2) Explore the product Catalog");
                System.out.println("3) Show the Available deals");
                System.out.println("4) Enter as Customer");
                System.out.println("5) Exit the Application");
                op1=sc.nextInt();
//                clone();
                if(op1==1){
                    sc.nextLine();
                    System.out.println("Enter Your User Name");
                    String ad=sc.nextLine();
                    System.out.println("Enter Your Password");
                    String pass=sc.nextLine();
                    if(ad.equals(m.getUsername()) && pass.equals(m.getPassword())){
                        while(true) {
                            System.out.println("Welcome " + ad);
                            System.out.println("Please Choose any of the following actions! ");
                            System.out.println("1) Add Category");
                            System.out.println("2) Delete Category");
                            System.out.println("3) Add Product");
                            System.out.println("4) Delete Product");
                            System.out.println("5) Set Discount on Product");
                            System.out.println("6) Add GiveAway deals");
                            System.out.println("7) Back");
                            op2 = sc.nextInt();
                            if (op2 == 1) {
                                System.out.println("Enter The New Category Id");
                                int id = sc.nextInt();
                                flag = 0;
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == id) {
                                        flag = 1;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is already used, Please Try Again");
                                }
                                else{
                                    sc.nextLine();
                                    System.out.println("Enter The Category Name");
                                    String cname=sc.nextLine();
                                    c=new Category();
                                    c.setCategoryId(id);
                                    c.setCategoryName(cname);
                                    c.addProduct();
                                    m.categories.add(c);
                                }
                            }
                            if(op2==2){
                                System.out.println("Enter The Category Id");
                                int id=sc.nextInt();
                                flag=1;
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == id) {
                                        m.categories.remove(m.categories.get(i));
                                        flag = 0;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is not present");
                                    continue;
                                }
                                else{
                                    System.out.println("Successfully Removed");
                                }
                            }
                            else if(op2==3){
                                System.out.println("Enter Category Id");
                                int id=sc.nextInt();
                                flag=1;
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == id) {
                                        m.categories.get(i).addProduct();
                                        flag = 0;
                                        break;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is not present");
                                }
                                else{
                                    System.out.println("Successfully Added Product");
                                }
                            }
                            else if(op2==4){
                                System.out.println("Enter The Product Id");
                                sc.nextLine();
                                flag=1;
                                String pfid=sc.next();
                                int k=pfid.indexOf(".");
                                int cid=Integer.parseInt(pfid.substring(0,k));
//                                int pid=Integer.parseInt(pfid.substring(k+1));
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == cid) {
                                        c=m.categories.get(i);
                                        for(int j=0;j<c.products.size();j++){
                                            if(c.products.get(j).getProductId().equals(pfid)){
                                                c.products.remove(c.products.get(j));
                                                flag=0;
                                                break;
                                            }
                                        }
                                        if(flag==1){
                                            System.out.println("Product Not Found in Category List");
                                        }
                                        flag = 0;
                                        break;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is not present");
                                }

                            }
                            else if(op2==5){
                                System.out.println("Dear Admin give the Product ID you want to add discount for ");
                                sc.nextLine();
                                String pfid=sc.next();
                                int k=pfid.indexOf(".");
                                int cid=Integer.parseInt(pfid.substring(0,k));
                                flag=1;
//                                int pid=Integer.parseInt(pfid.substring(k+1));
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == cid) {
                                        c=m.categories.get(i);
                                        for(int j=0;j<c.products.size();j++){
                                            if(c.products.get(j).getProductId().equals(pfid)){
                                                System.out.println("Enter the Discount for ELite Prime and Normal Customers");
                                                int d1=sc.nextInt();
                                                int d2=sc.nextInt();
                                                int d3=sc.nextInt();
                                                c.products.get(j).setDisc(d1,d2,d3);
                                                flag=0;
                                                break;
                                            }
                                        }
                                        if(flag==1){
                                            System.out.println("Product Not Found in Category List");
                                        }
                                        flag = 0;
                                        break;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is not present");
                                    continue;
                                }
                            }
                            else if(op2==6){
                                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                                sc.nextLine();
                                System.out.println("Enter the First Product ID");
                                String pfid=sc.nextLine();
                                int k=pfid.indexOf(".");
                                int cid=Integer.parseInt(pfid.substring(0,k));
//                                int pid=Integer.parseInt(pfid.substring(k+1));
                                flag=1;
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == cid) {
                                        c=m.categories.get(i);
                                        for(int j=0;j<c.products.size();j++){
                                            if(c.products.get(j).getProductId().equals(pfid)){
                                                p1=c.products.get(j);
                                                flag=0;
                                                break;
                                            }
                                        }
                                        if(flag==1){
                                            System.out.println("Product Not Found in Category List");
                                        }
                                        flag = 0;
                                        break;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is not present");
                                    continue;
                                }
                                System.out.println("Enter the Second Product ID");
                                pfid=sc.nextLine();
                                System.out.println(pfid);
                                k=pfid.indexOf(".");
                                flag=1;
                                cid=Integer.parseInt(pfid.substring(0,k));
                                for (int i = 0; i < m.categories.size(); i++) {
                                    if (m.categories.get(i).getCategoryId() == cid) {
                                        c=m.categories.get(i);
                                        for(int j=0;j<c.products.size();j++){
                                            if(c.products.get(j).getProductId().equals(pfid)){
                                                p2=c.products.get(j);
                                                flag=0;
                                                break;
                                            }
                                        }
                                        if(flag==1){
                                            System.out.println("Product Not Found in Category List");
                                        }
                                        flag = 0;
                                        break;
                                    }
                                }
                                if (flag == 1) {
                                    System.out.println("This Category Id is not present");
                                    continue;
                                }
                                Combined off=new Combined();
                                off.setOne(p1);
                                off.setTwo(p2);
                                System.out.println("Enter the combined price(Should be less than their combined price):");
                                int temp1=sc.nextInt();
                                int temp2=sc.nextInt();
                                int temp3=sc.nextInt();
                                off.setPrice(temp1,temp2,temp3);
                                m.deals.add(off);
                            }
                            else if(op2==7){
                                break;
                            }
//                            else{
//                                System.out.println("Invalid Input, Please try again!");
//                            }
                        }
                    }
                    else{
                        System.out.println("Wrong Username or Password ");
                    }
                }
                else if(op1==2){
                    displayMenu(m);
                }
                else if(op1==3){
                    displayDeals(m);
                }
                else if(op1==4){
                    while(true){
                        System.out.println("1) Sign Up");
                        System.out.println("2) Log In");
                        System.out.println("3) Back");
                        op2=sc.nextInt();
                        if(op2==1){
                            cus=new Normal();
                            cus.signUp();
                            m.customers.add(cus);
                            System.out.println("Customer Successfully Registered");
                        }
                        else if(op2==2){
                            sc.nextLine();
                            System.out.println("Enter The name");
                            String te1=sc.nextLine();
                            System.out.println("Enter The password");
                            String te2=sc.nextLine();
                            flag=0;
                            for(int i=0;i<m.customers.size();i++){
                                cus=m.customers.get(i);
                                if(cus.getName().equals(te1) && cus.getPass().equals(te2)){
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==1){
                                System.out.println("Welcome "+cus.getName());
                                while(true){
                                    System.out.println("1) browse products");
                                    System.out.println("2) browse deals");
                                    System.out.println("3) add a product to cart");
                                    System.out.println("4) add products in deal to cart");
                                    System.out.println("5) view coupons");
                                    System.out.println("6) check account balance");
                                    System.out.println("7) view cart");
                                    System.out.println("8) empty cart");
                                    System.out.println("9) checkout cart");
                                    System.out.println("10) upgrade customer status");
                                    System.out.println("11) Add amount to wallet");
                                    System.out.println("12) back");
                                    op3=sc.nextInt();
                                    if(op3==1){
                                        displayMenu(m);
                                    }
                                    else if(op3==2){
                                        displayDeals(m);
                                    }
                                    else if(op3==3){
                                        System.out.println("Enter product ID and quantity");
                                        String pfid=sc.next();
                                        int q=sc.nextInt();
                                        int k=pfid.indexOf(".");
                                        int cid=Integer.parseInt(pfid.substring(0,k));
                                        for (int i = 0; i < m.categories.size(); i++) {
                                            if (m.categories.get(i).getCategoryId() == cid) {
                                                c=m.categories.get(i);
                                                for(int j=0;j<c.products.size();j++){
                                                    if(c.products.get(j).getProductId().equals(pfid)){
                                                        if(c.products.get(j).getQuant()<q){
                                                            System.out.println("Out of Stock");
                                                            System.out.println("We have only "+c.products.get(j).getQuant()+" of those,");
                                                            flag=0;
                                                            break;
                                                        }
                                                        cus.cart1.add(c.products.get(j));
                                                        c.products.get(j).setQuant(q);
                                                        cus.quantity.add(q);
                                                        cus.cartPrice+=c.products.get(j).getPrice()*q;
                                                        flag=0;
                                                        break;
                                                    }
                                                }
                                                if(flag==1){
                                                    System.out.println("Product Not Found in Category List");
                                                }
                                                flag = 0;
                                                break;
                                            }
                                        }
                                        if (flag == 1) {
                                            System.out.println("This Category Id is not present");
                                        }
                                    }
                                    else if(op3==4){
                                        displayDeals(m);
                                        System.out.println("Enter The option to choose that deal");
                                        op4=sc.nextInt();
                                        cus.cart2.add(m.deals.get(op4-1));
                                        m.deals.get(op4-1).getOne().setQuant(1);
                                        m.deals.get(op4-1).getTwo().setQuant(1);
                                    }
                                    else if(op3==5){
                                        if(cus.coupons.size()>0){
                                            System.out.println("Your Coupons are as follows : ");
                                            for(int i=0;i<cus.coupons.size();i++){
                                                System.out.println(cus.coupons.get(i)+"%");
                                            }
                                        }
                                        else{
                                            System.out.println("No Coupons Earned as of now");
                                        }
                                    }
                                    else if(op3==6){
                                        System.out.println("Your account balance is : "+cus.account_bal);
                                    }
                                    else if(op3==7){
                                        if(cus.cart1.size()>0){
                                            System.out.println("Your cart Items are as follows : ");
                                            for(int i=0;i<cus.coupons.size();i++){
                                                cus.cart1.get(i).printProductDetails();
                                                System.out.println();
                                            }
                                        }
                                        else{
                                            System.out.println("Empty Cart");
                                        }
                                    }
                                    else if(op3==8){
                                        for(int i=0;i<cus.cart1.size();i++){
                                            cus.cart1.get(i).setQuant(-cus.quantity.get(i));
                                        }
                                        for(int i=0;i<cus.cart2.size();i++){
                                            cus.cart2.get(i).getOne().setQuant(-1);
                                            cus.cart2.get(i).getTwo().setQuant(-1);
                                        }
                                        cus.cart1.clear();
                                        cus.cart2.clear();
                                        cus.quantity.clear();
                                        cus.cartPrice=0;
                                        System.out.println("All Items Removed from cart successfully");
                                    }
                                    else if(op3==9){
                                        if(cus.cart1.size()>0){
                                            Collections.sort(cus.coupons,Collections.reverseOrder());
                                            System.out.println("Proceeding to checkout");
                                            System.out.println();
                                            System.out.println("Your cart Items are as follows : ");
                                            System.out.println();
                                            for(int i=0;i<cus.cart1.size();i++){
                                                System.out.println(cus.cart1.get(i).getProductName());
                                                System.out.println(cus.cart1.get(i).getPrice());
                                                System.out.println("Quannity : "+cus.quantity.get(i));
                                                int maxi=Math.max(cus.getDiscount(),cus.cart1.get(i).getDisc(cus));
                                                if(cus.coupons.size()>0){
                                                    maxi=Math.max(maxi,cus.coupons.get(0));
                                                }
                                                System.out.println("Discount Applicable on this product : "+maxi);
                                                System.out.println("Item total "+cus.cart1.get(i).getPrice()*cus.quantity.get(i));
                                                int itemTotal=cus.cart1.get(i).getPrice()*cus.quantity.get(i);
                                                itemTotal-=(int)((maxi/100.0)*itemTotal);
                                                System.out.println("Price After Discount : "+itemTotal);
                                                cus.cartPrice+=itemTotal;
                                                System.out.println();
                                            }
                                            for(int i=0;i<cus.cart2.size();i++){
                                                System.out.println(cus.cart2.get(i).getOne().getProductName());
                                                System.out.println(cus.cart2.get(i).getTwo().getProductName());
                                                System.out.println(cus.cart1.get(i).getPrice());
                                                int itemTotal=cus.cart1.get(i).getPrice();
                                                System.out.println("Price Applicable : "+itemTotal);
                                                cus.cartPrice+=itemTotal;
                                                System.out.println();
                                            }

                                            int del=100+cus.getDelivery((int)cus.cartPrice);
                                            System.out.println("Delivery Charges : "+(100+cus.getDelivery((int)cus.cartPrice)));
                                            int total=(int)(cus.cartPrice+del);
                                            System.out.println("Your Grand Total : "+total);
                                            if(total<cus.account_bal){
                                                System.out.println("Order Placed. Will be Delivered in "+cus.getDelDays()+" days");
                                                if(cus.cartPrice>=5000){
                                                    cus.provideCoupons();
                                                }
                                                cus.account_bal-=total;
                                            }
                                            else{
                                                System.out.println("Transaction Declined! Insufficient Balance");
                                            }
                                        }
                                        else{
                                            System.out.println("Empty Cart");
                                        }
                                    }
                                    else if (op3==10) {
                                        Customer n=cus.upgradeMember();
                                        if(n!=null){
                                            m.customers.remove(cus);
                                            m.customers.add(n);
                                            cus=n;
                                        }
                                    }
                                    else if(op3==11){
                                        System.out.println("Enter The amount to add");
                                        int amt=sc.nextInt();
                                        cus.account_bal+=amt;
                                        System.out.println("Amount Added successfully");
                                    }
                                    else if(op3==12){
                                        break;
                                    }
                                    else{
                                        System.out.println("Invalid Input");
                                    }
                                }
                            }
                        }
                        else if(op2==3){
                            break;
                        }
                        else{
                            System.out.println("Invalid Input");
                        }
                    }
                }
                else if (op1==5) {
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
        }
//        catch (Exception e){
//            System.out.println("Some Error occurred , Please try again ");
//        }
    }
}