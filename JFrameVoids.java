/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author sutdi
 */
public class JFrameVoids {
    
    
    
    public void setTextArea(JTextArea jo,int i, Product prod, Reader r, Calculate c,EffectsAuction auc) {
        
        double maxU = 0;
        int p = 2;
        double m=0;
        
        jo.setText("");
    
        ArrayList<String> people = new ArrayList<String>();
        ArrayList<Double> curr = new ArrayList<Double>();
         jo.append("Раунд №1"+ "\n");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
            prod.setCurrentPrice(0);
            auc.setGrowth(0);
            prod.setPrice_difference(0);
            c.calculate_estimated_price(r, i);
            c.create_first_changeable_parameters(r, j, i);
            c.calculate_emoticons(r, j, i, auc);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2) {
                people.add(r.getArrayPlayer().get(j).getName());
                r.getArrayPlayer().get(j).CalculatePrice_increase_one(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {

                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                     jo.append("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase()+ "\n");

                }
            }
        }
      
        c.calculate_max(curr, prod, maxU);
        auc.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        int q=0;
        auc.seetCount_player(-10);
        while (auc.getCount_player() != 1) {
            if (auc.getCount_player()==0) {
                
                auc.seetCount_player(1);
            }
           
            
            else{
                  jo.append("Раунд №" + p+ "\n");
         auc.seetCount_player(0);
         
            for (int j = 0; j < r.getArrayPlayer().size(); j++) {
                c.calculate_emoticons(r, j, i, auc);
                
                r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
                if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                    
                    r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                    if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                        auc.setCount_player();
                        curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                         jo.append("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase()+ "\n");
                        if  (r.getArrayPlayer().get(j).getPrice_increase()>m) {
                        m=r.getArrayPlayer().get(j).getPrice_increase();
                        q=j;
                    }    
                    }   
                }
            }
            c.calculate_max(curr, prod, maxU);
            auc.CalculateGrowth(prod);
            prod.CalculatePrice_difference();
            p++;
            }
        }
        if (auc.getCount_player() == 1) {
            jo.append("\n");
             jo.append("Победил игрок " + r.getArrayPlayer().get(q).getName()+ "\n");
        }
     
    }
}
