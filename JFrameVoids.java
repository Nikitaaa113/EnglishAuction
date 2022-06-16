package englishauction;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class JFrameVoids {

    private int h = 0;
    private ArrayList<Integer> winner = new ArrayList<Integer>();
    private ArrayList<String> people = new ArrayList<String>();
    private ArrayList<Double> current_price_people = new ArrayList<Double>();
    private double maxU; //Размер максимальной ставки
    private int p; //Номер раунда
    private int q; // Для запоминания игрока, который выиграл

    
    public void setTextArea(JTextArea jo, int i, Product prod, Reader r, Calculate c, EffectsAuction auc, JTable table, int x) throws Exception {
        maxU = 0; //Размер максимальной ставки
        p = 2; //Номер раунда
        q = 0; // Для запоминания игрока, который выиграл
        this.WriteFirstRound(jo, i, prod, r, c, auc, x);
        if (auc.getCount_player() != 0) {
            c.calculate_max(current_price_people, prod, maxU);
            auc.CalculateGrowth(prod);
            prod.CalculatePrice_difference();
            this.WriteNextRound(jo, i, prod, r, c, auc, maxU, p, q, table, x);
            c.calculate_max(current_price_people, prod, maxU);
            auc.CalculateGrowth(prod);
            prod.CalculatePrice_difference();
            current_price_people.removeAll(current_price_people);
            people.removeAll(people);
        }
    }
    

    public void WriteTextTitul(JTextArea jo, int i, Reader r) {
        jo.setText("");
        jo.append("                                                 Лот №" + r.getArrayProduct().get(i).getLot() + "\n");
        jo.append("                                Начальная цена:" + r.getArrayProduct().get(i).getStartPrice() + "\n");
        jo.append("___________________________________________________\n");
        jo.append("                                               Раунд №1" + "\n");
    }

    
    public void WriteWinner(EffectsAuction auc, int p, JTextArea jo, Reader r) {
        if (auc.getCount_player() == 1) {
            jo.append("\n");
            jo.append("                                  Победил игрок:" + r.getArrayPlayer().get(p).getName() + "\n");
        }
    }

    
    public void WriteFirstRound(JTextArea jo, int i, Product prod, Reader r, Calculate c, EffectsAuction auc, int x) throws Exception {
        this.WriteTextTitul(jo, i, r);
        auc.seetCount_player(0);
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
            prod.setCurrentPrice(0);
            auc.setGrowth(0);
            prod.setPrice_difference(0);
            c.calculate_estimated_price(r, i);
            c.create_first_changeable_parameters(r, j, i);
            c.calculate_emoticons(r, j, i, auc);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > x) {
                people.add(r.getArrayPlayer().get(j).getName());
                r.getArrayPlayer().get(j).CalculatePrice_increase_one(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    current_price_people.add(r.getArrayPlayer().get(j).getPrice_increase());
                    jo.append("            Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + (int) (r.getArrayPlayer().get(j).getPrice_increase()) + "\n");
                    auc.setCount_player();
                    if (r.getArrayPlayer().get(j).getPrice_increase() > maxU) {
                                maxU = r.getArrayPlayer().get(j).getPrice_increase();
                                q = j;
                            }
                }
            }
        }
        r.getArrayPlayer().get(q).setPrice_increase(maxU);
        if (auc.getCount_player() == 0) {
            jo.append("                               Никто не поставил ставку" + "\n");
        }

    }

    
    public void WriteNextRound(JTextArea jo, int i, Product prod, Reader r, Calculate c, EffectsAuction auc, double maxU, int p, int q, JTable table, int x) {
        while (auc.getCount_player() != 1) {
            if (auc.getCount_player() == 0) {
                auc.seetCount_player(1);
                jo.append("                               Никто не поставил ставку" + "\n");
            } else {
                auc.seetCount_player(0);
                jo.append("                                               Раунд №" + p + "\n");
                for (int j = 0; j < r.getArrayPlayer().size(); j++) {
                    c.calculate_emoticons(r, j, i, auc);
                    r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
                    if (r.getArrayPlayer().get(j).getActivity_in_game() > x & people.contains(r.getArrayPlayer().get(j).getName())) {
                        r.getArrayPlayer().get(j).CalculatePrice_increase_next(prod);
                        if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                            auc.setCount_player();
                            current_price_people.add(r.getArrayPlayer().get(j).getPrice_increase());
                            jo.append("            Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + (int) (r.getArrayPlayer().get(j).getPrice_increase()) + "\n");

                            if (r.getArrayPlayer().get(j).getPrice_increase() > maxU) {
                                maxU = r.getArrayPlayer().get(j).getPrice_increase();
                                q = j;
                            }
                        }
                    }
                }
                c.calculate_max(current_price_people, prod, maxU);
                auc.CalculateGrowth(prod);
                prod.CalculatePrice_difference();
                p++;
            }
        }
        this.WriteWinner(auc, q, jo, r);
        this.WriteTableResults(table, maxU, q, i, r);
    }

    
    public void WriteTableResults(JTable table, double maxU, int q, int i, Reader r) {
        if (winner.contains(r.getArrayProduct().get(i).getLot()) == false) {
            DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
            modelTable.addRow(new Object[]{r.getArrayProduct().get(i).getLot(), r.getArrayProduct().get(i).getName() + " " + r.getArrayProduct().get(i).getYear() + " " + "год", r.getArrayPlayer().get(q).getName(), (int) maxU});
            winner.add(r.getArrayProduct().get(i).getLot());
            h++;
        }
    }
}
