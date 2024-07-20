package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.entity.Abas;

public class Main
{

  /** PDF Tablo değerlerini List olarak tutarak soruları cevapladım   **/
  /** Tablo Değerlerini Entity olarak DB'de de tutabilirdim fakat tek tablo için DB connection maliyetli olurdu **/


  public static void main(String[] args)
  {
    List<List<Abas>> tablo = new ArrayList<>();

    Abas siparis10 = new Abas(1000,2000,12,100.51);
    Abas siparis11 = new Abas(1000,2001,31,200.0);
    Abas siparis12 = new Abas(1000,2002,22,150.86);
    Abas siparis13 = new Abas(1000,2003,41,250.0);
    Abas siparis14 = new Abas(1000,2004,55,244.0);

    Abas siparis20 = new Abas(1001,2001,88,44.531);
    Abas siparis21 = new Abas(1001,2002,121,88.11);
    Abas siparis22 = new Abas(1001,2004,74,211.0);
    Abas siparis23 = new Abas(1001,2002,14,88.11);

    Abas siparis30 = new Abas(1002,2003,2,12.1);
    Abas siparis31 = new Abas(1002,2004,3,22.3);
    Abas siparis32 = new Abas(1002,2003,8,12.1);
    Abas siparis33 = new Abas(1002,2002,16,94.0);
    Abas siparis34 = new Abas(1002,2005,9,44.1);
    Abas siparis35 = new Abas(1002,2006,19,90.0);

    List<Abas> siparis1000 = new ArrayList<>();
    siparis1000.add(siparis10);
    siparis1000.add(siparis11);
    siparis1000.add(siparis12);
    siparis1000.add(siparis13);
    siparis1000.add(siparis14);

    List<Abas> siparis1001 = new ArrayList<>();
    siparis1001.add(siparis20);
    siparis1001.add(siparis21);
    siparis1001.add(siparis22);
    siparis1001.add(siparis23);

    List<Abas> siparis1002 = new ArrayList<>();
    siparis1002.add(siparis30);
    siparis1002.add(siparis31);
    siparis1002.add(siparis32);
    siparis1002.add(siparis33);
    siparis1002.add(siparis34);
    siparis1002.add(siparis35);

    tablo.add(siparis1000);
    tablo.add(siparis1001);
    tablo.add(siparis1002);

    showTablo(siparis1000,siparis1001,siparis1002);

    //TODO soru1a
    soru1a(tablo);
    //TODO soru1b
    soru1b(tablo);
    //TODO soru1c
    soru1c(tablo);
    //TODO soru1d
    soru1d(tablo);

  }

