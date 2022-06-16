package englishauction;

public class EffectsAuction {

    private int count_player; //Количество игроков
    private double growth; //Рост аукциона - насколько быстро растет цена во время аукциона

    public double getGrowth() {
        return this.growth;
    }

    public int getCount_player() {
        return this.count_player;
    }

    public void setCount_player() {
        this.count_player++;
    }

    public void seetCount_player(int count_player) {
        this.count_player = count_player;
    }

    public void CalculateGrowth(Product prod) {
        this.growth = 10 * (prod.getCurrentPrice() - prod.getStartPrice()) / prod.getStartPrice();
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }
}
