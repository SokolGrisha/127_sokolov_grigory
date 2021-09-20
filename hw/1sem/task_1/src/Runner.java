import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        /*** Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свое фамилию и имя");
        String name = scanner.nextLine();
        Task_1 task = new Task_1();
        Task_1_Tests.test(task, name);***/
        Task_1 task = new Task_1();
        System.out.println(task.subtask_1_if(1,2,3));
        System.out.println(task.subtask_2_if(2000));


    }
}
