package lt.codeacademy;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;

public class MainCollectionInsertDataExample {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("testNyDb");
        MongoCollection<Document> collection = database.getCollection("db.MyCollectionWithParams");

        Document document = new Document("vardas", "Petras");
        document.append("pavarde", "Petraitis")
                .append("alga", 45000);

        collection.insertOne(document);

        mongoClient.close();

        mongoClient.close();
    }
}
