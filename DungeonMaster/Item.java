import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Item implements java.io.Serializable {
  private String name;
  private int value;
  private int purpose;
  private int quantity;
  
  public Item(String name, int value, int purpose){
    this.name=name;
    this.value=value;
    this.purpose=purpose;
    quantity=1;
  }
  
  public String getName(){
    return name;
  }
  
  public int getPurpose(){
    return purpose;
  }
  
  public int getValue(){
    return value;
  }
  
  public int getQuantity(){
    return quantity;
  }
  
  public void addQuantity(int i){
    quantity+=i;
  }
  
  public String toString(){
    String stats=name+" - "+quantity+"\n";
    if (purpose==1)
      stats+="Heals self for "+value;
    if (purpose==2)
      stats+="Damages enemy for "+value;
    if (purpose==3)
      stats+="Deals "+value+" damage to the enemy at the end of every turn";
    return stats;
  }
}