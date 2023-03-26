package HW;
import java.util.Scanner;

public class sem1HW {
    public static void main (String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Input n: ");
        int num = iScanner.nextInt();
        iScanner.close();
        int sum = 0;
        int exp = 1;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
            exp = exp * i;
        }
        System.out.println(sum);
        System.out.println(exp);


    

    }
    

    
}



package HW;
import java.util.Scanner;

public class sem1HWtask2 {
    static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }
 
    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }
 
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }
 
    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}
