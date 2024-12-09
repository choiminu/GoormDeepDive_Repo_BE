package level_3.bj10950;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            bw.write(Integer.parseInt(input[0]) + Integer.parseInt(input[1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
