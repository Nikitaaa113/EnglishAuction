package englishauction;

public class Player {

    //Постоянные параметры
    private String name; //Имя
    private int type; //Тип игрока (0:1)
    private int welfare; //Благосостояние (0:10)
    private int avarice; //Скупость (0:10)
    private int risk; //Склонность к риску (0:10)
    private int overconfidence; //Самоуверенность (0:10)
    private double necessity; //Необходимость в товаре (0:10)
    private int activity; // Активность игрока

    //Изменчивые параметры
    private int fear_of_poverty; //Страх бедности 
    private double price_acceptability; //Приемлимость цены (0:10)
    private int lack_of_confidence; //Неуверенность в товаре
    private int self_confidence; // Уверенность в себе 
    private int passion; //Азарт 
    private int fear_of_loss; //Страх потери
    private double activity_in_game; // Решение играть
    private double price_increase; // Повышение цены

    // Приращения
    private int d_fear_of_poverty; // Приращение страха бедности (-1;1)
    private int d_lack_of_confidence;  //Приращение неуверенности в товаре (-1:1)
    private int d_self_confidence; // Приращение уверенности в себе (-1;1)
    private int d_passion; //Приращение азарта (-1;1)
    private int d_fear_of_loss; //Приращение страха потери (-1;1)

    public Player() {

    }

