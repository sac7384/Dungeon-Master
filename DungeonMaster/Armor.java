import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Armor extends Item {
  private int def;
  private String name;
  
  private int hpUp;
  private int regenUp;
  private int strUp;
  private int craftUp;
  private int focusUp;
  private int ccUp;
  private int cmUp;
  
  public Armor(String name, int def){
    super(name,def,0);
    this.name=name;
    this.def=def;
  }
  
  public void addExtras(int hp,int regen,int str,int craft,int focus,int cc,int cm){
    hpUp=hp;
    regenUp=regen;
    strUp=str;
    craftUp=craft;
    focusUp=focus;
    ccUp=cc;
    cmUp=cm;
  }
  
  public int getDef(){
    return def;
  }
  
  public int[] getExtras(){
    int extras[] = new int [7];
    extras[0]=hpUp;
    extras[1]=regenUp;
    extras[2]=strUp;
    extras[3]=craftUp;
    extras[4]=focusUp;
    extras[5]=ccUp;
    extras[6]=cmUp;
    return extras;
  }
  
  public String toString(){
    String stats=name;
    stats+="\nDefense: "+def;
    if (hpUp!=0)
      stats+="\nHP Boost: "+hpUp;
    if (regenUp!=0)
      stats+="\nRegeneration Boost: "+regenUp;
    if (strUp!=0)
      stats+="\nStrength Boost: "+strUp;
    if (craftUp!=0)
      stats+="\nCraftiness Boost: "+craftUp;
    if (focusUp!=0)
      stats+="\nFocus Boost: "+focusUp;
    if (ccUp!=0)
      stats+="\nCritical Chance Boost: "+ccUp;
    if (cmUp!=0)
      stats+="\nCritical Multiplier Boost: "+cmUp;
    return stats;
  }
}