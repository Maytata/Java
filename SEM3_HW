//Вторая задача

package HW;

import java.util.ArrayList;

public class HW3_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(10);
        list.add(500);
        System.out.println("среднее арифметическое: " + average(list));

        int min = list.get(0);
        int max = list.get(0);

        for (Integer i: list) {
            if(i < min)
                min = i;
            if(i > max)
                max = i;
        }

        System.out.println("минимальное число: " + min);
        System.out.println("максимальное число: " + max);

    }


    static double average (ArrayList<Integer> list) {
        double sum = 0;
        for(int i=0;i<list.size();i++) {
            sum+=list.get(i);
        }
        return sum/list.size();
    }
}



//Первая задача

package HW;

import java.util.ArrayList;
import java.util.Iterator;

public class HW3_1 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(23);
        al.add(38);
        al.add(1);
        al.add(2);
        System.out.println(al);
        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            int x = (Integer)itr.next();
            if (x%2==0)
                itr.remove();
        }


        System.out.print(al);

    }


}


