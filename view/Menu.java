package view;

public class Menu {

    public void menuPrint() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("1. Показать все игрушки\n" +
        "2. Добавить игрушку\n" +
        "3. Изменить шанс выпадения игрушки\n" +
        "4. Розыгрыш!\n" +
        "5. Показать призовые игрушки\n" +
        "6. Выдать призовую игрушку\n" +
        "7. Выход\n");
    }
    
}
