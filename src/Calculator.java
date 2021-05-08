import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    public static int count = 0;
    public static void main(String[] args)throws Exception{

        System.out.println("Введите выражение формата: \"a + b\"");
        while (true){
            count = 0;
            int number1, number2;
            String str = input();
            int result;

            if (str.equals("exit"))
                break;

            String[] words = str.split(" ");
            if (words.length == 3) {
                number1 = strToNum(words[0]);
                number2 = strToNum(words[2]);
                if ((number1 > 10 || number1 < 0 ) || (number2 > 10 || number2 < 0))
                    throw new Exception("Неверный формат строки!");
                result = calculate(number1, number2, words[1].charAt(0));
                if (count == 2)
                    //входящие числа были римские, над бы результат перевести в римские
                    System.out.println(ConvertResult.toRom(result));
                else if (count == 1 || count < 0)
                    //в выражении одно число римское или вообще не число
                    throw new Exception("Неверный формат строки!");
                else System.out.println(result);
            }else throw new Exception("Неверный формат строки!");
        }
    }

    public static String input()throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static int strToNum(String str){
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e) {
            //пробуем перевести в арабские
            if (Convert.toInt(str) != 0)
               count++;
            else
                count -=2;

            return Convert.toInt(str);
        }
    }

    public static int calculate(int a, int b, char mat)throws Exception{
        int result;
        switch (mat){
            case '*':
                result = a * b;
                break;
            case '+':
                result = a + b;
                break;
            case '/':
                result = a / b;
                break;
            case '-':
                result = a - b;
                break;
            default:
                throw new Exception("Неверный формат строки!");
        }
        return result;
    }
}
