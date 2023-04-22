package HW;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class HW4_1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random rnd = new Random();
            LinkedList<Integer> linked_list = new LinkedList<>();

            System.out.print("Введите размер списка: ");
            int list_size = scanner.nextInt();

            long start = System.nanoTime();

            for (int i = 0; i < list_size; i ++){
                linked_list.add(rnd.nextInt(1, 10));
            }
            System.out.println(linked_list);

            System.out.println("Цикл for и доп. лист: ");
            LinkedList<Integer> reversed_list = new LinkedList<>();
            for (int i = linked_list.size() - 1; i >= 0; i -- ){
                reversed_list.add(linked_list.get(i));
            }
            System.out.println(reversed_list);
        }
    }

