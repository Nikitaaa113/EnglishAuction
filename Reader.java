/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package englishauction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sutdi
 */
public class Reader {

    private ArrayList<Player> listPlayer = new ArrayList<>();
    private ArrayList<Product> listProduct = new ArrayList<>();

    public Reader() {
    }

    public ArrayList<Player> getArrayPlayer() {
        return listPlayer;
    }

    public ArrayList<Product> getArrayProduct() {
        return listProduct;
    }

    public void Read() throws IOException {
        try {

            XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\sutdi\\Downloads\\Курсач.xlsx");
            XSSFSheet player = book.getSheetAt(4);
            XSSFSheet product = book.getSheetAt(3);
            XSSFSheet necessity_for_player = book.getSheetAt(5);

            for (int i = 1; i <= player.getLastRowNum(); i++) {
                this.listPlayer.add(new Player(player.getRow(i).getCell(0).getStringCellValue(), (int) player.getRow(i).getCell(1).getNumericCellValue(), (int) player.getRow(i).getCell(2).getNumericCellValue(), (int) player.getRow(i).getCell(3).getNumericCellValue(), (int) player.getRow(i).getCell(4).getNumericCellValue(), (int) player.getRow(i).getCell(5).getNumericCellValue()));

            }

            for (int i = 1; i <= product.getLastRowNum(); i++) {
                this.listProduct.add(new Product((int) product.getRow(i).getCell(0).getNumericCellValue(), product.getRow(i).getCell(1).getStringCellValue(), (int) product.getRow(i).getCell(2).getNumericCellValue(), (int) product.getRow(i).getCell(9).getNumericCellValue(), (int) product.getRow(i).getCell(12).getNumericCellValue(), (int) product.getRow(i).getCell(3).getNumericCellValue(), (int) product.getRow(i).getCell(7).getNumericCellValue()));

            }
            for (int j = 1; j <= listPlayer.size(); j++) {
                LinkedHashMap<Integer, Integer> mash = null;
                for (int i = 1; i <= necessity_for_player.getLastRowNum(); i++) {
                    mash.put(i, (int) necessity_for_player.getRow(i).getCell(j).getNumericCellValue());
                }
                this.listPlayer.get(j - 1).setNecessity(mash);
            } 

        } catch (Exception e) {

        }
    }
}
