package universiteotomasyonu.kullanici;

import java.io.*;
import java.util.Scanner;

public abstract class Kullanici  //abstract üst sınıf tanımlama
{
    protected String ad, soyad, mail, sifre, tcNo, gsmNo, cinsiyet, gorev;
    protected static String okul = "Istanbul Universitesi Cerrahpasa";

    public abstract boolean girisYap();

    public abstract void kayitOl();

    public abstract void bilgiGuncelle();

    public abstract void bilgiGoruntule();

    public void sifreDegistir()
    //sifre degistirme methodu tum alt sınıflar icin ortak oldugundan bu sınıf icinde implemente edildi
    {
        /* kullanici.txt den giris yap ile alınan bilgiler field da saklandi ve mevcut sifre bu sekilde bellege alindi kontrol yapildi
        ve sonrasinda yenisi istendi ve olusturulan temp dosyasına yeni haliyle yazildi ve rename yapıldı. */

        Scanner input = new Scanner(System.in);
        String mevcut, yeni;
        String yeniKayit, line, words[];

        try {
            File kullanici = new File("textFiles/kullanici.txt");
            File guncelKullanici = new File("textFiles/temp.txt");
            if (!kullanici.exists()) {
                System.out.print("Henuz kayit bulunmamaktadir. Lutfen once kisi kaydi yapin!\n");
                return;
            }
            if (!guncelKullanici.exists())
                guncelKullanici.createNewFile();

            boolean control = true;
            while (control) {
                System.out.print("Lutfen mevcut sifrenizi giriniz: ");
                mevcut = (input.next()).trim();
                if (this.sifre.equalsIgnoreCase(mevcut)) {
                    System.out.print("Lutfen yeni sifrenizi giriniz: ");
                    yeni = input.next();
                    this.sifre = yeni;
                    control = false;
                } else
                    System.out.print("Mevcut sifre girisi hatali, tekrar deneyin\n");
            }
            yeniKayit = tcNo + " " + sifre + " " + gorev + " " + ad + " " + soyad + " " + mail + " " + gsmNo + " " + cinsiyet;

            FileReader kullaniciOku = new FileReader(kullanici);
            BufferedReader kullaniciTampon = new BufferedReader(kullaniciOku);
            FileWriter fileWriter = new FileWriter(guncelKullanici, false);
            BufferedWriter tempYaz = new BufferedWriter(fileWriter);
            while ((line = kullaniciTampon.readLine()) != null) {
                words = line.split(" ");
                if (words[0].equals(tcNo))
                    tempYaz.write(yeniKayit + "\n");
                else
                    tempYaz.write(line + "\n");
            }
            kullaniciTampon.close();
            tempYaz.close();

            kullanici.delete();

            guncelKullanici.renameTo(kullanici);
        } catch (IOException e) {
            System.out.println("Hata!");
        }
    }

}
