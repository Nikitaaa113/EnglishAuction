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

    public void setTextArea(JTextArea jo, int i, Product prod, Reader r, Calculate c, EffectsAuction auc, JTable table) {
        double maxU = 0; //Размер максимальной ставки
        int p = 2; //Номер раунда
        int l = 1; // Проверка на количество игроков в раунде
        int q = 0; // Для запоминания игрока, который выиграл
        this.WriteFirstRound(jo, i, prod, r, c, auc);
        c.calculate_max(current_price_people, prod, maxU);
        auc.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        auc.seetCount_player(-10);
        this.WriteNextRound(jo, i, prod, r, c, auc, maxU, p, l, q, table);
        c.calculate_max(current_price_people, prod, maxU);
        auc.CalculateGrowth(prod);
        prod.CalculatePrice_difference();
        current_price_people.removeAll(current_price_people);
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

    public void WriteFirstRound(JTextArea jo, int i, Product prod, Reader r, Calculate c, EffectsAuction auc) {
        this.WriteTextTitul(jo, i, r);
        for (int j = 0; j < r.getArrayPlayer().size(); j++) {
            prod.setCurrentPrice(0);
            auc.setGrowth(0);
            prod.setPrice_difference(0);
            c.calculate_estimated_price(r, i);
            c.create_first_changeable_parameters(r, j, i);
            c.calculate_emoticons(r, j, i, auc);
            r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
            if (r.getArrayPlayer().get(j).getActivity_in_game() > 2) {
                people.add(r.getArrayPlayer().get(j).getName());
                r.getArrayPlayer().get(j).CalculatePrice_increase_one(prod);
                if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                    current_price_people.add(r.getArrayPlayer().get(j).getPrice_increase());
                    jo.append("            Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + (int) (r.getArrayPlayer().get(j).getPrice_increase()) + "\n");
                }
            }
        }
    }

    public void WriteNextRound(JTextArea jo, int i, Product prod, Reader r, Calculate c, EffectsAuction auc, double maxU, int p, int l, int q, JTable table) {
        while (auc.getCount_player() != 1) {
            if (auc.getCount_player() == 0) {
                auc.seetCount_player(1);
                l = 0;
            } else {
                auc.seetCount_player(0);
                jo.append("                                               Раунд №" + p + "\n");
                l = 0;
                for (int j = 0; j < r.getArrayPlayer().size(); j++) {
                    c.calculate_emoticons(r, j, i, auc);
                    r.getArrayPlayer().get(j).CalculateActivity_in_game(prod);
                    if (r.getArrayPlayer().get(j).getActivity_in_game() > 2 & people.contains(r.getArrayPlayer().get(j).getName())) {
                        r.getArrayPlayer().get(j).CalculatePrice_increase_next(prod);
                        if (r.getArrayPlayer().get(j).getPrice_increase() > prod.getCurrentPrice()) {
                            auc.setCount_player();
                            current_price_people.add(r.getArrayPlayer().get(j).getPrice_increase());
                            jo.append("            Игрок " + r.getArrayPlayer().get(j).getName() + " поставил ставку в размере " + (int) (r.getArrayPlayer().get(j).getPrice_increase()) + "\n");
                            l++;
                            if (r.getArrayPlayer().get(j).getPrice_increase() > maxU) {
                                maxU = r.getArrayPlayer().get(j).getPrice_increase();
                                q = j;
                            }
                        }
                    }
                }
                if (l == 0) {
                    jo.append("                               Никто не поставил ставку" + "\n");
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
