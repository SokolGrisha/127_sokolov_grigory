public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int c = 0;
        int d = n2;
        if (n2 < n1) {
            n2 = n1;
            n1 = d;
        }

        for(int i = n1; i <= n2; ++i) {
            if (i % a == 0 & i % b != 0) {
                ++c;
            }
        }

        return c;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int x = 0;
        int y = 1;

        for(int i = 1; i <= num; x = y++) {
            i += y;
        }

        return x;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int a = num;
        int a0 = num;

        for(int i = 1; i < cnt; ++i) {
            int an = a0 * d + 1;
            a0 = an;
            a += an;
        }

        return a;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int sn = 1;
        int x = 0;

        for(int i = 1; i <= n; ++i) {
            sn *= i;
            x += sn;
        }

        return x;
    }
}
