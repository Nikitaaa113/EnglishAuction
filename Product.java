/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

/**
 *
 * @author sutdi
 */
public class Product {

    //Постоянные параметры
    private int lot; //Номер лота 
    private String name; //Название
    private int year; //Год выпуска
    private int start_price; //Цена 
    private int rarety; //Редкость (0:10)
    private int antiquarity; //Антикварность  (0:10)
    private int state; //Состояние (0:10)

    //Изменчивые параметры
    private double price_difference; //Разность цен (-5:5)
    private double d_estimated_price; // Решение предполагаемой цены (0:10)
    private double estimated_price; //Предполагаемая цена
    private double current_price;

    public Product() {

    }

    public Product(int lot, String name, int year, int start_price, int rarety, int antiquarity, int state) {
        this.lot = lot;
        this.name = name;
        this.year = year;
        this.start_price = start_price;
        this.rarety = rarety;
        this.antiquarity = antiquarity;
        this.state = state;
    }

    //Постоянные параметры 
    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    public int getLot() {
        return this.lot;
    }

    public int getStartPrice() {
        return this.start_price;
    }

    public int getRarety() {
        return this.rarety;
    }

    public int getAntiquarity() {
        return this.antiquarity;
    }

    public int getState() {
        return this.state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public void setStartPrice(int start_price) {
        this.start_price = start_price;
    }

    public void setRarety(int rarety) {
        this.rarety = rarety;
    }

    public void setAntuquarity(int antiquarity) {
        this.antiquarity = antiquarity;
    }

    public void setState(int state) {
        this.state = state;
    }

    // Изменчивые параметры
    public double getD_estimated_price() {
        return this.d_estimated_price;
    }

    public double getEstimated_price() {
        return this.estimated_price;
    }

    public double getPrice_difference() {
        return this.price_difference;
    }

    public double getCurrentPrice() {
        return this.current_price;
    }

    public void setD_estimated_price(int d_estimated_price) {
        this.d_estimated_price = d_estimated_price;
    }

    public void setEstimated_price(double estimated_price) {
        this.estimated_price = d_estimated_price;
    }

    public void setPrice_difference(double price_difference) {
        this.price_difference = price_difference;

    }

    public void setD_estimated_price(double d_estimated_price) {
        this.d_estimated_price = d_estimated_price;

    }

    public void CalculateD_estimated_price() {
        this.d_estimated_price = this.rarety * 0.5 + this.state * 0.3 + this.antiquarity * 0.2;
    }

    public void CalculateEstimated_price() {
        this.estimated_price = this.d_estimated_price * this.start_price + this.start_price;
    }

    public void CalculatePrice_difference() {
        this.price_difference = (this.current_price - this.estimated_price) / this.estimated_price;
        if (this.price_difference > 0) {
            this.price_difference = -5;
        }
        if (this.price_difference < 0) {
            this.price_difference = 5;
        }
    }

    public void setCurrentPrice(double current_price) {
        this.current_price = current_price;
    }
}
