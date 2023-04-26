package terminal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modules.ToysSlotMachine;
import modules.ToyPrize;
import modules.ToysSlotMachinePrize;
import modules.Toy;

public class Command {
    private String commandStr;
    private ToysSlotMachine toysSM;
    private ToysSlotMachinePrize toysSMPrize;
    private ArrayList<Double> procToys;

    public Command(String commandStr, ToysSlotMachine toysSM, ToysSlotMachinePrize toysSMPrize) {
        this.commandStr = commandStr;
        this.toysSM = toysSM;
        this.toysSMPrize = toysSMPrize;
        this.procToys = new ArrayList<Double>();
    }

    public void commandLogic() throws IOException {

        if (commandStr.equals("1")) {
            if (this.toysSM.getSizeToysSM() > 0) {
                this.toysSM.printToysSM();
            } else {
                System.out.println("Нет игрушек");
            }
            
        }

        if (commandStr.equals("2")) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Введите название игрушки: ");
                String name = scanner.nextLine();
                System.out.print("Введите количество: ");
                String quantity = scanner.nextLine();
                System.out.print("Введите шанс выпадения (0-100): ");
                String chance = scanner.nextLine();
                this.toysSM.addToy(new Toy(toysSM.getSizeToysSM() + 1, name, Integer.parseInt(quantity), Integer.parseInt(chance)));
                System.out.println("--------------------\nИгрушка \"" + name + "\" добавлена в автомат\n--------------------\n");
                break;
            }
        }

        if (commandStr.equals("3")) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Введите ID игрушки для изменения шанса: ");
                String id = scanner.nextLine();
                Toy searchToy = toysSM.searchToy(Integer.parseInt(id));
                if (searchToy != null) {
                    System.out.print("Текущий шанс - " + searchToy.getChance() + ", введите новый: ");
                    int newChance = Integer.parseInt(scanner.nextLine());
                    searchToy.setChance(newChance);
                } else {
                    System.out.println("ID не найден");
                }
                break;
            }
        }

        if (commandStr.equals("4")) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Розыгрыш!!! ");
                if (toysSM.getSizeToysSM() > 0) {
                    
                    int sumChance = 0;
                    for (Toy toy : toysSM.getToysSM()) {
                        procToys.add((double) toy.getChance());
                        sumChance += toy.getChance();
                    }

                    for (int d = 0; d < procToys.size(); d++) {
                        procToys.set(d, ((double)100 / (double)sumChance * (double)procToys.get(d)));
                    }
                    
                    int randomToy = new Random().nextInt(100);

                    Double i = 0.0;
                    for (int d = 0; d < procToys.size()+1; d++) {
                        i += procToys.get(d);

                        if (i >= randomToy) {

                            for (Toy toy : toysSM.getToysSM()) {
                                if (toy.getId() == d) {
                                    toy.setQuantity(toy.getQuantity()-1);
                                    ToyPrize TP = new ToyPrize(toy.getId(), toy.getName());
                                    this.toysSMPrize.addToyPrize(TP);
                                    System.out.println("Разыграна игрушка: " + TP.getName() + "!");
                                    break;
                                }
                            }
                            
                            break;
                        }
                    }

                } else {
                    System.out.println("Нет игрушек для розыгрыша!");
                }
                break;
            }
        }

        if (commandStr.equals("5")) {
            this.toysSMPrize.printToysSMPrize();
        }

        if (commandStr.equals("6")) {
            Scanner scanner = new Scanner(System.in);

            if (this.toysSMPrize.getSizeToysSMPrize() > 0) {
                ToyPrize toyPrize = this.toysSMPrize.getToysSMPrize().get(0);

                FileWriter writer = new FileWriter("file.txt", true);
                writer.write(toyPrize.toString() + "\n");
                writer.flush();
                writer.close();
                System.out.println("Игрушка " + toyPrize.getName() + " вручена!");

                this.toysSMPrize.getToysSMPrize().remove(0);
            } else {
                System.out.println("Нет призов для вручения!");
            }

            
        }

    }

}
