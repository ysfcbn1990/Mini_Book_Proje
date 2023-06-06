package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService implements ProductService {

Scanner inp=new Scanner(System.in);
    List<Book> books=new ArrayList<>();
    public BookService(){
        Book book1=new Book("Fareler ve İnsanlar","120 Lira",15,"J.Steinbeck","Penguin","A111");
        Book book2=new Book("Sefiller","150 Lira",5,"V.Hugo","Penguin","A222");
        Book book3=new Book("Suç ve Ceza","120 Lira",15,"Dostoyevski","Dream","A333");
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);
    }

    @Override
    public void processMenu() {
        int choice;
        do{
            System.out.println("------------------------------");
            System.out.println("1-Kitapları Listele\n2-Kitap Ekle\n3-Kitap Sil\n4-Yayınevine göre filtrele\n0-Geri dön");
            System.out.println("Seçiminiz:");
            choice= inp.nextInt();
            inp.nextLine();
            switch (choice){
                case 1:listProduct();
                    break;
                case 2:addProduct();
                    break;
                case 3:deleteProduct();
                    break;
                case 4:
                    System.out.println("Yayınevini seçiniz:");
                    String filter=inp.nextLine();
                    filterProducts(filter);
                    break;
                case 0:
                    System.out.println("Ana Menüye yönlendiriliyorsunuz");
                    break;
                default:
                    System.out.println("Hatalı giriş!!");
                    break;

            }

        }while(choice!=0);




    }

    @Override
    public void listProduct() {
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                "ID","Kitap Adı","Yazar Adı","Yayınevi","ISBN","Birim Fiyat","Stok");
        System.out.println("-----------------------------------------------------------------");
        this.books.forEach(book-> System.out.printf("\"%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                book.getId(),book.getName(),book.getAuthorname(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }

    @Override
    public void addProduct() {
        System.out.println("ISBN:");
        String isbn = inp.nextLine();
        boolean isExist = false;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Bu kitap sistemde zaten kayıtlı,Lütfen ürün güncelleme yapınız");
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Kitap adı:");
            String name = inp.nextLine();
            System.out.println("Yazar adı: ");
            String author = inp.nextLine();
            System.out.println("Yayınevi: ");
            String publisher = inp.nextLine();
            System.out.println("Birim Fiyatı: ");
            String price = inp.nextLine();
            System.out.println("Stok: ");
            int stock = inp.nextInt();
            inp.nextLine();

            Book newbook = new Book(name, price, stock, author, publisher, isbn);
            this.books.add(newbook);
        }
        listProduct();
    }



    @Override
    public void deleteProduct() {
        boolean isExist=true;
        System.out.println("Lütfen silmek istediğiniz kitabın id numarasını giriniz");
        int idNo=inp.nextInt();

        for(Book book:this.books){
            if(book.getId()==idNo){
                isExist=true;
                this.books.remove(book);
                System.out.println("Ürün Silindi");
                break;
            }else{
               isExist=false;
            }
        }
        if(!isExist){
            System.out.println("Ürün bulunamadı");
        }

    }




    @Override
    public void filterProducts(String filter) {
  /*
this.books.stream().
        filter(book->book.getPublisher().equalsIgnoreCase(filter)).
     forEach(book-> System.out.printf("\"%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
             book.getId(),book.getName(),book.getAuthorname(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock()));
             */
        int counter=0;
       for(Book book:this.books){
           if(book.getPublisher().equalsIgnoreCase(filter)){
               System.out.printf("\"%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                       book.getId(),book.getName(),book.getAuthorname(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock());
             counter++;
           }
       }
        if(counter==0){
            System.out.println("Ürün bulunamadı.");
        }


    }
}
