import java.util.Scanner;
public class GriSokolovGame extends Player {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите: Вверх, Вниз, Влево, Вправо или Зав Игру.");
    String command = scanner.nextLine();

    while(command !="Зав Игру")

    {
        if (true) {
            if (command == "Вверх") {
                moveUp();
            } else {
                if (command == "Вниз") {
                    moveDown();
                } else {
                    if (command == "Влево") {
                        moveLeft();
                    } else {
                        if (command == "Вправо") {
                            moveRight();
                        } else {
                            System.out.println("404 не нйдено.");
                            System.out.println("Команды: Вверх, Вниз, Влево, Вправо.");

                        }
                    }
                }
            }
        }
    }


    Map map = new Map();
}