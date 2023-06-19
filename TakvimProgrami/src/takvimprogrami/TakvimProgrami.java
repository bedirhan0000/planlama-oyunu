
package takvimprogrami;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TakvimProgrami {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secim = "";

        while (!secim.equals("q")) {
            //takvim menüsü
            System.out.println("1 - Takvimi Göster");
            System.out.println("2 - Güne Not Ekle");
            System.out.println("3 - Takvimi Sıfırla");
            System.out.println("q - Çıkış");
            System.out.print("Bir seçenek girin: ");
            secim = scanner.nextLine();
               
            //switch case ile seçimleri fonksiyonlara yönlendiriyoruz
            switch (secim) {
                case "1":
                    takvimiGoster();
                    break;
                case "2":
                    NotEkle(scanner);
                    break;
                case "3":
                    takvimiSifirla(scanner);
                    break;
                case "q":
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
                    break;
            }
        }
    }
        //takvimiGoster fonksiyonu
    private static void takvimiGoster() {
        try {
            File dosya = new File("takvim.txt");
            if (!dosya.exists()) {
                System.out.println("Takvim dosyası bulunamadı!");
                return;
            }

            List<String> notlar = new ArrayList<>();

            Scanner scanner = new Scanner(dosya);
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                notlar.add(satir);
            }
            scanner.close();

            Collections.sort(notlar, new Comparator<String>() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                @Override
                public int compare(String o1, String o2) {
                    try {
                        Date tarih1 = dateFormat.parse(o1.split(";", 2)[0]);
                        Date tarih2 = dateFormat.parse(o2.split(";", 2)[0]);
                        return tarih1.compareTo(tarih2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            });

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String bugununTarihi = dateFormat.format(new Date());

            System.out.println("-------TAKVİM-------");
            System.out.println("Bugün: " + bugununTarihi);
            for (String not : notlar) {
                String[] parcalar = not.split(";", 2);
                String tarih = parcalar[0];
                String notIcerik = parcalar[1];
                System.out.println(tarih + ": " + notIcerik);
            }
            System.out.println("---------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void NotEkle(Scanner scanner) {
        try {
            System.out.print("Not eklemek istediğiniz tarihi girin (GG/AA/YYYY): ");
            String tarih = scanner.nextLine();
            System.out.print("Notu girin: ");
            String not = scanner.nextLine();

            File dosya = new File("takvim.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            PrintWriter out = new PrintWriter(yazici);
            out.println(tarih + ";" + not);
            out.close();

            System.out.println("Not başarıyla eklendi!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void takvimiSifirla(Scanner scanner) {
        System.out.print("Takvimi sıfırlamak istediğinizden emin misiniz? (E/H): ");
        String onay = scanner.nextLine();

        if (onay.equalsIgnoreCase("E")) {
            try {
                File dosya = new File("takvim.txt");
                if (!dosya.exists()) {
                    System.out.println("Takvim dosyası bulunamadı!");
                    return;
                }

                dosya.delete();
                dosya.createNewFile();

                System.out.println("Takvim sıfırlandı!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Takvim sıfırlama işlemi iptal edildi.");
        }
    }
}
