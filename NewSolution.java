import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *Описание алгоритма:
 * Пользователю предлагается ввести две строки.
 * Затем строки преобразуютс во множества с помощью метода stringToSet().
 * Далее с помощью метода intersection() находится пересечение этих
 * множеств, т.е.  элементы, встречающиеся в обоих строках.
 * Метод printSet выводит эти элементы на экран.
 *------------------------------------------------------------------------------
 * Оценка временной сложности в худшем случае:
 * Временная сложность метода формирования первого множества из строки: O(n*k),
 * где n - длина строки, k - кол-во неповторяющихся элементов первой строки.
 * Временная сложность метода формирования второго множества из строки: O(m*l),
 * где m - длина строки, l - кол-во неповторяющихся элементов второй строки.
 * Временная сложность метода пересечения двух множеств: O(l*k).
 * Временная сложность всего алгоритма: O(max( n*k, m*l, l*k)).
 */
public class NewSolution {
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первую строку");
        String s1 = r.readLine();
        System.out.println("Введите вторую строку");
        String s2 = r.readLine();

        Set set1 = stringToSet(s1);
        Set set2 = stringToSet(s2);

        Set resultSet = intersection(set1, set2);
        printSet(resultSet);

    }

    public static Set stringToSet(String s) {
        int length = s.length();
        Set set = new HashSet();
        for (int i = 0; i < length; i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public static Set intersection(Set set1, Set set2) {
        Iterator iterator = set1.iterator();

        Set resultSet = new HashSet();

        while (iterator.hasNext()) {
            Object tmp = iterator.next();
            boolean t = set2.contains(tmp);
            if (t) {
                resultSet.add(tmp);
            }

        }
        return resultSet;
    }

    public static void printSet(Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
