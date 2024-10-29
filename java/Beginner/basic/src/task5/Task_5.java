package task5;

public class Task_5 {
    public static void main(String[] args) {
        System.out.println("10 + 5 = " +  add(10, 5));
        System.out.println("10 - 5 = " + sub(10, 5));
    }

    private static int add (int value1, int value2) {
        return value1 + value2;
    }

    private static int sub(int value1, int value2) {
        return value1 - value2;
    }
}
