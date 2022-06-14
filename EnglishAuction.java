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
        EffectsAuction auc = new EffectsAuction();

        r.Read();
        r.Necessity_calc();

        for (int k = 0; k < r.getArrayProduct().size(); k++) {
            r.getArrayProduct().get(k).CalculateD_estimated_price();
            r.getArrayProduct().get(k).CalculateEstimated_price();
            r.getArrayProduct().get(k).CalculatePrice_difference();
        }

        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
            for (int i = 0; i < r.getArrayProduct().size(); i++) {
                r.getArrayPlayer().get(j).setFear_of_poverty(0);
                r.getArrayPlayer().get(j).setLack_of_confidence(0);
                r.getArrayPlayer().get(j).setSelf_confidence(0);
                r.getArrayPlayer().get(j).setFear_of_loss(0);
                r.getArrayPlayer().get(j).setPassion(0);
                r.getArrayPlayer().get(j).CalculatePrice_acceptability(r.getArrayProduct().get(i));
                r.getArrayPlayer().get(j).setNecessity(r.getArrayNecessity()[i][j]);

                r.getArrayPlayer().get(j).CalculateD_lack_of_confidence(r.getArrayProduct().get(i));
                r.getArrayPlayer().get(j).CalculateLack_of_confidence();
                r.getArrayPlayer().get(j).CalculateD_fear_of_poverty(r.getArrayProduct().get(i));
                r.getArrayPlayer().get(j).CalculateFear_of_poverty();
                auc.CalculateGrowth(r.getArrayProduct().get(i));
                r.getArrayPlayer().get(j).CalculateD_self_confidence(r.getArrayProduct().get(i), auc);
                r.getArrayPlayer().get(j).CalculateSelf_confidence();
                r.getArrayPlayer().get(j).CalculateD_fear_of_loss(auc);
                r.getArrayPlayer().get(j).CalculateFear_of_loss();
                r.getArrayPlayer().get(j).CalculateD_passion(auc);
                r.getArrayPlayer().get(j).CalculatePassion();
                r.getArrayPlayer().get(j).CalculateActivity_in_game(r.getArrayProduct().get(i));
                
                if(i==10) {
                    if (r.getArrayPlayer().get(j).getActivity_in_game()<-8) {
                        r.getArrayPlayer().get(j).CalculatePrice_increase(r.getArrayProduct().get(i));
                        System.out.println("Азарт:" + r.getArrayPlayer().get(j).getPassion()+ " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i));
                    System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase()   +   "   Лот:"+ r.getArrayProduct().get(i).getLot() + " Цена:" + r.getArrayProduct().get(i).getPrice()+ " Предполагаемая цена:" + r.getArrayProduct().get(i).getEstimated_price());
                    
                    
                    
                }}

     //              System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Решение:" + r.getArrayProduct().get(i).getD_estimated_price() + " Цена:" + r.getArrayProduct().get(i).getPrice() + " Предполагаемая цена:" + r.getArrayProduct().get(i).getEstimated_price() + " Разница цен:" + r.getArrayProduct().get(i).getPrice_difference() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
       //       System.out.println("Эмоции:");
         //         System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + auc.getGrowth());
           //     System.out.println("Уверенность в себе:" + r.getArrayPlayer().get(j).getSelf_confidence());
             //       System.out.println("Д Страх потери:" + r.getArrayPlayer().get(j).getD_fear_of_loss());
               //     System.out.println("Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss());
              // System.out.println("Д Азарт:" + r.getArrayPlayer().get(j).getD_passion());
              // System.out.println("Азарт:" + r.getArrayPlayer().get(j).getPassion());
         //     if (i==1) {
       //  get(j).getPassion()); 
   //    if (r.getArrayPlayer().get(j).getActivity_in_game()<-8)  {
     //     System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " играет в лоте:" + r.getArrayProduct().get(i).getLot() + "   Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss());
       }

    //   System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() +  " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + "  Уверенность в себе:" + r.getArrayPlayer().get(j).getSelf_confidence() + " Азарт:" + r.getArrayPlayer().get(j).getPassion()+ " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() );
     //  System.out.println("Решение об игре:" + r.getArrayPlayer().get(j).getActivity_in_game()); //+ " Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Д азарт:" + r.getArrayPlayer().get(j).getD_passion() + " Д Страх" + r.getArrayPlayer().get(j).getD_fear_of_loss()) ;
            //  if (r.getArrayPlayer().get(j).getActivity_in_game()>=-2) {
              //    System.out.println( "Игрок " + r.getArrayPlayer().get(j).getName() + " играет" +  " Цена:" + r.getArrayProduct().get(i).getPrice() + " Предполагаемая цена:" + r.getArrayProduct().get(i).getEstimated_price() + " Разница цен:" + r.getArrayProduct().get(i).getPrice_difference());
             // } }
           //     System.out.println ("Участвует в игре");}
             //   else  {
               //   System.out.println("Решение об игре:" + r.getArrayPlayer().get(j).getActivity_in_game() + " Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot()) ;
               // System.out.println ("Не участвует в игре");}
            
           // }

        }
//System.out.println("Решение об игре:" + r.getArrayPlayer().get(j).getActivity_in_game() + " Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(7).getLot());
    }
}
