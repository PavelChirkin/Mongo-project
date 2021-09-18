package lt.codeacademy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.Books;
import lt.codeacademy.data.User;

import java.util.Iterator;
import java.util.Scanner;

public class MainVartotojoMeniu {
    public static void main(String[] args) {
        MongoClient client = MongoClientProvider.getClient();
        MongoDatabase database = client.getDatabase("booksDatabase");
        MongoCollection<Books> collection = database.getCollection("library", Books.class);

        Iterator<Books> iterator = collection.find().iterator();
        Scanner sc = new Scanner(System.in);

        //Laisvos knygos
        System.out.println("==== Siuo metu prieinamos knygos ====");
        iterator = collection.find(Filters.eq("userName", null)).iterator();
        while(iterator.hasNext()){
            Books book = iterator.next();
            System.out.println(book.getBookName() + "  Autorius: " + book.getAuthorName());
        }
        System.out.println("===Iveskyte skaitytojo varda===");
        String readerName = sc.nextLine();
        iterator = collection.find(Filters.eq("userName", readerName)).iterator();
        while(iterator.hasNext()){
            Books book = iterator.next();
            System.out.println("Jus negrazinote knyga: " + book.getBookName() + "  Autorius: " + book.getAuthorName());
            System.exit(0);
        }

        System.out.println("===Iveskyte knygos pavadinyma, kuri norite pasiimti===");
        String knyga = sc.nextLine();
        iterator = collection.find(Filters.eq("bookName", knyga)).iterator();
        while(iterator.hasNext()){
            Books book = iterator.next();
            System.out.println("Jus pasirinkote knyga: " + book.getBookName() + "  Autorius: " + book.getAuthorName());
        }
    }
}
