/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author sutdi
 */
public class EffectsAuction {

    private int count_player; //Количество игроков
    private double growth; //Рост аукциона - насколько быстро растет цена во время аукциона
    // цена которая выиграла в прошлом раунде - цена в первом раунде/ цена в первом раунде
    
    private double curr_price;

    public double getGrowth() {
        return this.growth;
    }

    public void CalculateGrowth(Product prod) {
        this.growth = (prod.getCurrentPrice() - prod.getStartPrice()) / 10*prod.getStartPrice();
        if (this.growth < 0) {
            this.growth = -5;
        } else {
            this.growth = 5;
        }
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }
    
    public void game (int i,Product prod,Reader r,Calculate c) {
        
        double[] arr= new double[100];
        int l=0;
        ArrayList<String> people= new ArrayList<String>();
        
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
        prod.setCurrentPrice(0);
        c.calculate_estimated_price(r, i);
        this.CalculateGrowth(prod);
        c.create_first_changeable_parameters(r, j, i);
        c.calculate_emoticons(r, j, i, this);
        r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
        if (r.getArrayPlayer().get(j).getActivity_in_game() < -10) {
            people.add(r.getArrayPlayer().get(j).getName());
            r.getArrayPlayer().get(j).CalculatePrice_increase_one(prod);
          arr[l]=r.getArrayPlayer().get(j).getPrice_increase();
          System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
           //   System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + "   " + r.getArrayPlayer().get(j).getFear_of_poverty());
         //     System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase() + "   Лот:" + r.getArrayProduct().get(i).getLot() + " Цена:" + r.getArrayProduct().get(i).getStartPrice() + " Предполагаемая цена:" + r.getArrayProduct().get(i).getEstimated_price());
             l++;
         
        } }
        double maxU= Arrays.stream(arr).max().getAsDouble();
         prod.setCurrentPrice(maxU);
         prod.CalculatePrice_difference();
         l++;
          System.out.println("______________");
          for (int j = 0; j < r.getArrayPlayer().size(); j++) {
       
        
        this.CalculateGrowth(prod);
      
        c.calculate_emoticons(r, j, i, this);
        r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
        if (r.getArrayPlayer().get(j).getActivity_in_game() < -10 & people.contains(r.getArrayPlayer().get(j).getName())) {
            r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
          arr[l]=r.getArrayPlayer().get(j).getPrice_increase();
          System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
         //    System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + "   " + r.getArrayPlayer().get(j).getFear_of_poverty());
          //    System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase() + "   Лот:" + r.getArrayProduct().get(i).getLot() + " Цена:" + r.getArrayProduct().get(i).getStartPrice() + " Предполагаемая цена:" + r.getArrayProduct().get(i).getEstimated_price());
             l++;
          
        } }
        double max= Arrays.stream(arr).max().getAsDouble();
         prod.setCurrentPrice(max);
         prod.CalculatePrice_difference();
         l++;
          System.out.println("______________");
          for (int j = 0; j < r.getArrayPlayer().size(); j++) {
       
        
        this.CalculateGrowth(prod);
      
        c.calculate_emoticons(r, j, i, this);
        r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
        if (r.getArrayPlayer().get(j).getActivity_in_game() < -10 & people.contains(r.getArrayPlayer().get(j).getName())) {
            r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
          arr[l]=r.getArrayPlayer().get(j).getPrice_increase();
         //     System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + "   " );
             System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + "  Уверенность в себе: " +r.getArrayPlayer().get(j).getSelf_confidence() +"Рост аукциона:" + this.getGrowth());
          //    System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase() + "   Лот:" + r.getArrayProduct().get(i).getLot() + " Цена:" + r.getArrayProduct().get(i).getStartPrice() + " Предполагаемая цена:" + r.getArrayProduct().get(i).getEstimated_price());
             l++;
          
        } }
        double maxY= Arrays.stream(arr).max().getAsDouble();
         prod.setCurrentPrice(maxY);
         prod.CalculatePrice_difference();
         
         
        
        
  
    }

}
