package modules;
import java.util.ArrayList;

public class ToysSlotMachinePrize {

    private ArrayList<ToyPrize> toysSMPrize;

    public ToysSlotMachinePrize() {
        this.toysSMPrize = new ArrayList<ToyPrize>();
    }

    public ArrayList<ToyPrize> getToysSMPrize() {
        return toysSMPrize;
    }

    public int getSizeToysSMPrize() {
        return toysSMPrize.size();
    }

    public void printToysSMPrize() {
        System.out.println("Призовые игрушки:");
        for (ToyPrize toyPrize : this.toysSMPrize) {
            System.out.print(toyPrize + "\n");
        }
    }

    public void addToyPrize(ToyPrize toyPrize) {
        this.toysSMPrize.add(toyPrize);
    }

    @Override
    public String toString() {
        return "Призовые игрушки:\n" + this.toysSMPrize;
    }

}
