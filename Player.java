/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

import java.util.LinkedHashMap;

/**
 *
 * @author sutdi
 */
public class Player {
    
    //Постоянные параметры
    
    private String name; //Имя
    private int type; //Тип игрока (0:1)
    private int welfare; //Благосостояние (0:10)
    private int avarice; //Скупость (0:10)
    private int risk; //Склонность к риску (0:10)
    private int overconfidence; //Самоуверенность (0:10)
    private LinkedHashMap<Integer, Integer> necessity; //Необходимость в товаре (0:10)
    
    //Изменчивые параметры
    
    private int fear_of_poverty; //Страх бедности
    //fear_of_poverty=fear_of_poverty(i-1)+d_fear_of_poverty;
    
    private int d_fear_of_poverty; // Приращение страха бедности  (-1:1)???
    // d_fear_of_poverty=(avarice+price_acceptability+welfare)/3
    
    private int lack_of_confidence; //Неуверенность в товаре
    // lack_of_confidence=lack_of_confidence(i-1)+d_lack_of_confidence    
    
    private int d_lack_of_confidence;  //Приращение неуверенности в товаре (-1:1)???
    // d_lack_of_confidence=price_acceptability*10+antiquarity*10+type*2+rarety*10)/32;
    
    
    private int self_confidence; // Уверенность в себе
    // self_confidence= self_confidence(i-1)+d_self_confidence;
    
    private int d_self_confidence; // Приращение уверенности в тебе (-1;1)???
    // d_self_confidence= (welfate+overconfidence+Активность????+growth+price_difference)/5;
    
    
    private int passion; //Азарт
    // passion=passion(i-1)+d_passion;
    
    private int d_passion; //Приращение азарта
    // d_passion=(risk+growth+type+Активность???)/4;
    
    
    private int fear_of_loss; //Страх потери
    // fear_of_loss=fear_of_loss(i-1)+d_fear_of_loss;
    
    private int d_fear_of_loss; //Приращение страха потерию... (-1:1)
    // d_fear_of_loss=(necessity+overconfidence+Активнотьс(0;1)???+growth+type)/5
    
    
    private int activity; //Активность игрока.  Тут он решает будет ли участвовать в аукционе или нет
    //Формула: fear_of_poverty+lack_of_confidence_in_the_product+lack_of_confidence-passion-necessity+price_acceptability-1
    
    
    

    public Player() {

    }

    public Player(String name, int type, int welfare, int avarice, int risk, int overconfidence) {
        this.name = name;
        this.type = type;
        this.welfare = welfare;
        this.avarice = avarice;
        this.risk = risk;
        this.overconfidence = overconfidence;
    }
    public Player(LinkedHashMap<Integer, Integer> necessity) {
        this.necessity=necessity;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public int getWelfare() {
        return this.welfare;
    }

    public int getAvarice() {
        return this.avarice;
    }

    public int getRisk() {
        return this.risk;
    }

    public int getOverconfidence() {
        return this.overconfidence;
    }

    public LinkedHashMap<Integer,Integer> getNecessity() {
    return this.necessity;
} 
    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAvarice(int avarice) {
        this.avarice = avarice;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public void setOverconfidence(int overconfidence) {
        this.overconfidence = overconfidence;
    }

    public void setNecessity(LinkedHashMap<Integer, Integer> necessity) {
        this.necessity = necessity;
    }
}




