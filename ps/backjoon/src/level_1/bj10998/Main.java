package level_1.bj10998;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        System.out.println(Integer.parseInt(split[0]) * Integer.parseInt(split[1]));
    }
}
