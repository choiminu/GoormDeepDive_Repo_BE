package level_1.bj11382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long sum = 0L;
        for(String str : br.readLine().split(" ")) {
            sum += Long.parseLong(str);
        }

        System.out.println( sum);
    }
}
