package ch10.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class MessageFormatEx4 {
    public static void main(String[] args) throws Exception {
        String tableName = "CUST_INFO";
        String fileName = "C:\\study\\data4.txt";
        String msg = "INSERT INTO " + tableName + " VALUES ({0}, {1}, {2}, {3});";

        Scanner sc = new Scanner(new File(fileName));

        String pattern = "{0}, {1}, {2}, {3}";
        MessageFormat mf = new MessageFormat(pattern);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Object[] objs = mf.parse(line);
            System.out.println(MessageFormat.format(msg, objs));
        }
        sc.close();

    }
}
