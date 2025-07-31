import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class TrainingGrounds {
  static Scanner scan=new Scanner(System.in);
  private Player p;
  
  public TrainingGrounds(Player player) {
    p=player;
    System.out.println("You enter the Training Grounds");
    if (p.getQuestProgress(1)==1) {
      System.out.println("Sergeant: You another Champion recruit? Okay then, to prove your prowess you will need to complete a test. We have three tests but you only have to finish one. Choose the one that you think would suit you best.");
      while (true) {
        System.out.println("\n0-Leave\n1-Strength\n2-Craftiness\n3-Focus");
        int x=scan.nextInt();
        if (x==0) {
          System.out.println("Sergeant: Leaving huh? Well the tests are always here.");
          break;
        }
        if (x==1){
          System.out.println("Sergeant: You chose the Strength trial. Then all you have to do is lift up that boulder over there.");
          if (p.getStr() >= 3){
            System.out.println("You walk over to the boulder and grip it with both hands. You grunt and lift the boulder over your head.");
            System.out.println("Sergeant: Well done, recruit. Head back to Parlin and he will officially make you a Champion.");
            p.completeQuest(1);
            System.out.println("You got 10 experience!");
            p.earnXP(10);
            break;
          }
          
          else {
            System.out.println("You walk over to the boulder and grip it with both hands. The boulder feels like a mountain in your hands. You can't lift it.");
            System.out.println("Sergeant: Hmmm. Doesn't look like your strong enough to lift that boulder. You might try a different test or do some training.");
          }
        }
        
        if (x==2){
          System.out.println("Sergeant: You chose the Craftiness trial. Then all you have to do is solve this little puzzle I got in my pocket.");
          if (p.getCraft() >= 3){
            System.out.println("You take the puzzle and stare at it for a moment. You twist the puzzle a couple times and it makes a picture of Parlin's face.");
            System.out.println("Sergeant: Well done, recruit. Head back to Parlin and he will officially make you a Champion.");
            p.completeQuest(1);
            System.out.println("You got 10 experience!");
            p.earnXP(10);
            break;
          }
          
          else {
            System.out.println("You take the puzzle and stare at it for a moment. Then a minute. Then you move some stuff around. Now it looks like... a chicken? Sort of? Maybe a half chicken-half lobster creature?");
            System.out.println("Sergeant: That's not the solution... You may want to try one of the other tests, or practice with some other puzzles.");
          }
        }
        
        if (x==3){
          System.out.println("Sergeant: You chose the Focus trial. Then all you have to do is levitate for a few seconds.");
          if (p.getFocus() >= 3){
            System.out.println("You sit down and cross your legs. You focus your mind and think of clouds hovering in the sky. Your body floats above the ground.");
            System.out.println("Sergeant: Well done, recruit. Head back to Parlin and he will officially make you a Champion.");
            p.completeQuest(1);
            System.out.println("You got 10 experience!");
            p.earnXP(10);
            break;
          }
          
          else {
            System.out.println("You sit down and cross your legs. You think about clouds, then a cloud shaped like a banana you saw on the way here, then a monkey eating a banana, then that story about a monkey who moved to the desert, then about how you should be levitating but aren't.");
            System.out.println("Sergeant: Doesn't seem like your magic abilities are so great, you may want to try one of the other tests. Or if you're set on magic you could train your mind a bit and come back.");
          }
        }
        
      }
      
    }
    else {
      System.out.println("Sergeant: Hey there. Doesn't look to me like you need any training that this place can give you. I'd suggest getting a quest from Parlin or just going somewhere and practicing your skills on some evildoers.");
    }
    System.out.println("You leave the Training Grounds and head back to Tyrnel");
  }
}