  public static void showTablo(List<Abas> list1,List<Abas> list2 , List<Abas> list3)
  {
    System.out.println("-----------------------------------------------------------------------");
    for (Abas abas : list1)
    {
      System.out.println( " ->  " + abas.getSiparis()  + "   |   " + abas.getMal_numarasi() + "   |   " + abas.getMiktar() + "   |   " + abas.getBirim_fiyat());
    }
    System.out.println("-----------------------------------------------------------------------");
    for (Abas abas : list2)
    {
      System.out.println( " ->  " + abas.getSiparis()  + "   |   " + abas.getMal_numarasi() + "   |   " + abas.getMiktar() + "   |   " + abas.getBirim_fiyat());
    }
    System.out.println("-----------------------------------------------------------------------");
    for (Abas abas : list3)
    {
      System.out.println( " ->  " + abas.getSiparis()  + "   |   " + abas.getMal_numarasi() + "   |   " + abas.getMiktar() + "   |   " + abas.getBirim_fiyat());
    }
    System.out.println("-----------------------------------------------------------------------");
  }
  public static double soru1a (List<List<Abas>> tablo)
  {
    double toplamTutar = 0.0;

    for (List<Abas> siparisler  : tablo)
    {
      for (Abas siparis : siparisler )
      {
        toplamTutar += (siparis.getBirim_fiyat() * siparis.getMiktar());
      }
    }

    return toplamTutar;
  }
  public static double soru1b(List<List<Abas>> tablo)
  {
    double ortalamaFiyat = 0.0;
    int tumSiparisSayisi = 0;
    int totalMiktar = 0;

    for (List<Abas> i :tablo)
    {
      for (Abas j : i)
      {
        totalMiktar += j.getMiktar();
        tumSiparisSayisi++;
      }
    }

    double tumMallarinToplamFiyati = soru1a(tablo);
    ortalamaFiyat = tumMallarinToplamFiyati / totalMiktar;

    return ortalamaFiyat;
  }
  public static Map<Integer,Double> soru1c(List<List<Abas>> tablo)
  {
    Map<Integer,Double> ortalamaMal = new HashMap<>();

    double mal2000Total = 0;
    double mal2000Miktar = 0 ;

    double mal2001Total = 0;
    double mal2001Miktar = 0 ;

    double mal2002Total = 0;
    double mal2002Miktar = 0 ;

    double mal2003Total = 0;
    double mal2003Miktar = 0 ;

    double mal2004Total = 0;
    double mal2004Miktar = 0 ;

    double mal2005Total = 0;
    double mal2005Miktar = 0 ;

    double mal2006Total = 0;
    double mal2006Miktar = 0 ;

    List<Abas> mal2000 = new ArrayList<>();
    List<Abas> mal2001 = new ArrayList<>();
    List<Abas> mal2002 = new ArrayList<>();
    List<Abas> mal2003 = new ArrayList<>();
    List<Abas> mal2004 = new ArrayList<>();
    List<Abas> mal2005 = new ArrayList<>();
    List<Abas> mal2006 = new ArrayList<>();

    for (List<Abas> siparisler : tablo)
    {
      for (Abas i : siparisler)
      {
        if (i.getMal_numarasi()==2000)
        {
          mal2000.add(i);
        }
        else if (i.getMal_numarasi()==2001)
        {
          mal2001.add(i);
        }
        else if (i.getMal_numarasi()==2002)
        {
          mal2002.add(i);
        }
        else if (i.getMal_numarasi()==2003)
        {
          mal2003.add(i);
        }
        else if (i.getMal_numarasi()==2004)
        {
          mal2004.add(i);
        }
        else if (i.getMal_numarasi()==2005)
        {
          mal2005.add(i);
        }
        else if (i.getMal_numarasi()==2006)
        {
          mal2006.add(i);
        }
        else
        {
          return  ortalamaMal;
        }
      }
    }

    for(Abas mal : mal2000 )
    {
      mal2000Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2000Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2000,(mal2000Total/mal2000Miktar));

    for(Abas mal : mal2001 )
    {
      mal2001Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2001Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2001,(mal2001Total/mal2001Miktar));

    for(Abas mal : mal2002 )
    {
      mal2002Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2002Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2002,(mal2002Total/mal2002Miktar));

    for(Abas mal : mal2003 )
    {
      mal2003Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2003Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2003,(mal2003Total/mal2003Miktar));

    for(Abas mal : mal2004 )
    {
      mal2004Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2004Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2004,(mal2004Total/mal2004Miktar));

    for(Abas mal : mal2005 )
    {
      mal2005Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2005Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2005,(mal2005Total/mal2005Miktar));

    for(Abas mal : mal2006 )
    {
      mal2006Total+= mal.getBirim_fiyat()*mal.getMiktar();
      mal2006Miktar+=mal.getMiktar();
    }
    ortalamaMal.put(2006,(mal2006Total/mal2006Miktar));

    return ortalamaMal;
  }
  public static Map<Integer, Map<Integer, Integer>> soru1d (List<List<Abas>> tablo)
  {
    Map<Integer, Map<Integer, Integer>> malBazliSiparisler = new HashMap<>();

    for (List<Abas> siparisListesi : tablo)
    {
      for (Abas siparis : siparisListesi)
      {
        int malNumarasi = siparis.getMal_numarasi();
        int siparisNumarasi = siparis.getSiparis();
        int miktar = siparis.getMiktar();

        malBazliSiparisler.putIfAbsent(malNumarasi, new HashMap<>());
        malBazliSiparisler.get(malNumarasi).putIfAbsent(siparisNumarasi, 0);

        int toplamMiktar = malBazliSiparisler.get(malNumarasi).get(siparisNumarasi) + miktar;
        malBazliSiparisler.get(malNumarasi).put(siparisNumarasi, toplamMiktar);
      }
    }

    return  malBazliSiparisler;
  }
}