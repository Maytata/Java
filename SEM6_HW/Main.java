import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> nb_set = new HashSet<>();
        Notebook nb_1 = new Notebook("Samsung", "Linux", 256, 128, 17, 499.99, "silver");
        nb_set.add(nb_1);
        Notebook nb_2 = new Notebook("Samsung", "Windows", 512, 128, 15, 399.99, "white");
        nb_set.add(nb_2);
        Notebook nb_3 = new Notebook("Apple", "MacOS", 2048, 1024, 17, 899.99, "silver");
        nb_set.add(nb_3);
        Notebook nb_8 = new Notebook("Apple", "MacOS", 512, 256, 17, 799.99, "black");
        nb_set.add(nb_8);
        Notebook nb_4 = new Notebook("Toshiba", "Windows", 512, 128, 13, 399.99, "grey");
        nb_set.add(nb_4);
        Notebook nb_5 = new Notebook("Lenovo", "Windows", 256, 64, 13, 299.99, "black");
        nb_set.add(nb_5);
        Notebook nb_6 = new Notebook("Lenovo", "Windows", 128, 512, 13, 629.99, "red");
        nb_set.add(nb_6);
        Notebook nb_7 = new Notebook("Acer", "Windows", 512, 128, 15, 629.99, "black");
        nb_set.add(nb_7);

        Map<Integer, String> field_params = new HashMap<>();
        Field[] fields = Notebook.class.getDeclaredFields();
        int counter = 1;

        for (Field item : fields) {
            String field = item.toString();
            int value = field.indexOf("Notebook.");
            field = field.substring(value + 9);
            field_params.put(counter, field);
            counter++;
        }

        List<Integer> numeric_params = Arrays.asList(3, 4, 5, 7);
        int search_param;
        int field_param;
        String search_field;
        String final_search_param;

        while (true) {
            System.out.println("Choose parameter: ");
            boolean is_numeric_search = false;
            Map<Integer, String> search_params = new HashMap<>();

            field_param = print_params(field_params);
            search_field = field_params.get(field_param);

            if (field_param == 0) System.exit(0);

            if (numeric_params.contains(field_param)) {
                is_numeric_search = true;
                Parameters.fill_params(search_params, search_field, nb_set);
                while (true) {
                    System.out.println("\nChoose minimum parameter: ");
                    search_param = print_params(search_params);
                    if (search_param == 0) {
                        System.out.println();
                        break;
                    } else {
                        final_search_param = search_params.get(search_param);
                        Parameters.search_result(nb_set, final_search_param, search_field, is_numeric_search);
                    }
                }

            } else {
                Parameters.fill_params(search_params, search_field, nb_set);
                while (true) {
                    System.out.println("\nChoose parameter: ");
                    search_param = print_params(search_params);
                    if (search_param == 0) {
                        System.out.println();
                        break;
                    } else {
                        final_search_param = search_params.get(search_param);
                        Parameters.search_result(nb_set, final_search_param, search_field, is_numeric_search);
                    }
                }
            }
        }
    }

    public static int print_params(Map<Integer, String> print_map) {
        Scanner scan = new Scanner(System.in);

        print_map.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("... or type '0' to cancel");
        System.out.print(">> ");

        String res = scan.next();
        while (true) {
            try {
                int choice = Integer.parseInt(res);
                if (0 <= choice && choice <= print_map.size()) {
                    return Integer.parseInt(res);
                } else {
                    System.out.println("Something went wrong!");
                    System.out.print(">> ");
                    res = scan.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong!");
                System.out.print(">> ");
                res = scan.next();
            }
        }

    }
}
