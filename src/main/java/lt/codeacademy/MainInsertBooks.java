package lt.codeacademy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.Books;


import java.util.List;

public class MainInsertBooks {
    public static void main(String[] args) {
        try(MongoClient client = MongoClientProvider.getClient()){
            MongoDatabase database = client.getDatabase("booksDatabase");
            MongoCollection<Books> collection = database.getCollection("library", Books.class);

            collection.insertMany(List.of(new Books(null, "Testamentas", "Apastolai", null),
                    new Books(null, "Java Philosofy", "Bruce Eckel", "Andrius"),
                    new Books(null, "Karas ir Taika", "Tolstojus", null),
                    new Books(null, "Faust", "Goethe", null)));
        }

    }
}
