package universiteotomasyonu;
import universiteotomasyonu.kullanici.akademisyen.OgrUyesi;
import universiteotomasyonu.kullanici.idareci.Idare;
import universiteotomasyonu.kullanici.ogrenci.Ogrenci;

import java.util.Scanner;


public class UniversityDesktopApplication {
    public static void main(String[] args) {
        int ctrl = 0;
        boolean button = true, dec = false;
        while(button){
            ctrl = ilkSayfa(ctrl);
            switch(ctrl){
                case 1 :
                    ctrl = girisYapSayfa(ctrl);
                    switch(ctrl){ // Ogrenci girisi basarili olursa ogrenci islem sayfasi, olmazsa ana sayfaya yönlendirme
                        case 1 :
                            Ogrenci ogrenci = new Ogrenci();
                            dec = ogrenci.girisYap();
                            if(dec){
                                while(ctrl != 0){
                                    ctrl = ogrenciSayfa(ctrl);
                                    switch(ctrl){
                                        case 1 :
                                            ogrenci.bilgiGoruntule();
                                            break;
                                        case 2 :
                                            ogrenci.bilgiGuncelle();
                                            break;
                                        case 3 :
                                            ogrenci.dersSec();
                                            break;
                                        case 4 :
                                            ogrenci.notListele();
                                            break;
                                        case 5 :
                                            ogrenci.programGoruntule();
                                            break;
                                        case 6 :
                                            ogrenci.sifreDegistir();
                                            break;
                                        case 0 :
                                            //ogrenci = null;
                                            ctrl = 0;
                                            break;
                                        default :
                                            ctrl = ogrenciSayfa(ctrl);
                                    }
                                }
                            }else{
                                ctrl = ilkSayfa(ctrl);
                            }
                            break;
                        case 2 :
                            OgrUyesi akademisyen = new OgrUyesi();
                            dec = akademisyen.girisYap();
                            if(dec){
                                while(ctrl != 0){
                                    ctrl = akademisyenSayfa(ctrl);
                                    switch(ctrl){  // Akademisyen girisi basarili olursa ogrenci islem sayfasi, olmazsa ana sayfaya yönlendirme
                                        case 1 :
                                            akademisyen.bilgiGoruntule();
                                            break;
                                        case 2 :
                                            akademisyen.bilgiGuncelle();
                                            break;
                                        case 3 :
                                            akademisyen.notGiris();
                                            break;
                                        case 4 :
                                            akademisyen.yoklamaGir();
                                            break;
                                        case 5 :
                                            akademisyen.yoklamaGoruntule();
                                            break;
                                        case 6 :
                                            akademisyen.HarfNotuOlustur();
                                            break;
                                        case 7 :
                                            akademisyen.unvanDegistir();
                                            break;
                                        case 8 :
                                            akademisyen.sifreDegistir();
                                            break;
                                        case 0 :
                                            ctrl = 0;
                                            break;
                                        default :
                                            ctrl = akademisyenSayfa(ctrl);
                                    }
                                }
                            }else{
                                ctrl = ilkSayfa(ctrl);
                            }
                            break;
                        case 3 :
                            Idare idariMemur = new Idare();
                            dec = idariMemur.girisYap();
                            if(dec){
                                while(ctrl != 0){
                                    ctrl = idareSayfa(ctrl);
                                    switch(ctrl){ // İdari memur girisi basarili olursa ogrenci islem sayfasi, olmazsa ana sayfaya yönlendirme
                                        case 1 :
                                            idariMemur.bilgiGoruntule();
                                            break;
                                        case 2 :
                                            idariMemur.bilgiGuncelle();
                                            break;
                                        case 3 :
                                            idariMemur.dersOlustur();
                                            break;
                                        case 4 :
                                            idariMemur.programHazirla();
                                            break;
                                        case 5 :
                                            idariMemur.unvanDegistir();
                                            break;
                                        case 6 :
                                            idariMemur.sifreDegistir();
                                            break;
                                        case 0 :
                                            ctrl = 0;
                                            break;
                                        default :
                                            ctrl = idareSayfa(ctrl);
                                    }
                                }
                            }else{
                                ctrl = ilkSayfa(ctrl);
                            }
                            break;
                        case 9 :
                            ctrl = ilkSayfa(ctrl);
                            break;
                        case 0 :
                            button = false;
                            break;
                        default :
                            ctrl = ilkSayfa(ctrl);
                    }
                    break;
                case 2 :
                    ctrl = kayitOlSayfa(ctrl);
                    switch(ctrl){
                        case 1 :
                            Ogrenci ogrenci = new Ogrenci();
                            ogrenci.kayitOl();
                            System.out.println("Kayit basariyla olusturuldu!");
                            break;
                        case 2 :
                            OgrUyesi akademisyen = new OgrUyesi();
                            akademisyen.kayitOl();
                            System.out.println("Kayit basariyla olusturuldu!");
                            break;
                        case 3 :
                            Idare idariMemur = new Idare();
                            idariMemur.kayitOl();
                            System.out.println("Kayit basariyla olusturuldu!");
                            break;
                        case 9 :
                            ctrl = ilkSayfa(ctrl);
                            break;
                        case 0 :
                            button = false;
                            break;
                        default :
                            ctrl = kayitOlSayfa(ctrl);
                    }
                    ctrl = 5;
                    break;
                case 0 :
                    button = false;
                    break;
                default :
                    ctrl = ilkSayfa(ctrl);
            }
        }
    }

