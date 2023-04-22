//Первая 

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class task_01 {
    public static void main(String[] args) {

        int[] my_arr = new int[]{6,4,5,3,8,9,0,1};
        int temp;
        String to_log;
        for (int j = 0; j < my_arr.length; j ++) {
            for (int i = 0; i < my_arr.length - 1 - j; i ++){
                if (my_arr[i] > my_arr[i + 1]){
                    temp = my_arr[i];
                    my_arr[i] = my_arr[i + 1];
                    my_arr[i + 1] = temp;
                }
            try(FileWriter writer = new FileWriter("log_file.txt", true))
            {
                Date date = new Date();
                String date_to_write = date + ": " + "i-" + i + " ";
                writer.write(date_to_write);
                to_log = Arrays.toString(my_arr);
                writer.write(to_log);
                writer.append('\n');
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            }
        }
        System.out.print(Arrays.toString(my_arr));
    }
}


//Вторая
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task_02 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        BufferedReader reader;
        StringBuilder new_string = new StringBuilder();
        System.out.println("Решение через обработку при чтении из файла:");
        try {
            reader = new BufferedReader(new FileReader("data_file.txt"));
            String line = reader.readLine();
            while (line != null) {
                int i = 0;
                new_string.append("Студент ");
                i = move_idx(i, line);
                i = write_string(i, line, new_string);

                new_string.append(" получил ");
                i = move_idx(i, line);
                i = write_string(i, line, new_string);

                new_string.append(" по предмету ");
                i = move_idx(i, line);
                write_string(i, line, new_string);

                System.out.println(new_string);
                new_string.setLength(0);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Время:" + elapsed);


        start = System.nanoTime();
        System.out.println("\nРешение через метод split() и массив:");

        try {
            reader = new BufferedReader(new FileReader("data_file.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] str_array = line.split("[\",:]");
                for (String s : str_array) {
                    switch (s) {
                        case "фамилия" -> new_string.append("Студент ");
                        case "оценка" -> new_string.append(" получил ");
                        case "предмет" -> new_string.append(" по предмету ");
                        default -> new_string.append(s);
                    }
                }
                System.out.println(new_string);
                new_string.setLength(0);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("Время:" + elapsed);

    }
    public static int move_idx(int i, String line){
        while (line.charAt(i) != ':') i ++;
        return i;
    }

    public static int write_string(int i, String line, StringBuilder new_string){
        i ++;
        while (line.charAt(i) != ',' && i != line.length() - 1){
            if (line.charAt(i) != '\"') new_string.append(line.charAt(i));
            i ++;
        }
        return i;
    }
}


//Третья 
import java.util.Scanner;

public class task_03 {
    public static void main(String[] args) {
        Scanner scan_line = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String string_to_check = scan_line.next();

        System.out.print(is_polyndromic(string_to_check));
    }

    public static boolean is_polyndromic(String string_to_check){
        int forward_idx = 0;
        int backward_idx = string_to_check.length() - 1;
        while (forward_idx < backward_idx) {
            if (string_to_check.charAt(forward_idx) == string_to_check.charAt(backward_idx)){
            forward_idx ++;
            backward_idx --;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
