package lt.codeacademy;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;

public class MainCollectionUpdateExample {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("testNyDb");
        MongoCollection<Document> collection = database.getCollection("MyCollectionWithParams");

        collection.updateOne(Filters.eq("vardas", "Andrius"), Updates.set("pavarde", "Jonaitis"));

        mongoClient.close();
    }
}
