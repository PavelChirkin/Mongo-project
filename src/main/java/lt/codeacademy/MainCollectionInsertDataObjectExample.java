package lt.codeacademy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.User;

import java.util.List;

public class MainCollectionInsertDataObjectExample {
    public static void main(String[] args) {
        try(MongoClient client = MongoClientProvider.getClient()){
            MongoDatabase database = client.getDatabase("newDatabase");
            MongoCollection<User> collection = database.getCollection("users", User.class);

            //collection.insertOne(new User(null, "Andrius", "Baltrunas", 85000));
            collection.insertMany(List.of(new User(null, "Andrius", "Baltrunas", 85000),
                    new User(null, "Petras", "Petrulis", 92000),
                    new User(null, "Jonas", "Jonaitis", 49000),
                    new User(null, "Maryte", "Mazaityte", 58000)));
        }

    }
}
