import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        if (data == null) {
            return null;
        } else {
            ArrayList<Integer> list = new ArrayList();

            for(int i = 0; i < data.size(); ++i) {
                if ((Integer)data.get(i) % k == 0 && (Integer)data.get(i) % n != 0) {
                    list.add((Integer)data.get(i));
                }
            }

            return list;
        }
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> list = new ArrayList();
        int i = 0;
        int cur = 1;

        for(int pos = 0; i < size; ++i) {
            list.add(cur);
            ++pos;
            if (pos == cur) {
                ++cur;
                pos = 0;
            }
        }

        return list;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        s1.retainAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        s2.removeAll(s1);
        return s2;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> temp = new HashSet(s1);
        temp.removeAll(s2);
        HashSet<Integer> s3 = new HashSet(s2);
        s3.removeAll(s1);
        s3.addAll(temp);
        temp.clear();
        return s3;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String, Double> words = new HashMap();

        for(int i = 0; i < data.size(); ++i) {
            double frequency = 0.0D;

            for(int j = 0; j < data.size(); ++j) {
                if (data.get(i) == data.get(j)) {
                    ++frequency;
                }
            }

            frequency = frequency * 100.0D / (double)data.size();
            words.put((String)data.get(i), frequency);
        }

        return words;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String, Double> newMap = new HashMap();
        double max = (Double)data.get(0);
        double min = (Double)data.get(0);
        double mean = 0.0D;

        for(int i = 0; i < data.size(); ++i) {
            if ((Double)data.get(i) < min) {
                min = (Double)data.get(i);
            }

            if ((Double)data.get(i) > max) {
                max = (Double)data.get(i);
            }

            mean += (Double)data.get(i);
        }

        mean /= (double)data.size();
        newMap.put("max", max);
        newMap.put("min", min);
        newMap.put("mean", mean);
        return newMap;
    }
}