    public Player(String name, int type, int welfare, int avarice, int risk, int overconfidence, int activity) {
        this.name = name;
        this.type = type;
        this.welfare = welfare;
        this.avarice = avarice;
        this.risk = risk;
        this.overconfidence = overconfidence;
        this.activity = activity;
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

    public double getNecessity(double necessity) {
        return this.necessity;
    }

    public int getOverconfidence() {
        return this.overconfidence;
    }

    public int getActivity() {
        return this.activity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        if (this.type == 1) {
            this.type = 10;
        }
        if (this.type == 0) {
            this.type = 5;
        }
    }

    public void setAvarice(int avarice) {
        this.avarice = avarice;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public void setActivity(int activity) {
        if (this.activity == 1) {
            this.activity = 10;
        } else {
            this.activity = 0;
        }
    }

    public void setOverconfidence(int overconfidence) {
        this.overconfidence = overconfidence;
    }

    public void setNecessity(double necessity) {
        this.necessity = necessity;
    }

    //Переменные параметры и приращения
    public double getPrice_acceptability() {
        return this.price_acceptability;
    }

    public int getD_Fear_of_poverty() {
        return this.d_fear_of_poverty;
    }

    public int getFear_of_poverty() {
        return this.fear_of_poverty;
    }

    public int getD_lack_of_confidence() {
        return this.d_lack_of_confidence;
    }

    public int getLack_of_confidence() {
        return this.lack_of_confidence;
    }

    public int getD_self_confidence() {
        return this.d_self_confidence;
    }

    public int getSelf_confidence() {
        return this.self_confidence;
    }

    public int getD_fear_of_loss() {
        return this.d_fear_of_loss;
    }

    public int getFear_of_loss() {
        return this.fear_of_loss;
    }

    public int getD_passion() {
        return this.d_passion;
    }

    public int getPassion() {
        return this.passion;
    }

    public double getActivity_in_game() {
        return this.activity_in_game;
    }

    public double getPrice_increase() {
        return this.price_increase;
    }

    public void setD_fear_of_poverty(int d_fear_of_poverty) {
        this.d_fear_of_poverty = d_fear_of_poverty;
    }

    public void setFear_of_poverty(int fear_of_poverty) {
        this.fear_of_poverty = fear_of_poverty;
    }

    public void setD_lack_of_confidence(int d_lack_of_confidence) {
        this.d_lack_of_confidence = d_lack_of_confidence;
    }

    public void setLack_of_confidence(int lack_of_confidence) {
        this.lack_of_confidence = lack_of_confidence;
    }

    public void setD_self_confidence(int d_self_confidence) {
        this.d_self_confidence = d_self_confidence;
    }

    public void setSelf_confidence(int self_confidence) {
        this.self_confidence = self_confidence;
    }

    public void setD_passion(int d_passion) {
        this.d_passion = d_passion;
    }

    public void setPassion(int passion) {
        this.passion = passion;
    }

    public void setD_fear_of_loss(int d_fear_of_loss) {
        this.d_fear_of_loss = d_fear_of_loss;
    }

    public void setFear_of_loss(int fear_of_loss) {
        this.fear_of_loss = fear_of_loss;
    }

    public void setActivity_in_game(double activity_in_game) {
        this.activity_in_game = activity_in_game;
    }

    public void setPrice_increase(double price_increase) {
        this.price_increase = price_increase;
    }

    public void setPrice_acceptability(double price_acceptability) {
        this.price_acceptability = price_acceptability;
    }

    // Методы расчёта 
    
    public void CalculateD_fear_of_poverty() {
        this.d_fear_of_poverty = (int) (-this.welfare * 0.4 - this.price_acceptability * 0.4 + this.avarice * 0.2);
        if (this.d_fear_of_poverty < -3) {
            this.d_fear_of_poverty = -1;
        } else {
            this.d_fear_of_poverty = 1;
        }

    }

    public void CalculateFear_of_poverty() {
        this.fear_of_poverty = this.fear_of_poverty + this.d_fear_of_poverty;

    }

    public void CalculateD_lack_of_confidence(Product prod) {
        this.d_lack_of_confidence = (int) (-this.price_acceptability * 0.2 - prod.getAntiquarity() * 0.4 - this.type * 0.05 - prod.getRarety() * 0.35);
        if (this.d_lack_of_confidence < -3) { //тут еще подумать мб -2
            this.d_lack_of_confidence = -1;
        } else {
            this.d_lack_of_confidence = 1;
        }
    }

    public void CalculateLack_of_confidence() {
        this.lack_of_confidence = this.lack_of_confidence + this.d_lack_of_confidence;
    }

    public void CalculateD_self_confidence(Product prod, EffectsAuction auc) {
        this.d_self_confidence = (int) (this.welfare * 0.35 + this.overconfidence * 0.3 + this.activity * 0.15 - auc.getGrowth() * 0.2 - prod.getPrice_difference() * 0.1);
        if (this.d_self_confidence < 3) {
            this.d_self_confidence = -1;
        } else {
            this.d_self_confidence = 1;
        }
    }

    public void CalculateSelf_confidence() {
        this.self_confidence = this.self_confidence + this.d_self_confidence;
    }

    public void CalculateD_passion(EffectsAuction auc) {
        this.d_passion = (int) (this.risk * 0.6 - auc.getGrowth() * 0.2 + this.type * 0.1 + this.activity * 0.1);
        if (this.d_passion < 1) {
            this.d_passion = -1;
        } else {
            this.d_passion = 1;
        }
    }

    public void CalculatePassion() {
        this.passion = this.passion + this.d_passion;
    }

    public void CalculateD_fear_of_loss(EffectsAuction auc) {
        this.d_fear_of_loss = (int) (-this.necessity * 0.3 - this.overconfidence * 0.2 - this.activity * 0.05 + auc.getGrowth() * 0.4 - this.type * 0.05);
        if (this.d_fear_of_loss < 1) {
            this.d_fear_of_loss = -1;
        } else {
            this.d_fear_of_loss = 1;
        }
    }

    public void CalculateFear_of_loss() {
        this.fear_of_loss = this.fear_of_loss + this.d_fear_of_loss;
    }

    public void CalculateActivity_in_game(Product prod) {
        this.activity_in_game = -this.fear_of_poverty - this.lack_of_confidence + this.self_confidence + this.passion + this.necessity + (prod.getPrice_difference()) - this.fear_of_loss;
    }

    public void CalculatePrice_acceptability(Product prod) {
        this.price_acceptability = (this.welfare * 0.25 + prod.getState() * 0.25 - prod.getPrice_difference() * 0.5);

    }

    public void CalculatePrice_increase_one(Product prod) {
        this.price_increase = prod.getStartPrice() + prod.getStartPrice() * (this.passion * 0.3 - this.fear_of_loss * 0.3 + this.welfare * 0.2 + this.price_acceptability * 0.2) / 10;
    }

    public void CalculatePrice_increase_next(Product prod) {
        this.price_increase = prod.getCurrentPrice() + prod.getCurrentPrice() * (this.passion * 0.3 - this.fear_of_loss * 0.3 + this.welfare * 0.2 + this.price_acceptability * 0.2) / 10;
    }
}
