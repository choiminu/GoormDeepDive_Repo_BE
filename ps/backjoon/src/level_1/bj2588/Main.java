package level_1.bj2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        System.out.println((B.charAt(2) - '0') * Integer.parseInt(A));
        System.out.println((B.charAt(1) - '0') * Integer.parseInt(A));
        System.out.println((B.charAt(0) - '0') * Integer.parseInt(A));
        System.out.println(Integer.parseInt(B) * Integer.parseInt(A));
    }
}
