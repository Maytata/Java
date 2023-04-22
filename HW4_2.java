package HW;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class HW4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        LinkedList<Integer> linked_list = new LinkedList<>();
        int list_size;

        while (true) {
            System.out.print("Введите размер списка: ");
            try {
                String input = scanner.next();
                list_size = Integer.parseInt(input);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Что-то пошло не так!");
            }
        }

        for (int i = 0; i < list_size; i ++){
            linked_list.add(rnd.nextInt(1, 10));
        }

        System.out.println("\n" + linked_list);
        while (true) {
            System.out.println("Что делаем?");
            System.out.print("Добавляем в конец - (1)\nВозвращаем 1-й и удаляем - (2)\nВозвращаем 1-й и не удаляем - (3)\nВыходим - Q\n> ");
            String operation = scanner.next();
            switch (operation) {
                case "1" -> enqueue(linked_list);
                case "2" -> dequeue(linked_list);
                case "3" -> first(linked_list);
                case "Q" -> System.exit(0);
                default -> System.out.println("\nВы ввели какую-то фигню!");
            }
            System.out.println("\n" + linked_list);
        }

    }

    public static void enqueue(LinkedList<Integer> list){
        while (true) {
            System.out.print("Введите число: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            try {
                int num = Integer.parseInt(input);
                list.add(num);
                return;
            }
            catch (NumberFormatException e){
                System.out.println("Вы опять ввели какую-то фигню!");
            }
        }
    }

    public static void dequeue(LinkedList<Integer> list){
        System.out.print("Первый елемент: " + list.get(0) + "... был!\n");
        list.remove(0);
    }

    public static void first(LinkedList<Integer> list){
        System.out.print("Первый елемент: " + list.get(0) + "\n");
    }
}






