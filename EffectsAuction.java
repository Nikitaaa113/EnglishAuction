/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author sutdi
 */
public class EffectsAuction {

    private int count_player; //Количество игроков
    private double growth; //Рост аукциона - насколько быстро растет цена во время аукциона
    // цена которая выиграла в прошлом раунде - цена в первом раунде/ цена в первом раунде

    public double getGrowth() {
        return this.growth;
    }

    public int getCount_player() {
        return this.count_player;
    }

    public void setCount_player() {
        this.count_player++;
    }

    public void CalculateGrowth(Product prod) {
        this.growth = 10 * (prod.getCurrentPrice() - prod.getStartPrice()) / prod.getStartPrice();

    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public void game(int i, Product prod, Reader r, Calculate c) {
        double maxU = 0;
        int p = 2;
        double m=0;
        
        
    
        ArrayList<String> people = new ArrayList<String>();
        ArrayList<Double> curr = new ArrayList<Double>();
        System.out.println("Раунд №1");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
            prod.setCurrentPrice(0);
            this.setGrowth(0);
            prod.setPrice_difference(0);
            c.calculate_estimated_price(r, i);
            c.create_first_changeable_parameters(r, j, i);
            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2) {
                people.add(r.getArrayPlayer().get(j).getName());
                r.getArrayPlayer().get(j).CalculatePrice_increase_one(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {

                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());

                }
            }
        }
      
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        int q=0;
        count_player=-10;
        while (this.getCount_player() != 1) {
            if (count_player==0) {
                
                count_player=1;
            }
           
            
            else{
                 System.out.println("Раунд №" + p);
         count_player=0;
         
            for (int j = 0; j < r.getArrayPlayer().size(); j++) {
                c.calculate_emoticons(r, j, i, this);
                
                r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
                if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                    
                    r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                    if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                        this.setCount_player();
                        curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                        System.out.println("Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                        if  (r.getArrayPlayer().get(j).getPrice_increase()>m) {
                        m=r.getArrayPlayer().get(j).getPrice_increase();
                        q=j;
                    }    
                    }   
                }
            }
            c.calculate_max(curr, prod, maxU);
            this.CalculateGrowth(prod);
            prod.CalculatePrice_difference();
            p++;
            }
        }
        if (this.getCount_player() == 1) {
            System.out.println("Победил игрок " + r.getArrayPlayer().get(q).getName());
        }
  
      
        


    }
}


/*
        
        System.out.println("Раунд №2");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
            
            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                   
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    
                   
                    
                }
            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        
        System.out.println("Раунд №3");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //     System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        l++;
        System.out.println("Раунд №4");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //    System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        l++;
        System.out.println("Раунд №5");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //       System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        l++;
        System.out.println("Раунд №6");

        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //    System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        l++;

        System.out.println("Раунд №7");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //       System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + "Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        prod.CalculatePrice_difference();
        l++;

        System.out.println("Раунд №8");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //     System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + " Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        prod.CalculatePrice_difference();
        l++;
        System.out.println("Раунд №9");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //     System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + " Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        prod.CalculatePrice_difference();
        l++;
        System.out.println("Раунд №10");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //     System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + " Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        prod.CalculatePrice_difference();
        l++;
        System.out.println("Раунд №11");
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {

            c.calculate_emoticons(r, j, i, this);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                r.getArrayPlayer().get(j).CalculatePrice_increase_two(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    arr[l] = r.getArrayPlayer().get(j).getPrice_increase();
                    curr.add(r.getArrayPlayer().get(j).getPrice_increase());
                    // System.out.println("Имя:" + r.getArrayPlayer().get(j).getName() + " Лот:" + r.getArrayProduct().get(i).getLot() + " Д Страх бедности:" + r.getArrayPlayer().get(j).getD_Fear_of_poverty() + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Активность:" + r.getArrayPlayer().get(j).getActivity() + " Д Уверенность в себе:" + r.getArrayPlayer().get(j).getD_self_confidence() + " Рост аукциона:" + this.getGrowth());
                    //     System.out.println("Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() +    "  Азарт:" + r.getArrayPlayer().get(j).getPassion() + " Страх потери:" + r.getArrayPlayer().get(j).getFear_of_loss() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + " Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability());
                    System.out.println(" Приемлимость:" + r.getArrayPlayer().get(j).getPrice_acceptability() + " Страх бедности:" + r.getArrayPlayer().get(j).getFear_of_poverty() + " Д Неуверенность в товаре:" + r.getArrayPlayer().get(j).getD_lack_of_confidence() + " Неуверенность в товаре:" + r.getArrayPlayer().get(j).getLack_of_confidence() + " Необходимость в товаре:" + r.getArrayPlayer().get(j).getNecessity(i) + "Решение:" + r.getArrayPlayer().get(j).getActivity_in_game() + " Игрок: " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + r.getArrayPlayer().get(j).getPrice_increase());
                    l++;
                }

            }
        }
        c.calculate_max(curr, prod, maxU);
        this.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        prod.CalculatePrice_difference();
        l++;

    }

} */
