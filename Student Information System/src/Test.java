import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {

        DoublyLinkedList liste = new DoublyLinkedList(); // Boş liste oluşturuyoruz

        Scanner input = new Scanner(new FileInputStream("ogrenciler.txt")); // Dosya okuma için Scanner sınıfını aktif ediyoruz.

        while (input.hasNextLine()){
            String satir = input.nextLine();

            int ogrenciNo = Integer.parseInt(satir.split(",")[0]); // Virgüllerden ayırma işlemi yapıyoruz
            String adSoyad = satir.split(",")[1];

            ArrayList<String> telNo = new ArrayList<>(); // Numaraları tutması için boş bir arraylist oluşturuyoruz

            for (int i = 2; i<(satir.split(",")).length; i++){   // Döngüyle dönerek tek tek listeye ekliyor
                telNo.add(satir.split(",")[i]);
            }

            Student student = new Student(ogrenciNo, adSoyad, telNo );
            liste.sortedInsert(student); // Öğrencileri sıralı bir şekilde listeye ekliyoruz
        }

        System.out.println("------Öğrenci Rehber Uygulaması------" + '\n'); // Kullanıcı menüsü
        System.out.println("1-) Öğrenci kaydetme seçeneği");
        System.out.println("2-) Öğrenci bilgi yazdırma seçeneği");
        System.out.println("3-) öğrenci bilgisi silme seçeneği");
        System.out.println("4-) Öğrencileri numaraları artan sıradan olacak şekilde yazdırma seçeneği");
        System.out.println("5-) Öğrencileri numaraları azalan sıradan olacak şekilde yazdırma seçeneği");
        System.out.println("6-) Programdan çıkış seçeneği");

        Scanner input1 = new Scanner(System.in); // Case'lere ulaşmak için seçim yaptırıyoruz
        System.out.print('\n' + "Seçeneğe ulaşmak için seçiminizi yapınız:");
        int secim;
        secim = input1.nextInt();

        while (secim !=6 ){  // Caseleri dolaşmak için while döngüsüne alıyoruz.

            switch (secim) {
                case 1:
                    ArrayList<String> telNo = new ArrayList<>();

                    System.out.print("Öğrenci no giriniz: ");
                    int ogrenciNo = input1.nextInt();

                    System.out.print("Öğrenci adı soyadı giriniz: " );

                    input1.nextLine();
                    String adSoyad = input1.nextLine();

                    System.out.print("Öğrenci iletişim numarası giriniz: ");
                    String tel = input1.nextLine();
                    telNo.add(tel);

                    while (true) { // Birden fazla telefon numarası olması durumu için döngüye alıyoruz.
                        System.out.print("Varsa diğer iletişim numarasını giriniz." + "Yoksa bu seçenekten çıkmak için 0'a basınız.");
                        tel = input1.nextLine();

                        if("0".equals(tel)){ // 0 seçilirse başka telefon numarası sorulmuyor.
                            break;
                        }
                        telNo.add(tel);
                    }

                    Student student = new Student(ogrenciNo, adSoyad, telNo );
                    liste.sortedInsert(student);

                    System.out.print('\n' + "Başka bir seçeneğe ulaşmak için seçiminizi yapınız:");
                    secim = input1.nextInt();

                    break;

                case 2:
                    System.out.print("Bilgilerini yazdırmak istediğiniz öğrencinin ismini ve soyismini yazınız:");

                    input1.nextLine();
                    adSoyad = input1.nextLine();

                    liste.nodeSearch(adSoyad);

                    System.out.print('\n' + "Başka bir seçeneğe ulaşmak için seçiminizi yapınız:");
                    secim = input1.nextInt();
                    break;

                case 3:
                    System.out.print("Silinmesini istediğiniz öğrencinin numarasını giriniz: ");
                    ogrenciNo = input1.nextInt();
                    liste.deleteNode(ogrenciNo);


                    System.out.print('\n' + "Başka bir seçeneğe ulaşmak için seçiminizi yapınız:");
                    secim = input1.nextInt();

                    break;

                case 4:
                    liste.displayForward();

                    System.out.print('\n' + "Başka bir seçeneğe ulaşmak için seçiminizi yapınız:");
                    secim = input1.nextInt();

                    break;
                case 5:
                    liste.displayBackward();

                    System.out.print('\n' + "Başka bir seçeneğe ulaşmak için seçiminizi yapınız:");
                    secim = input1.nextInt();

                    break;
            }
        }
        if (secim == 6){
            System.out.println("Programdan çıkılıyor...");
        }
    }
}
