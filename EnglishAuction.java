/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package englishauction;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author sutdi
 */
public class EnglishAuction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Reader r = new Reader();
      
        r.Read();
       for (int i=0; i<r.getArrayPlayer().size();i++) {
        System.out.println( r.getArrayPlayer().get(i).getName() + " " + r.getArrayPlayer().get(i).getType() +  " " + r.getArrayPlayer().get(i).getWelfare()+ " " + r.getArrayPlayer().get(i).getAvarice() + " " + r.getArrayPlayer().get(i).getRisk() + " " + r.getArrayPlayer().get(i).getOverconfidence());
        
    } 
        System.out.println("_________________________________________");
        for (int i=0; i<r.getArrayProduct().size();i++) {
          System.out.println(r.getArrayProduct().get(i).getLot()+ " " +r.getArrayProduct().get(i).getName()+ " " + r.getArrayProduct().get(i).getYear() + " " + r.getArrayProduct().get(i).getPrice() + " " + r.getArrayProduct().get(i).getRarety()+ " " + r.getArrayProduct().get(i).getAntiquarity() + " " + r.getArrayProduct().get(i).getState());  
        } 
        
    }
    
}
