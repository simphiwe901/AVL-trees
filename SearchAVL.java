
/**
* SearchAVL inherits from newAVL class
* @author Simphiwe Mchunu
* 12 April 2017
*/

import java.io.*;
import java.util.*;
public class SearchAVL extends newAVL{
  public static void main(String args []) throws FileNotFoundException{
    searchTree();
    try{Scanner fileTwo = new Scanner(new FileInputStream("queryfile"));
    String lineTwo = "";

    while(fileTwo.hasNextLine()){
      if(newTree().find(fileTwo.nextLine())!=null){
        System.out.println(newTree().find(fileTwo.nextLine()));
      }
      else{
        System.out.println("Not found");
      }
    }
  }
  catch(FileNotFoundException e){
    System.out.println(e.getLocalizedMessage());
  }

  }
}
