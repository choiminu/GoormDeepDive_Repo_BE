package task10;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Task_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("계산할 숫자와 연산자를 입력해주세요 ex -> 9 + 2");
        String[] input = sc.nextLine().split(" ");

        BiFunction<Double, Double, Double> add = (a, b) -> a + b;
        BiFunction<Double, Double, Double> sub = (a, b) -> a - b;
        BiFunction<Double, Double, Double> mul = (a, b) -> a * b;
        BiFunction<Double, Double, Double> div = (a, b) -> {

            if (b == 0 || a == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }

            return a / b;
        };

        double result = 0.0;

        switch (input[1]) {
            case "+" :
                result = add.apply(Double.parseDouble(input[0]), Double.parseDouble(input[2]));
                break;
            case "-" :
                result = sub.apply(Double.parseDouble(input[0]), Double.parseDouble(input[2]));
                break;
            case "*" :
                result = mul.apply(Double.parseDouble(input[0]), Double.parseDouble(input[2]));
                break;
            case "/" :
                result = div.apply(Double.parseDouble(input[0]), Double.parseDouble(input[2]));
                break;
        }
        System.out.println(result);
    }

}
