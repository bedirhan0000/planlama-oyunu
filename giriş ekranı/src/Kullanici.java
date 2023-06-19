import java.util.Scanner;

public class Kullanici {

    Scanner atama = new Scanner(System.in);
    private String Adi;
    private String SoyAdi;
    private String KullaniciAdi;
    private String Sifre;
    private String TCNo;
    private String TelefonNumarasi;
    private String Email;
    private String Adres;
    private String KullaniciTip;

    public void setKullaniciAdi(String KullaniciAdi) {
        this.KullaniciAdi = KullaniciAdi;
    }
    public String getKullaniciAdi() {
        return this.KullaniciAdi;
    }
    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
    }
    public String getSifre() {
        return this.Sifre;
    }


    public void BilgilerCiktisi() {
        System.out.println("isminiz : " + this.Adi);
        System.out.println("Soy isminiz :" + this.SoyAdi);
        System.out.println("Kullanıcı adınız : " + this.KullaniciAdi);
    }
        public void KayitOlma () {
            System.out.println("İsminizi giriniz :");
            this.Adi = atama.nextLine();
            System.out.println("Soy isminizi giriniz");
            this.SoyAdi = atama.nextLine();
            System.out.println("Kullanıcı Adınızı giriniz:");
            this.KullaniciAdi = atama.nextLine();
            System.out.println("Şifrenizi giriniz");
            this.Sifre = atama.nextLine();
            System.out.println("Tc limlik numaranızı  giriniz:");
            this.TCNo = atama.nextLine();
            System.out.println("Telefon numarınızı giriniz");
            this.TelefonNumarasi = atama.nextLine();
            System.out.println("Mailinizi giriniz");
            this.Email = atama.nextLine();
            System.out.println("Adresinizi giriniz:");
            this.Adres = atama.nextLine();
            System.out.println("Kullanıcı tipinizi giriniz: ");
            System.out.println("Admin iseniz 1 e  basınız");
            System.out.println("Kullanıcı iseniz 2 e  basınız");
            int sayi = atama.nextInt();

            switch (sayi) {
                case 1:
                    System.out.println("Admin");
                    //this.KullaniciTip ==Admin;
                    break;
                case 2:
                    System.out.println("Kullanici");
                    //this.KullaniciTip
            }
        }


    }