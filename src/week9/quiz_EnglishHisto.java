package week9;

import java.util.Scanner;

public class quiz_EnglishHisto {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.length() == 1 && line.charAt(0) == ';')
                break;
            sb.append(line);
        }
        String st = sb.toString();
        st = st.toUpperCase();
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for(int j = 0; j<st.length(); j++) {
                if(st.charAt(j) == (char)('A' + i))
                    count++;
            }
            System.out.print((char)('A' + i));
            for (int k = 0; k < count; k++) {
                System.out.print("-");
            }
            if((char)('A' + i) != 'Z') {
                System.out.print("\n");
            }
        }
    }
}