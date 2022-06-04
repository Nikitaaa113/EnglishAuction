/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

/**
 *
 * @author sutdi
 */
public class EffectsAuction {

    private int count_player; //Количество игроков

    private int count_bid; // Количество ставок
    private int growth; //Рост аукциона - насколько быстро растет цена во время аукциона
    // цена которая выиграла в прошлом раунде - цена в первом раунде/ цена в первом раунде

    public int getGrowth() {
        return this.growth;
    }

    public int getCount_bid() {
        return this.count_bid;
    }

    public void CalculateGrowth(Product prod) {
        this.growth = (0 - prod.getPrice()) / prod.getPrice();
        if (this.growth <0) {
            this.growth = -5;
        } else {
            this.growth = 5;
        }
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

}
