/**
* newAVL class inherits from AVLTree class
* @author Simphiwe Mchunu
* 5 April 2017
*/


import java.io.*;
import java.util.*;

public class newAVL extends AVLTree<String>{
  public static AVLTree<String> searchTree(){
  AVLTree<String> avlt = new AVLTree<String>();
  try{
  Scanner fileOne = new Scanner(new FileInputStream("testdata"));
  String lineOne ="";

  while(true){
    lineOne = fileOne.nextLine();
    String fullname = lineOne.substring((lineOne.lastIndexOf("|"))+1);
    avlt.insert(lineOne,fullname);
    if(fileOne.nextLine()==null){
      break;
    }
  }
  fileOne.close();
  avlt.treeOrder();
  }
  catch(IOException e){
    System.out.println(e.getLocalizedMessage());
  }
  return avlt;
}
public static void main(String args[]){
  searchTree();
}

}
