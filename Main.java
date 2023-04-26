import modules.ToysSlotMachine;
import modules.ToysSlotMachinePrize;

import java.io.IOException;

import modules.Toy;
import terminal.TerminalReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        ToysSlotMachine toysSM = new ToysSlotMachine();
        toysSM.addToy(new Toy(0, "Doll", 5, 20));
        toysSM.addToy(new Toy(1, "Car", 10, 10));
        toysSM.addToy(new Toy(2, "Lego", 17, 60));
        toysSM.addToy(new Toy(3, "Domino", 22, 35));

        ToysSlotMachinePrize toysSMPrize = new ToysSlotMachinePrize();

        new TerminalReader(toysSM, toysSMPrize).runReader();
    }
}