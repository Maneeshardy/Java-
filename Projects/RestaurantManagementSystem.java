import java.util.*;
class Customer{
    static HashMap<String,ArrayList<String>> cus_list=new HashMap<>();
    static  Map<Integer, Boolean> tableAvailability=new HashMap<>();
    Scanner sc=new Scanner(System.in);
static Map<String, String> cu_tab=new HashMap<>();
 public void add_items(String name){
        //cus,[rice,roti,curries...]
           ArrayList<String>ar=new ArrayList<>();
           System.out.println("Enter no. of orders: ");
           int n=sc.nextInt();
           System.out.println("Enter food items:");
          for(int i=0;i<n;i++){
            ar.add(sc.next());
          }
          Customer.cus_list.put(name,ar);
    }
   

    public void AvailabilityTable(int numberOfTables) {
  
        for (int i = 1; i <= numberOfTables; i++) {
            tableAvailability.put(i, true); // true = available
        }
    }

    public boolean isAvailable(int tableNumber) {
        return tableAvailability.getOrDefault(tableNumber, false);
    }

    public boolean reserveTable(int tableNumber) {
        
        if (isAvailable(tableNumber)) {
           
            tableAvailability.put(tableNumber, false); // Mark as reserved
            return true;
        }
        return false;
    }

    public void releaseTable(int tableNumber) {
        if (tableAvailability.containsKey(tableNumber)) {
            tableAvailability.put(tableNumber, true); // Mark as available again
        }
    }

    public void showAvailability() {
        System.out.println("Table Availability:");
        for (Map.Entry<Integer, Boolean> entry : tableAvailability.entrySet()) {
            String status = entry.getValue() ? "Available" : "Reserved";
            System.out.println("Table " + entry.getKey() + ": " + status);
        }
    }
public void take_input(){
    String name2=null;
        System.out.println("choose :");
        Customer c=new Customer();//obj
        Admin adm=new Admin();
        c.AvailabilityTable(5);
         boolean flag=true;
        while(flag){
            RestMs.showmenu();
            System.out.println("----------------------------------------------------------");
        System.out.println("1.show menu");
        System.out.println("2.order items:");
        System.out.println("3.select available tables and reserve a table:");
        System.out.println("4.bill");
        System.out.println("5.exit");
      System.out.println("----------------------------------------------------------");
        System.out.println("Enter input");
        int input=sc.nextInt();
        
        switch(input){
        case 1:
            
            System.out.println(RestMs.menu);
        
                break; 
        case 2:     System.out.println("Enter your name:");
                    name2=sc.next();

                    c.add_items(name2);
                

                    break;
        
        case 3:
            
            System.out.println("select table no.[1,2,3,4,5] for reservation:");
        String tab=sc.next();
        
        boolean t=c.reserveTable(Integer.parseInt(tab));
        if(!t){
            System.out.println("table is already reserved");
        }
        else{
            Customer.cu_tab.put(name2,tab);
            System.out.println("you have reserved this table");
        }
        c.showAvailability();
       break; 

        case 4:
            
            
            System.out.println("Enter your name: ");
            name2=sc.next();
           
            int sum=adm.bill(name2);
            Admin.cu_bill.put(name2,sum);
            String tableStr = cu_tab.get(name2);


        ArrayList<String> orders = Customer.cus_list.get(name2);
        int billAmount = Admin.cu_bill.get(name2);
        int pointsEarned = billAmount / 10;
        System.out.println("Name: " + name2);
       
        System.out.println("Order: " + String.join(", ", orders));
        System.out.println("Bill: Rs." + billAmount);
        System.out.println("Points earned: " + pointsEarned);
        if (tableStr == null) {
    System.out.println("Error: No table reserved for " + name2);
    
 break;// or return/continue based on logic
}
int tableNumber = Integer.parseInt(tableStr);
         System.out.println("Table: " + tableNumber + " (Reserved)");
    
            break;

case 5:

    if (name2 == null || name2.isEmpty()) {
        System.out.println("You have not entered your name.");
        break;
    }

    boolean reserved = Customer.cu_tab.containsKey(name2);
    boolean ordered = Customer.cus_list.containsKey(name2);
    boolean paid = Admin.cu_bill.containsKey(name2) && Admin.cu_bill.get(name2) > 0;

    if (ordered && !paid) {
        System.out.println("You have not paid your bill. Generating your bill now...");
       
        sum = adm.bill(name2);
        Admin.cu_bill.put(name2, sum);
          tableStr = cu_tab.get(name2);


         orders = Customer.cus_list.get(name2);
        billAmount = Admin.cu_bill.get(name2);
     pointsEarned = billAmount / 10;
        System.out.println("Name: " + name2);
        
        System.out.println("Order: " + String.join(", ", orders));
        System.out.println("Bill: Rs." + billAmount);
        System.out.println("Points earned: " + pointsEarned );
        if (tableStr == null) {
    System.out.println("Error: No table reserved for " + name2);
    break; // or return/continue based on logic
}
 tableNumber = Integer.parseInt(tableStr);
        System.out.println("Table: " + tableNumber + " (Reserved)");

        //paid = true; // now considered paid
    }

    if (reserved) {
        int tableNum = Integer.parseInt(cu_tab.get(name2));
        releaseTable(tableNum);
        Customer.cu_tab.remove(name2);
        System.out.println("Your reserved table has been released.");
    }

    System.out.println("Thank You! Visit again.");
    System.out.println("----------------------------------------------------------");
    flag = false;
    break;



        
    }
        }
}}

