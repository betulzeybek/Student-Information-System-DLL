public class DoublyLinkedList {
    class Node { //Node adında bir innerclass oluşturuyoruz.
        private Student data;
        private Node previous;
        private Node next;

        public Node(Student data ){
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public Student getData() {
            this.data = new Student(data);
            return data;
        }

        public void setData(Student data) {
            this.data = data;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head,tail; //LinkedList için gerekli değişken tanımlamaları yapılıyor.

    public DoublyLinkedList(){ //Parametresiz constructor metot
        this.head = null;
        this.tail = null;
    }

    public void addAtHead(Student value){ // Listenin başına eleman ekleyen metot
        Node node = new Node(value);
        node.setNext(head);
        if (head != null){
            head.setPrevious(node);
        }
        head = node;
        if (tail == null){ // Boş liste olması durumun için yazılan koşul
            tail = node;
        }
    }

    public void addAtTail(Student value){  // Listenin sonuna eleman ekleyen metot
        Node node = new Node(value);

        if(tail == null){ // Bu kullanım head'in de null olduğunu gösteriyor.
            tail = node;
            head = node;
        }
        else{
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
    }

    public void sortedInsert(Student value){  // Öğrenci bilgilerini sıralı bir şekilde listeye ekleyen metot
        Node node = new Node(value);
        if (head == null){
            head = tail = node;

        }
        else{
            Node temp = new Node(value); // İşlem kolaylığı açısından değişken tanımlamaları
            Node current = head;

            while ((current != null) && current.data.getOgrenciNo() < value.getOgrenciNo()){ // Gerekli karşılaştırma işlemleri yapılıyor
                temp = current;
                current = current.getNext();
            }
            if(current == head){
                addAtHead(value);
                return;
            }
            if (current == null){ // current değeri null olduğunda değeri listenin sonuna eklememiz gerekir.
                addAtTail(value);
                return;
            }
            temp.setNext(node);
            node.setNext(current);
            current.setPrevious(node);
            node.setPrevious(temp);
        }
    }

    public void displayForward(){  // Artan öğrenci numarasına göre öğrenci Listesi
        if (this.head == null){
            System.out.println("Boş Öğrenci listesi!");
        }
        else{
            System.out.println("------Artan numara sıralı öğrenci listesi:------");
            Node temp = this.head;

            while (temp != null){
                System.out.println(" " + temp.getData());
                temp = temp.getNext();
            }
        }
    }

    public void displayBackward(){  // Azalan öğrenci numarasına göre öğrenci listesi
        if (this.head == null){
            System.out.println("Boş öğrenci Listesi!");
        }

        else{
            System.out.println("------Azalan numara sıralı öğrenci Listesi------");

            Node temp = this.tail;

            while (temp != null){
                System.out.println(" " + temp.getData());
                temp = temp.getPrevious();
            }
        }
    }

    public void deleteNode (int ogrenciNo){  // Girilen öğrenci numarasına göre listeden silinmesini sağlayan metot

        if(this.head == null){
            System.out.println("Boş Liste!!");
        }

        if(this.head.getData().getOgrenciNo() == ogrenciNo){ // Listedeki ilk değerle karlıaştırma yaparak kontrol ediyoruz

            this.head = this.head.getNext();
            if (this.head != null){
                this.head.setPrevious(null);  // null değerler göndererek listeden siliyoruz
            }
            else{
                this.tail = null;
            }
        }

        else if (this.tail.getData().getOgrenciNo() == ogrenciNo){ // Listedeki son değerle karşılaştırma yaparak kontrol ediyoruz
            this.tail = this.tail.getPrevious();
            if(this.tail != null){
                this.tail.setNext(null);
            }
            else{
                this.head = null;
            }
        }

        else{
            Node temp = this.head;
            while (temp != null && temp.getData().getOgrenciNo() != ogrenciNo){
                temp = temp.getNext();
            }

            if(temp == null){
                System.out.println("Silinmek istenen öğrenci numarası bulunamadı !!");
            }
            else{
                temp.previous.setNext(temp.getNext());
                if (temp.getNext() != null){
                    temp.next.setPrevious(temp.getPrevious());
                    System.out.println(ogrenciNo + " numaralı öğrenci başarıyla silinmiştir!");
                }
            }
        }
    }
    public void nodeSearch(String adSoyad){  // Adı Soyadı girilen öğrenciyi listede bulup bilgilerini yazdırmayı sağlayan metot
        if (this.head == null){
            System.out.println("Boş liste!!!");
        }
        else  if(this.head.getData().getAdSoyad().equals(adSoyad)){ // Girilen değerin listenin ilk elemanı olup olmadığını kontrol ediyoruz
            System.out.println("Öğrenci Bilgileri: " + '\n' + head.getData());
        }
        else  {
            Node searcher = this.head.getNext();
            int i = 0; // Öğrenci bulunamaması durumunu yazdırmak için sayaç oluşturuyoruz.

            while(searcher!= null) {

                if(searcher.getData().getAdSoyad().equals(adSoyad)){  // Aranan elemanı listenin ortalarında arayan koşul
                    System.out.println("öğrenci Bilgileri:" + '\n'+ searcher.getData());
                    i++;
                }
                searcher=searcher.getNext();

            }
            if (i == 0){ // Sayaç artmazsa öğrenci bulunamadı oluyor.
                System.out.println("Öğrenci bulunamadı!!");
            }
            }
    }
}
