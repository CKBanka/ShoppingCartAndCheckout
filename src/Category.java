import java.sql.SQLOutput;
import java.util.*;
class Label{
    private String first;
    private String second;

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String Second) {
        second = Second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
    public Label(String s){
        int k=s.indexOf(":");
        first=s.substring(0,k);
        second=s.substring(k+1);
    }
}

class Product{
    private int categoryId;
    private String productId;
    private String productName;
    private int price;
    private int quant;
    private int disc[]={0,0,0};

    public int getQuant() {
        return quant;
    }

    public void setQuant(int q) {
        quant-= q;
    }

    public void setDisc(int a, int b, int c) {
        disc[0]=a;
        disc[1]=b;
        disc[2]=c;
    }

    public int getDisc(Customer c) {
        if(c.getCustomertype()==0){
            return disc[2];
        }
        else if(c.getCustomertype()==1){
            return disc[1];
        }
        return disc[0];
    }
    public int getPrice() {
        return price;
    }

    ArrayList<Label> label=new ArrayList<>();
    public String getProductId(){
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void EnterDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of field for this product : ");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Name of the product : ");
        productName=sc.nextLine();
        System.out.println("Enter the product Id : ");
        productId=sc.next();
        System.out.println("Enter The Price");
        price=sc.nextInt();
        System.out.println("Enter The Quantity");
        quant=sc.nextInt();
        sc.nextLine();
        n=n-4;
        String s="";
        System.out.println("Enter Other Details (with a : )");
        while(n-->0){
            s=sc.nextLine();
            Label l=new Label(s);
            label.add(l);
        }
    }
    public void printProductDetails(){
        System.out.println("Name : "+productName);
        System.out.println("Product Id : "+productId);
        System.out.println("Price : "+price);
        Label l;
        for(int i = 0; i <label.size(); i++){
            l=label.get(i);
            System.out.println(l.getFirst()+" : "+l.getSecond());
        }
    }


}
public class Category{
    private int categoryId;
    private String categoryName;
    public int getCategoryId(){
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    ArrayList<Product> products=new ArrayList<>();
    public void addProduct(){
        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter The Category ID");
//        int id=sc.nextInt();
//        if(categoryId.contains((Integer)categoryId)){
        Product p=new Product();
        p.EnterDetails();
        products.add(p);
//        }
    }
}

class Combined extends Category{
    private Product one;
    private Product two;
    private int price[]={0,0,0};

    public void setOne(Product one) {
        this.one = one;
    }

    public void setTwo(Product two) {
        this.two = two;
    }

    public void setPrice(int p1,int p2,int p3) {
        price[0] = p1;
        price[1] = p2;
        price[2] = p3;
    }

    public Product getOne() {
        return one;
    }

    public Product getTwo() {
        return two;
    }

    public int getPrice(int c) {
        if(c==0){
            return price[2];
        }
        else if(c==1){
            return price[1];
        }
        return price[0];
    }
}

