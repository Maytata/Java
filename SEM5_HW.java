
//Первая задача 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TASK01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, ArrayList<Integer>> contacts_list = new HashMap<>();
        while (true){
            int enter_choice;
            System.out.print("Выбирете действие (1 - добавить, 2 - распечатать, 0 - выйти: ");
            enter_choice = scan.nextInt();
            switch (enter_choice) {
                case 1 -> enter_contact(contacts_list);
                case 2 -> print_contact(contacts_list);
                case 3 -> System.exit(0);
            }
        }
    }

    public static void enter_contact(Map<String, ArrayList<Integer>> contacts_list){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> tel_nums = new ArrayList<>();
        String name_input;
        int num_input;

        System.out.print("Введите фамилию: ");
        name_input = scanner.next();

        System.out.print("Введите номер: ");
        num_input = scanner.nextInt();

        if (!contacts_list.containsKey(name_input)){
             tel_nums.add(num_input);
             contacts_list.put(name_input, tel_nums);
        }
        else {
            tel_nums = contacts_list.get(name_input);
            tel_nums.add(num_input);
            contacts_list.put(name_input, tel_nums);
        }
    }

    public static void print_contact(Map<String, ArrayList<Integer>> contacts_list){
        for (Map.Entry<String, ArrayList<Integer>> entry : contacts_list.entrySet()) {
            System.out.println(entry.getKey() + ": тел. " + entry.getValue());
        }
    }
}


//Вторая задача
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TASK02 {
    public static void main(String[] args) {
        String[] employee_list = {"Иван Иванов","Светлана Петрова","Кристина Белова","Анна Мусина",
                "Анна Крутова","Иван Юрин","Петр Лыков","Павел Чернов","Петр Чернышов","Мария Федорова",
                "Марина Светлова","Мария Савина","Мария Рыкова","Марина Лугова","Анна Владимирова","Иван Мечников",
                "Петр Петин","Иван Ежов"};

        Map<String, Integer> employee_counter = new HashMap<>();

        for (String employee : employee_list){
            int counter;
            String[] name = employee.split(" ");
            employee_counter.putIfAbsent(name[0], 1);
            if (employee_counter.containsKey(name[0])) {
                counter = employee_counter.get(name[0]);
                counter ++;
                employee_counter.put(name[0], counter);

            }
        }

        Map<String, Integer> names_sorted_list = new LinkedHashMap<>();
        while (!employee_counter.isEmpty()) {
            int common_name_counter = 0;
            String name_found = "";
            for (Map.Entry<String, Integer> entry : employee_counter.entrySet()) {
                if (common_name_counter < entry.getValue()){
                    common_name_counter = entry.getValue();
                    name_found = entry.getKey();
                }
            }

            names_sorted_list.put(name_found, common_name_counter);
            employee_counter.remove(name_found);
        }

        for (Map.Entry<String, Integer> item : names_sorted_list.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }
}


//Третья задача 
import java.util.ArrayList;
import java.util.Random;

public class TASK03 {
    public static void main(String[] args) {
        int queens = 0;
        char[][] clear = new char[8][8];
        char[][] desk = new char[8][8];
        Random rnd = new Random();
        int place_the_queen;

        while (queens < 8){
            ArrayList<Integer> queen_arr = new ArrayList<>();

            for (int c = 0; c < 8; c++){
                if (desk[queens][c] != 'n'){
                    queen_arr.add(c);
                }
            }

            if (queen_arr.size() == 0){
                queens = 0;
                for (int i = 0; i < desk.length; i ++){
                    System.arraycopy(clear[i], 0, desk[i], 0, desk.length);
                }
                for (int c = 0; c < 8; c++){
                    if (desk[queens][c] != 'n'){
                        queen_arr.add(c);
                    }
                }
            }

            place_the_queen = rnd.nextInt(0, queen_arr.size());

            desk[queens][queen_arr.get(place_the_queen)] = 'x';

            int shift = 1;
            for (int k = queens + 1; k < desk.length; k ++){
                for (int m = 0 ; m < desk.length; m ++){
                    if (m == queen_arr.get(place_the_queen) && k != queens) {
                        desk[k][m] = 'n';
                    }
                    if (m != queen_arr.get(place_the_queen) && k == queens) {
                        desk[k][m] = 'n';
                    }
                    if ((m == queen_arr.get(place_the_queen) + shift && k == queens + shift) ||
                            (m == queen_arr.get(place_the_queen) - shift && k == queens + shift)) {
                        desk[k][m] = 'n';
                    }
                }
                shift ++;
            }

            queens ++;

        }

        for (char[] chars : desk) {
            for (int j = 0; j < desk.length; j++) {
                if (chars[j] != 'x') {
                    System.out.print("|" + ' ');
                } else System.out.print("|" + chars[j]);
                if (j == desk.length - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }

    }
}
