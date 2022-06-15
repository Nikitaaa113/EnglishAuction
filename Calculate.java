/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sutdi
 */
public class Calculate {
  
public void download_information(Reader r) throws IOException {
  r.Read();
  r.Necessity_calc();  
}

public void create_first_changeable_parameters(Reader r,int j,int i) {
    r.getArrayPlayer().get(j).setFear_of_poverty(0);
    r.getArrayPlayer().get(j).setLack_of_confidence(0);
    r.getArrayPlayer().get(j).setSelf_confidence(0);
    r.getArrayPlayer().get(j).setFear_of_loss(0);
    r.getArrayPlayer().get(j).setPassion(0);
    r.getArrayPlayer().get(j).CalculatePrice_acceptability(r.getArrayProduct().get(i));
    r.getArrayPlayer().get(j).setNecessity(r.getArrayNecessity()[i][j]);
}

public void calculate_estimated_price(Reader r,int k) {
            r.getArrayProduct().get(k).CalculateD_estimated_price();
            r.getArrayProduct().get(k).CalculateEstimated_price();
            
        }

public void calculate_emoticons(Reader r, int j, int i,EffectsAuction auc) {
                r.getArrayPlayer().get(j).CalculateD_lack_of_confidence(r.getArrayProduct().get(i));
                r.getArrayPlayer().get(j).CalculateLack_of_confidence();
                r.getArrayPlayer().get(j).CalculateD_fear_of_poverty();
                r.getArrayPlayer().get(j).CalculateFear_of_poverty();
                r.getArrayPlayer().get(j).CalculateD_self_confidence(r.getArrayProduct().get(i), auc);
                r.getArrayPlayer().get(j).CalculateSelf_confidence();
                r.getArrayPlayer().get(j).CalculateD_fear_of_loss(auc);
                r.getArrayPlayer().get(j).CalculateFear_of_loss();
                r.getArrayPlayer().get(j).CalculateD_passion(auc);
                r.getArrayPlayer().get(j).CalculatePassion();
                r.getArrayPlayer().get(j).CalculateActivity_in_game(r.getArrayProduct().get(i));
                r.getArrayPlayer().get(j).CalculatePrice_acceptability(r.getArrayProduct().get(i));
}

public void calculate_max(ArrayList<Double> a,Product prod,double max) {
    max = Collections.max(a);
    prod.setCurrentPrice(max);       
}

//public void create_next_changeable_parameters(Reader r,int j,int i) {
 //       r.getArrayPlayer().get(j).setFear_of_poverty(r.getArrayPlayer().get(j).getD_Fear_of_poverty());
   //     r.getArrayPlayer().get(j).setLack_of_confidence(0);////);
    //r.getArrayPlayer().get(j).setSelf_confidence(0);
    //r.getArrayPlayer().get(j).setFear_of_loss(0);
    //r.getArrayPlayer().get(j).setPassion(0);
   // r.getArrayPlayer().get(j).CalculatePrice_acceptability(r.getArrayProduct().get(i));
    //r.getArrayPlayer().get(j).setNecessity(r.getArrayNecessity()[i][j]);

}
        






