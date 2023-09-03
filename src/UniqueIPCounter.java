import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.io.File;

// Этот код читает файл строка за строкой и преобразует каждую строку с IPv4 адресом в целое число (`int`)
// с использованием битовых операций. Затем он добавляет это число в HashSet для подсчета уникальных адресов.
public class UniqueIPCounter {

    public static void main(String[] args) {
        String filename = "C:/Users/skela/Desktop/IP_adress.txt"; // Укажите путь к вашему текстовому файлу с IP-адресами
        HashSet<Integer> uniqueIPs = new HashSet<>();

        File file = new File(filename);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int ip = ipStringToInteger(line);
                    uniqueIPs.add(ip);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int uniqueCount = uniqueIPs.size();
            System.out.println("Количество уникальных IP-адресов: " + uniqueCount);
        } else {
            System.out.println("Такого файла нет.");
        }


    }

    private static int ipStringToInteger(String ipStr) {
        String[] parts = ipStr.split("\\.");
        int result = 0;
        for (String part : parts) {
            result = result << 8 | Integer.parseInt(part);
        }
        return result;
    }
}