package level_1.bj10869;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);

        bw.write(x + y + "\n");
        bw.write(x - y + "\n");
        bw.write(x * y + "\n");
        bw.write(x / y + "\n");
        bw.write(x % y + "\n");

        bw.flush();

    }
}
