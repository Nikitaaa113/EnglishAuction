package englishauction;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {

    private ArrayList<Player> listPlayer = new ArrayList<>();
    private ArrayList<Product> listProduct = new ArrayList<>();
    private double[][] array = new double[50][34];

    public Reader() {
    }

    public ArrayList<Player> getArrayPlayer() {
        return listPlayer;
    }

    public ArrayList<Product> getArrayProduct() {
        return listProduct;
    }

    public double[][] getArrayNecessity() {
        return array;
    }

    public void Read() throws IOException {
        try {
            XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\sutdi\\Downloads\\Курсач.xlsx");
            XSSFSheet player = book.getSheetAt(4);
            XSSFSheet product = book.getSheetAt(3);
            for (int i = 1; i <= player.getLastRowNum(); i++) {
                this.listPlayer.add(new Player(player.getRow(i).getCell(0).getStringCellValue(), (int) player.getRow(i).getCell(1).getNumericCellValue(), (int) player.getRow(i).getCell(2).getNumericCellValue(), (int) player.getRow(i).getCell(3).getNumericCellValue(), (int) player.getRow(i).getCell(4).getNumericCellValue(), (int) player.getRow(i).getCell(5).getNumericCellValue(), (int) (player.getRow(i).getCell(6).getNumericCellValue())));
            }
            for (int i = 1; i <= product.getLastRowNum(); i++) {
                this.listProduct.add(new Product((int) product.getRow(i).getCell(0).getNumericCellValue(), product.getRow(i).getCell(1).getStringCellValue(), (int) product.getRow(i).getCell(2).getNumericCellValue(), (int) product.getRow(i).getCell(9).getNumericCellValue(), (int) product.getRow(i).getCell(12).getNumericCellValue(), (int) product.getRow(i).getCell(3).getNumericCellValue(), (int) product.getRow(i).getCell(7).getNumericCellValue()));
            }
            book.close();
        } catch (Exception e) {
        }
    }

    public void Necessity_calc() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\sutdi\\Downloads\\Курсач.xlsx");
        XSSFSheet necessity_for_player = book.getSheetAt(5);
        double[][] array = new double[50][34];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = necessity_for_player.getRow(i).getCell(j).getNumericCellValue();
            }
            this.array = array;
        }
        book.close();
    }
}
