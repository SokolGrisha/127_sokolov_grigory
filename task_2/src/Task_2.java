public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int i = 2;
        int sqrt;
        for (sqrt = i * i; sqrt <= num; sqrt = i * i) {
            ++i;
        }
        --i;
        sqrt = i * i;
        return sqrt;
    }


    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int p = 1;
        for (int k = 1; k <= num; ++k) {
            p = 2 * p + 6;
        }

        return p;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        int base1;
        for (base1 = base; base1 < num; base1 *= base) {
        }

        return base1 == num;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int i;
        for (i = 0; start > end; ++i) {
            if (start % 2 == 0 && start / 2 >= end) {
                start /= 2;
            } else {
                --start;
            }
        }
        return i;
    }
}



