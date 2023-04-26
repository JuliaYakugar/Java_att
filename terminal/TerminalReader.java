package terminal;
import view.Menu;

import java.io.IOException;
import java.util.Scanner;

import modules.ToysSlotMachine;
import modules.ToysSlotMachinePrize;

public class TerminalReader {
    
    private Menu menu;
    private ToysSlotMachine toysSM;
    ToysSlotMachinePrize toysSMPrize;

    public TerminalReader(ToysSlotMachine toysSM, ToysSlotMachinePrize toysSMPrize) {
        menu = new Menu();
        this.toysSM = toysSM;
        this.toysSMPrize = toysSMPrize;
    }

    public void runReader() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.menuPrint();
            System.out.print("Введите пункт меню: ");

            String input = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (input.equals("7")) break;

            Command command = new Command(input, toysSM, toysSMPrize);
            command.commandLogic();

            System.out.println("Нажмите Enter для возврата в меню!");
            scanner.nextLine();

        }
        scanner.close();
    }
    
}