    static int ilkSayfa(int sayi) // Ana sayfa methodu implementi
    {
	    Scanner input = new Scanner(System.in);
        System.out.println( "IUC otomasyon sistemine hosgeldiniz..");
        System.out.println( "1 - Giris Yap \n2 - Kayıt Ol \n0 - Kapat");
	    System.out.print( "Yapmak istediginiz islemi secin: ");
        sayi = input.nextInt();
        return sayi;
    }
    static int girisYapSayfa(int sayi) // Giris sayfa methodu implementi
    {
        Scanner input = new Scanner(System.in);
	    System.out.println("1 - Ogrenci Girisi \n2 - Akademisyen Girisi \n3 - Idari Memur Girisi \n9 - Ana Sayfa \n0 - Kapat");
	    System.out.print( "Yapmak istediginiz islemi secin: ");
	    sayi = input.nextInt();
        return sayi;
    }
    static int kayitOlSayfa(int sayi) // Kayit sayfa methodu implementi
    {
        Scanner input = new Scanner(System.in);
	    System.out.println("1 - Ogrenci Kaydi \n2 - Akademisyen Kaydi \n3 - İdari Memur Kaydi \n9 - Ana Sayfa \n0 - Kapat");
	    System.out.print( "Yapmak istediginiz islemi secin: ");
	    sayi = input.nextInt();
        return sayi;

    }
    static int ogrenciSayfa(int sayi) // Ogrenci sayfa methodu implementi
    {
        Scanner input = new Scanner(System.in);
        System.out.println(
		"1 - Bilgi Goruntuleme \n2 - Bilgi Guncelleme \n3 - Ders Secimi \n" +
		"4 - Not Goruntuleme \n5 - Ders Programı Goruntuleme\n6 - Sifre Degistirme \n0 - Cikis Yap ");
	    System.out.print( "Yapmak istediginiz islemi secin: ");
	    sayi = input.nextInt();
        return sayi;
    }
    static int akademisyenSayfa(int sayi) // Akademisyen sayfa methodu implementi
    {
        Scanner input = new Scanner(System.in);
	System.out.println(
                "1 - Bilgi Goruntuleme \n2 - Bilgi Guncelleme \n3 - Not Girisi \n4 - Yoklama Gir \n" +
		"5 - Yoklama Goruntule \n6 - Harf Notu Olustur \n7 - Unvan Guncelleme \n8 - Sifre Degistirme\n" +
                "0 - Cikis Yap ");
	System.out.print( "Yapmak istediginiz islemi secin: ");
	sayi = input.nextInt();
        return sayi;
    }
    static int idareSayfa(int sayi) // İdare sayfa methodu implementi
    {
        Scanner input = new Scanner(System.in);
	System.out.println(
		"1 - Bilgi Goruntuleme \n2 - Bilgi Guncelleme \n3 - Ders Olustur \n4 - Ders Programi Hazirla \n" +
                "5 - Unvan Guncelleme \n8 - Sifre Degistirme\n0 - Cikis Yap ");
	System.out.print( "Yapmak istediginiz islemi secin: ");
	sayi = input.nextInt();
        return sayi;
    }
}

/*
KAYNAK DOSYA DUZENLERİ!!

kullanici.txt

TC Sifre ogrenci/akademisyen/idare ad soyad mail gsmNo cinsiyet

ogrenci.txt

TC okulNo bolum ders_sayisi ders1 ders2 ... vize1 vize2 ... final1 final2 ... but1 but2 ...harf1 harf2 ...

akademisyen.txt

TC unvan ders_sayisi ders1 ders2 ...

idare.txt

TC personelNo unvan

dersler.txt

ders1 kredi1
ders2 kredi2
...

program.txt

ders1 gün saat
ders2 gün saat
...

not.txt
tc vize1 final1 harf1 but1 vize2 final2 harf2 but2 ...
...

yoklama.txt

tc1
ders1 ...
ders2 ...
...
tc2
ders1 ...
ders2 ...
...

*/
