import java.util.ArrayList;

public class Student {
    private int ogrenciNo; // Değişken tanımlamaları
    private String adSoyad;


    private ArrayList<String> iletisimNoArrayList = new ArrayList<>(); // Birden fazla iletişim numarasını tutmak için ArrayList oluşturuyoruz.

    public Student(){       // Parametresiz Constructor Metot
        ogrenciNo = 0;
        adSoyad = null;
        iletisimNoArrayList = null;
    }

    public Student(int ogrenciNo, String adSoyad, ArrayList iletisimNoArrayList){ // Parametreli Constructor metot

        this.ogrenciNo = ogrenciNo;
        this.adSoyad = adSoyad;
        this.iletisimNoArrayList  = iletisimNoArrayList;

    }
    public Student (Student s){  //Copy Constructor
        this.ogrenciNo = s.ogrenciNo;
        this.adSoyad = s.adSoyad;
        this.iletisimNoArrayList  = s.iletisimNoArrayList;

    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public ArrayList <String> getIletisimNoArrayList() {
        return iletisimNoArrayList;
    }

    public void setIletisimNoArrayList(String telno) {
        this.iletisimNoArrayList.add(telno);
    }

    @Override
    public String toString(){
        return "Öğrencinin adı soyadı:" + adSoyad + '\n' + "Öğrencinin öğrenci numarası: " + ogrenciNo + '\n'+"Öğrencinin iletişim bilgileri: " + iletisimNoArrayList + '\n';

    }

}
