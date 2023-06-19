import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner klavye = new Scanner(System.in);
        System.out.println();
        // Dosyayı oluşturuyor
        File file = new File("kod.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        String KullaniciIsmi;
        String KullaniciSifresi;

        Kullanici Bilgiler = new Kullanici();
        BufferedReader bReader = new BufferedReader(new FileReader(file));

        System.out.println("Yeni kayıt olmak için 1'e basınız");
        System.out.println("Giriş yapmak için 2'ye basınız");
        System.out.println("Çıkış yapmak için 0'a basınız");
        int secilenSayi = klavye.nextInt();

        switch (secilenSayi) {
            case 1:
                System.out.println("Kayıt oluşturuluyor");
                Bilgiler.KayitOlma();
                KullaniciIsmi = Bilgiler.getKullaniciAdi();
                KullaniciSifresi = Bilgiler.getSifre();

                BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, true));
                bWriter.write(KullaniciIsmi);
                bWriter.newLine();
                bWriter.write(KullaniciSifresi);
                bWriter.newLine();
                bWriter.close();

                Bilgiler.BilgilerCiktisi();
                break;
            case 2:
                System.out.println("Giriş yapılıyor");
                System.out.print("Kullanıcı Adı: ");
                String kullaniciAdiGiris = klavye.next();
                System.out.print("Şifre: ");
                String sifreGiris = klavye.next();

                String okunanBilgi;
                boolean girisBasarili = false;
                while ((okunanBilgi = bReader.readLine()) != null) {
                    if (okunanBilgi.equals(kullaniciAdiGiris)) {
                        String sifre = bReader.readLine();
                        if (sifre.equals(sifreGiris)) {
                            System.out.println("Giriş başarılı.");
                            girisBasarili = true;
                            break;
                        }
                    }
                }
                bReader.close();

                if (!girisBasarili) {
                    System.out.println("Hatalı kullanıcı adı veya şifre. Giriş başarısız.");
                }
                break;
            case 0:
                System.out.println("Çıkış yapılıyor");
                break;
            default:
                System.out.println("Yanlış sayı ile işlem yaptınız");
        }
    }
}
