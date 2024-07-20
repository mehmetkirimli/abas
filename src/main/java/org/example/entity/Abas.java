package org.example.entity;

public class Abas
{
  Integer siparis;
  Integer mal_numarasi;
  Integer miktar;
  Double birim_fiyat;

  public Abas(Integer siparis, Integer mal_numarasi, Integer miktar, Double birim_fiyat)
  {
    this.siparis = siparis;
    this.mal_numarasi = mal_numarasi;
    this.miktar = miktar;
    this.birim_fiyat = birim_fiyat;
  }

  public Integer getSiparis() {
    return siparis;
  }

  public void setSiparis(Integer siparis) {
    this.siparis = siparis;
  }

  public Integer getMal_numarasi() {
    return mal_numarasi;
  }

  public void setMal_numarasi(Integer mal_numarasi) {
    this.mal_numarasi = mal_numarasi;
  }

  public Integer getMiktar() {
    return miktar;
  }

  public void setMiktar(Integer miktar) {
    this.miktar = miktar;
  }

  public Double getBirim_fiyat() {
    return birim_fiyat;
  }

  public void setBirim_fiyat(Double birim_fiyat) {
    this.birim_fiyat = birim_fiyat;
  }

  public Double fiyat_hesapla(Double birimFiyat,Integer miktar)
  {
    Double total= 0.0;
    total = birimFiyat*miktar;
    return total;
  }

}
