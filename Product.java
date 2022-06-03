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
    private int price; //Цена 
    private int rarety; //Редкость (0:10)
    private int antiquarity; //Антикварность  (0:10)
    private int state; //Состояние (0:10)
    
    //Изменчивые параметры
    
    private int price_acceptability; //Приемлимость цены (0:10)
     //price_acceptability=(welfare*10+price_accept*10+welfare*3)/23;
   
    private int price_difference; //Разность цен (-1:1)
     //price_acceptability=(price(i-1)-estimated_price)/estimated_price
    // -1 если отрицательная ; 0 если не изменилась ; 1 если положительная
    
    
   
    private int d_estimated_price; // Решение предполагаемой цены (0:10)
    //d_estimated_price=(rarety+antiquarity+state)/3;
    
    
    private int estimated_price; //Предполагаемая цена
    // estimated_price=d_estimated_price*price+price;
    
    public Product() {
    
    } 
    
    
    
    public Product(int lot,String name, int year, int price, int rarety, int antiquarity, int state) {
        this.lot = lot;
        this.name = name;
        this.year = year;
        this.price = price;
        this.rarety = rarety;
        this.antiquarity = antiquarity;
        this.state = state;
    }
    
    public String getName() {
        return this.name;
    }
    public int getYear() {
        return this.year;
    }
    public int getLot() {
        return this.lot;
    }
    public int getPrice() {
        return this.price;
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
        this.name=name;
    }
    public void setYear(int year) {
        this.year=year;
    }
    public void setLot(int lot) {
        this.lot=lot;
    }
    public void setPrice(int price) {
        this.price=price;
    }
    public void setRarety(int rarety) {
        this.rarety=rarety;
    }
    public void setAntuquarity(int antiquarity) {
        this.antiquarity=antiquarity;
    }
    public void setState(int state) {
        this.state=state;
    }
    
}
