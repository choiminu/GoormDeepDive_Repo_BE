package level_2.bj2525;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt() + sc.nextInt();

        H += (M / 60);
        M = M % 60;

        System.out.println(H % 24 + " " + M);


    }
}
