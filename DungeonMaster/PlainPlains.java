import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class PlainPlains {
  static Scanner scan=new Scanner(System.in);
  private Player p;
  private Enemy e;
  
  public PlainPlains(Player player) {
    p=player;
  }
  
  public Item plainsItem(){
    int r=(int)(Math.random()*3);
    if (r==0) {
      Item i=new Item("Small Healing Potion",20,1);
      System.out.println("You take the "+i.getName()+" from the bandit");
      return i;
    }
    else if (r==1){
      Weapon i=new Weapon("Small Dagger",(int)(Math.random()*2+2),(int)(Math.random()*3+3),"None");
      System.out.println("You take the "+i.getName()+" from the bandit");
      return i;
    }
    else if (r==2){
      Armor i=new Armor("Thief Clothes",(int)(Math.random()*2));
      i.addExtras(0,0,0,(int)(Math.random()*2),0,0,0);
      System.out.println("You take the "+i.getName()+" from the bandit");
      return i;
    }
    return null;
  }
  
  public void eastSide(){
    while (true) {
      System.out.println("Plain Plains - East Side\n------------------------");
      System.out.println("0-Return to Tyrnel\n1-Player Menu\n2-Single Fight\n3-Journey across the Plains (W)");
      int x=scan.nextInt();
      
      if (x==0) 
        break;
      if (x==1)
        p.playerMenu();
      if (x==2) {
        single();
        if (p.getHP() <= 0) {
          p.heal(p.getMaxHP());
          break;
        }
      }
      if (x==3){
        journey();
        if (p.getHP() <= 0) {
          p.heal(p.getMaxHP());
          break;
        }
        westSide();
        break;
      }
      
    }
  }
  
  public void westSide(){
    while (true) {
      System.out.println("Plain Plains - West Side\n------------------------");
      System.out.println("0-Return to Tyrnel\n1-Player Menu\n2-Single Fight\n3-Journey across the Plains (E)");
      if (p.getQuestProgress(3)==2){
        System.out.println("4-Shadow Forest (NW)");
      }
      if (p.getQuestProgress(3)==1) {
        System.out.println("6-Bandit Camp");
      }
      int x=scan.nextInt();
      
      if (x==0) 
        break;
      if (x==1)
        p.playerMenu();
      if (x==2)
        single();
      if (p.getHP() <= 0) {
          p.heal(p.getMaxHP());
          break;
        }
      if (x==3){
        journey();
        if (p.getHP() <= 0) {
          p.heal(p.getMaxHP());
          break;
        }
        eastSide();
        break;
      }
      if (p.getQuestProgress(3)==2 && x==4){
        System.out.println("You walk west towards the forest. The path forks and you take the one that heads north, into the Shadow Forest.");
        ShadowForest shadow=new ShadowForest(p);
        shadow.eastSide();
        break;
      }
      if (x==5){
      
      }
      if (p.getQuestProgress(3)==1 && x==6){
        quest3();
        if (p.getHP() <= 0) {
          p.heal(p.getMaxHP());
          break;
        }
      }
      
    }
  }
  
  public void quest3(){
    System.out.println("You see some smoke in the distance and head toward it. As you approach you hear voices.");
    System.out.println("Bandit #1: Oy, how much did we get from that last guy Bandit #7?");
    System.out.println("Bandit #7: #53 and #273 are counting it right now. He had a decent amount, I think he was a merchant.");
    System.out.println("Bandit #1: Good, we could do with some luck. We haven't been getting to much from our recent robberies. Oy! Where is #1342495844348427464955?");
    System.out.println("You hear Bandit #1342495844348427464955 speak from directly behind you.");
    System.out.println("Bandit #1342495844348427464955: I'm right over here, and it looks to me like we got ourselves a snoop.");
    System.out.println("You whip around and see Bandit #1342495844348427464955 crouched behind you, smiling. Then he lunges at you with a small dagger.");
    e=new Enemy("Bandit #1342495844348427464955",2,12,3,3,2,"",new Weapon("",2,3,""),new Artifact("",2,3,""),new Scroll("",2,3,""),new Armor("",0));
    e.setAttacks(true,true,false);
    new Battle(p,e);
    if (p.getHP() <= 0) {
      p.heal(p.getMaxHP());
      return;
    }
    p.addItem(plainsItem());
    System.out.println("After your battle you turn around and see the two bandits who were talking to each other.");
    System.out.println("Bandit #1: Oh come on! We just recruited him! This is why we have had 1342495844348427464955 different people in our group, cause they keep getting themselves killed! Well go get him #7. Teach that guy a lesson!");
    e=new Enemy("Bandit #7",3,14,4,4,3,"",new Weapon("",2,4,""),new Artifact("",2,4,""),new Scroll("",2,4,""),new Armor("",0));
    e.setAttacks(true,true,false);
    new Battle(p,e);
    if (p.getHP() <= 0) {
      p.heal(p.getMaxHP());
      return;
    }
    p.addItem(plainsItem());
    System.out.println("You look up and see Bandit #1 running into the distance.");
    System.out.println("You walk into the camp and find the tent with #53 and #273. They are hurriedly packing up coins and valuables into a backpack.");
    System.out.println("Bandit #53: Oh no! Quick #273 distract him while I get the money out of here!");
    System.out.println("This bandit has better armor than the others, so you won't do as much damage. Be careful!");
    e=new Enemy("Bandit #273",3,16,4,5,3,"",new Weapon("",2,4,""),new Artifact("",2,4,""),new Scroll("",2,4,""),new Armor("",1));
    e.setAttacks(true,true,false);
    new Battle(p,e);
    if (p.getHP() <= 0) {
      p.heal(p.getMaxHP());
      return;
    }
    p.addItem(plainsItem());
    System.out.println("After killing Bandit #273 you check the rest of the camp. There are no more bandits but you recover some stolen goods.");
    System.out.println("Bandit #1 and Bandit #53 got away but I don't think they will be terrorizing the Plain Plains anymore. Let's take these goods back to Parlin.");
    p.completeQuest(3);
  }
  
  public void single(){
    int g=(int)(Math.random()*3+1);
    if (g==1) {
      System.out.println("As you walk through the plains a Slime sneaks up behind you. I don't know how since it makes a loud SLOP every time it moves but somehow you still failed to notice it.");
      e=new Enemy("Slime",2,10,3,2,2,"",new Weapon("",2,3,""),new Artifact("",2,3,""),new Scroll("",2,3,""),new Armor("",0));
      e.setAttacks(true,false,false);
    }
    if (g==2) {
      System.out.println("You are attacked by a wild Vul- Fox! Doodle-oodle-doodle-oodle doo! Duh duh duh - dun dun dun - duuuuun");
      e=new Enemy("Fox",2,10,2,3,2,"",new Weapon("",2,3,""),new Artifact("",2,3,""),new Scroll("",2,3,""),new Armor("",0));
      e.setAttacks(true,true,false);
    }
    if (g==3){
      System.out.println("I think this bunny got tired of being pulled out of hats. It must have stolen magic power from whatever magician used it. Watch out!");
      e=new Enemy("Magic Rabbit",2,10,2,2,3,"",new Weapon("",2,3,""),new Artifact("",2,3,""),new Scroll("",2,3,""),new Armor("",0));
      e.setAttacks(false,false,true);
    }
    new Battle(p,e);
  }
  
  public void journey(){
    for (int i=0; i < (int)(Math.random()*4+2); i++){
      single();
      if (p.getHP() <= 0)
        break;
      System.out.println("You continue through the plains");
    }
  }
}