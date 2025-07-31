import java.io.*;

public class FileSaver {
  public void save(Player p){
    try {
    FileOutputStream fileOut = new FileOutputStream("DMsave.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(p);
    out.close();
    fileOut.close();
    System.out.println("You pray at the Save Stone and your essence is copied into the heavens.");
    }
    
    catch (IOException i) {
         i.printStackTrace();
    }
  }
  
  public Player load(){
    Player p=new Player("");
    try {
         FileInputStream fileIn = new FileInputStream("DMsave.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         p = (Player) in.readObject();
         in.close();
         fileIn.close();
         System.out.println("You are resurrected in front of the Save Stone. Welcome back to Dwendra!");
      }
    catch (IOException i) {
         i.printStackTrace();
         return null;
      }
    catch (ClassNotFoundException c) {
         System.out.println("Your essence could not be found in the heavens. Maybe pray a little harder next time?");
         c.printStackTrace();
         return null;
      }
    return p;
  }
}