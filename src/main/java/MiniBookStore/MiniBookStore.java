package MiniBookStore;

import java.util.Scanner;

public class MiniBookStore {
    public static void main(String[] args) {

        enter();

    }
    public static void enter(){
        Scanner inp=new Scanner(System.in);
        int select;
        System.out.println("------Mini Book Store------");
do{
    System.out.println("Ürün Yönetim Paneli");
    System.out.println("1-Kitaplar");
    System.out.println("2-Defterler");
    System.out.println("0-Çıkış");
    System.out.println("Seçiminiz");
    select=inp.nextInt();
    inp.nextLine();
    ProductService service;
    switch (select){
        case 1:
            service=new BookService();
            service.processMenu();
            break;
        case 2:
            service=new NotebookService();
            service.processMenu();
            break;
        case 0:
            System.out.println("İyi günler");
            break;
        default:
            System.out.println("Hatalı giriş");
            break;
    }





}while(select!=0);

    }

}
