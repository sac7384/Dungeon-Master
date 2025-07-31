import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Quest implements java.io.Serializable {
  private String description;
  private int minStory;
  private int progression;
  private int xpReward;
  private Item itemReward;
  private int quantity;
  
  public Quest(String d, int s, int xp, Item i, int q){
    description=d;
    minStory=s;
    xpReward=xp;
    itemReward=i;
    quantity=q;
  }
  
  public int getMinStory() {
    return minStory;
  }
  
  public int getProgress(){
    return progression;
  }
  
  public int getXPReward(){
    return xpReward;
  }
  
  public Item getItemReward(){
    return itemReward;
  }
  
  public int getQuantity(){
    return quantity;
  }
  
  public String toString(){
    String stats="Details: "+description;
    stats+="\n\nRewards\n-------";
    stats+=xpReward+" Experience";
    if (quantity > 0){
      stats+=quantity+" "+itemReward.getName();
    }
    return stats;
  }
}