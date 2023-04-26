package modules;
import java.util.ArrayList;

public class ToysSlotMachine {

    private ArrayList<Toy> toysSM;

    public ToysSlotMachine() {
        this.toysSM = new ArrayList<Toy>();
    }

    public ArrayList<Toy> getToysSM() {
        return toysSM;
    }

    public int getSizeToysSM() {
        return toysSM.size();
    }

    public void printToysSM() {
        System.out.println("Игрушки:");
        for (Toy toy : toysSM) {
            System.out.print(toy + "\n");
        }
    }

    public void addToy(Toy toy) {
        this.toysSM.add(toy);
    }

    public Toy searchToy(int id) {
        for (Toy toy : toysSM) {
            if (id == toy.getId()) {
                return toy;
            }
        }
        return null;
    }
    
}
