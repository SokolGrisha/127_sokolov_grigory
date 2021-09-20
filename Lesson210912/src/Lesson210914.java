public class Lesson210914 {
    public static void main(String[] args){
//        // <type> <name> [ = <init>];
//        // int iVar = 0;
//        //Типы данных
//        int intVar = 0;  // целые числа со знаком, 4 байта
//        long longVar = 0;  // целые числа со знаком, 8 байта
//        short shortVar = 0;  // целые числа со знаком, 2 байта
//        byte byteVar = 0;  // целые числа со знаком, 1 байта
//
//        float floatVar = 0.0f;  // действительные числа, 4 байта
//        double doubleVar = 0.0;  // действительные числа, 8 байта
//
//        char charVar = 'a';  // символы, 2 байта
//        boolean booleanVar = false;  // булевый тип, 1 байт
//
//        String stringVar = "my string";
//
//        // +, -, *, /, %
//        // +=, -=, /=, *=, %=
//        // ++, --
//        int iVar1 = 10;
//        int iVar2 = 3;
//        // ++iVar1;
//        // iVar1++;
//        System.out.println(iVar1 / iVar2);  //  <int> / <int> - целочисленное деление с отбрасыванием дробной части
//
//        float fVar1 = 10;
//        float fVar2 = 3;
//
//        System.out.println(fVar1 / fVar2);
//
//        //Math.abs(fvar1 - fvar2) < epsilon
//        //System.out.println("Hello world");
//        //System.out.println(iVar);
//
//        //----------------------------------------------
//        // if
//        //----------------------------------------------
//
//        // if (<cond>)
//        //      <statement>
//        //
//        // if (<cond>)
//        //      <statement>
//        // else
//        //      <statement_else>
//        //
//        // if (<cond>)
//        //      <statement>
//        // else if(<cond_2>)
//        //      <statement_2>
//        // ...
//        // else if(<cond_n>)
//        //      <statement_n>
//        // else
//        //      <statement_else>
//        //
//        // if (<cond>)
//        //      <statement>
//        // if(<cond_2>)
//        //      <statement_2>
//        // ...
//        // if(<cond_n>)
//        //      <statement_n>
//        // else
//        //      <statement_else>
//
//        // >, <, ==, !=, >=, <=
//        // &&, ||, !
//
//        //////////////////////////////////////////
//        // switch
//        //////////////////////////////////////////
//
//        // switch(<expr>) {
//        //      case <const_1>:
//        //          <statements>
//        //          break;
//        //      case <const_2>:
//        //          <statements>
//        //          break;
//        //....
//        //      case <const_n>:
//        //          <statements>
//        //          break;
//        //     [default:
//        //          <statements>
//        //          break;]
//        //}
        TaskDemo task = new TaskDemo();
        System.out.println(task.subtask1_if(10, 15));
        System.out.println(task.subtask2_switch(2));
        System.out.println(task.Test());
    }
}
