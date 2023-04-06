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