class Admin{
static HashMap <String,Integer>cu_bill=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    
public int bill(String name) {

    int sum = 0;
try{
    if (!Customer.cus_list.containsKey(name)) {
        System.out.println("customer not found");
        return 0;
    }

    ArrayList<String> orders = Customer.cus_list.get(name);

    for (String item : orders) {
        String price = RestMs.menu.get(item.toLowerCase());
        if (price != null) {
            sum += Integer.parseInt(price);
        } else {
            System.out.println("item " + item + " not in menu.");
        }
    }}
    catch(NullPointerException e){}
    Admin.cu_bill.put(name,sum);
    return sum;
}

public void updatedPrice(String item){
if (RestMs.menu.get(item) != null) {
System.out.print("Enter updated price:");
String up=sc.next();
    RestMs.menu.put(item,up);
    System.out.println("Price is updated");
    System.out.println("Updated "+item+" price: "+RestMs.menu.get(item));
} else {
    System.out.println("Item not found");
}
}
public int no_cus(){
return Customer.cus_list.size();
}
public void select(){
    System.out.println("choose :");
         boolean flag=true;
        while(flag==true){
        
        System.out.println("1.Number of customers");
        System.out.println("2.update prices");
        System.out.println("3.update menu");
        System.out.println("4.exit");
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter input");
        int input=sc.nextInt();
        switch(input){
       case 1:
            System.out.println("Number of customers served: "+no_cus());
            break; 
            
        case 2:
            RestMs.showmenu();
            System.out.println(RestMs.menu);
            System.out.println("Enter item to update:");
            String item=sc.next().toLowerCase();
            updatedPrice(item);
            break; 
        case 3:
        System.out.println("Original menu:"+RestMs.menu);
        System.out.println("Enter new item:");
        String it=sc.next();
        System.out.println("Enter amount:");
        String amount=sc.next();
             RestMs.menu.put(it,amount);
             System.out.println("Updated menu:"+RestMs.menu);
             break;
                     
    case 4:
        System.out.println("----------------------------------------------------------");
            flag=false;
        
    }
        }
}
}
public class RestMs{
    static Map<String,String> menu = new HashMap<>();
     public static void  showmenu(){  
        menu.put("rice","30");
        menu.put("roti","20");
        menu.put("curries","100");
        menu.put("vegmeals","99");
        menu.put("desserts","60");}
      public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
        System.out.println("Enter role'/customer(c)' or'/admin(a)'");
        System.out.println("or DO you want to exit:(e)");
        String input=sc.next();
        if("a".equals(input)){
           Admin adm=new Admin();
           adm.select();
        }
        else if("c".equals(input)){
         Customer cus=new Customer();
         cus.AvailabilityTable(5);
         cus.take_input();

        }
        else if("e".equals(input)){
            flag=false;
        }
        else{
            System.out.println("Enter proper input");
            
        }
        
        }
sc.close();
    }
              }
