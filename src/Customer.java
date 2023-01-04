import java.util.ArrayList;
import java.util.Scanner;

//interface common{
//    int getDiscount();
//    int getDelivery(int a);
//    int getDelDays();
//}
class Elite extends Customer {
    private final  int disc = 10;
    private final int delivery = 100;
    private final int delDays = 2;

    //    public void setDisc(int d){
//        disc=d;
//    }
//    public void setDelivery(int delivery) {
//        this.delivery = delivery;
//    }
    public int getDelivery(int a) {
        return delivery;
    }

    public int getDiscount() {
        return disc;
    }

    @Override
    public int getDelDays() {
        return delDays;
    }
}

class prime extends Customer{
    private final int disc = 5;
    private final int delivery = 100;
//    public int delDays = 2;
    public int getDelivery(int a) {
        return (int)(delivery+(2/100.0)*a);
    }

    public int getDiscount() {
        return disc;
    }

    @Override
    public int getDelDays() {
        return (int)(Math.random()*(4)+3);
    }
}

class Normal extends Customer{
    private final int disc=0;
    private final int delivery=100;
    public int getDelivery(int a) {
        return (int)(delivery+(5/100.0)*a);
    }

    public int getDiscount() {
        return disc;
    }

    @Override
    public int getDelDays() {
        Customer c=new Elite();
        return (int)(Math.random()*(4)+7);

    }
}
public abstract class Customer {
    Scanner sc=new Scanner(System.in);
    private String name;
    private String pass;
    ArrayList<Product> cart1=new ArrayList<>();
    ArrayList<Combined> cart2=new ArrayList<>();
    ArrayList<Integer> quantity=new ArrayList<>();
    ArrayList<Integer> coupons=new ArrayList<>();
    double cartPrice;
    double account_bal=1000;
    private int customertype=0;  //0 for normal , 1 for prime , 2 for elite

    public int getCustomertype() {
        return customertype;
    }

    public Customer upgradeMember(){
        int op1;
        Customer c=null;
        if(customertype==0){
            System.out.println("Current Status : Normal");
            System.out.println("Press 1 to upgrade to prime");
            System.out.println("Press 2 to upgrade to Elite");
            op1=sc.nextInt();
            if(op1==1 && account_bal>=200){
                c=new prime();
                transferMem(c);
                c.customertype=1;
                c.account_bal-=200;
                System.out.println("Status Updated To Prime");
            }
            else if(op1==2 && account_bal>=300){
                c=new Elite();
                transferMem(c);
                c.customertype=1;
                c.account_bal-=300;
                System.out.println("Status Updated To Elite");
            }
            else if(op1!=1 && op1!=2){
                System.out.println("Wrong Input, Please Try Again!");
            }
            else{
                System.out.println("Insufficient Balance");
            }
            return c;
        }
        else if(customertype==1){
            System.out.println("Press 1 to upgrade to ELite");
            op1=sc.nextInt();
            if(op1==1 && account_bal>=300){
                c=new Elite();
                transferMem(c);
                c.customertype=1;
                c.account_bal-=300;
                System.out.println("Status Updated To Elite");
            }
            else if(op1!=1){
                System.out.println("Wrong Input, Please Try Again!");
            }
            else{
                System.out.println("Insufficient Balance");
            }
            return c;
        }
        else{
            System.out.println("You are already an Elite");
            return c;
        }
    }
    public void provideCoupons(){
        if(customertype==2){
            for(int i=0;i<3;i++){
                int t=(int)(Math.random()*(11)+5);
                coupons.add(t);
            }
        }
        else if(customertype==1){
            int t=(int)(Math.random()*(11)+5);
            coupons.add(t);
        }
    }
    public void signUp(){
        System.out.println("Enter Name");
        name=sc.nextLine();
        System.out.println("Enter the Password");
        pass=sc.nextLine();
    }
    public String getName() {
        return name;
    }
    public String getPass() {
        return pass;
    }
    public void transferMem(Customer a){
        a.name=name;
        a.pass=pass;
        a.coupons=coupons;
        a.cartPrice=cartPrice;
        a.cart1=cart1;
        a.quantity=quantity;
        a.account_bal=account_bal;
    }
    abstract int getDiscount();
    abstract int getDelivery(int a);
    abstract int getDelDays();
}
