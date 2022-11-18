import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    String Name;
    String serialNumber;
    int Value;

  Inventory (String Name,String serialNumber,int Value){
    this.Name = Name;
    this.serialNumber = serialNumber;
    this.Value = Value;
  }
  
  public String getName() {
    return Name;
  }
  
  public String getSerialNumber() {
    return serialNumber;  
  }
  
  public int getValue() {
    return Value;
  }
  
  public void setName (String Name) {
     this.Name = Name;
  }
  
  public void setSerialNumber(String serialNumber){
    this.serialNumber = serialNumber;
  }
  
  public void setValue(int Value){
     this.Value = Value;
  }

  @Override
  public String toString() {
    return Name+","+serialNumber+","+Value;
  }
  
}

class Main {
  static ArrayList <Inventory> Items = new ArrayList <Inventory>();
  static Scanner scanner = new Scanner(System.in);
  static int userChoice = 0;
  
	public static void main(String[] args) {
  while (true) {
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the program.");
      userChoice = scanner.nextInt();
      scanner.nextLine();
      switch (userChoice){
        case 1:
          addItem();
          break;
        case 2:
          deleteItem();
          break;
        case 3:
          updateItem();
          break;
        case 4:
          Display();
          break;
        default:
          System.exit(0);
      }
    
  }
    
	}
  
  static void addItem(){
    System.out.println ("Enter the name:");
    String Name = scanner.nextLine();
    System.out.println("Enter the serial number:");
    String serialNumber= scanner.nextLine();
    System.out.println("Enter the value in dollars (whole number):");
    int Value = scanner.nextInt();

    Inventory Item = new Inventory(Name, serialNumber, Value);
    Items.add(Item);
  }
    static void deleteItem() {
      System.out.println("Enter the serial number of the item to delete:");
       String serialNumber= scanner.nextLine();
      
       for (Inventory i:Items){
         if (i.getSerialNumber().equals(serialNumber) ){
           Items.remove(i); 
         } 
       }
    }
  static void updateItem(){
    System.out.println("Enter the serial number of the item to change:");
    String serialNumber= scanner.nextLine();

      for (Inventory i:Items){
         if (i.getSerialNumber().equals(serialNumber) ){
           System.out.println("Enter the new name:"); 
           String Name = scanner.nextLine();
           System.out.println("Enter the new value in dollars (whole number):");
           int Value = scanner.nextInt();
           i.setName(Name);
           i.setValue(Value);
         } 
       }
  }
  static void Display() {
    for (Inventory i:Items) {
      System.out.println(i.toString());
      
    }
  }
}