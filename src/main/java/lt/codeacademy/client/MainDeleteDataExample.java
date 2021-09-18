package lt.codeacademy.client;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MainDeleteDataExample {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("testNyDb");
        MongoCollection<Document> collection = database.getCollection("MyCollectionWithParams");

        collection.deleteOne(new Document("_id", new ObjectId("613a3d1ddec7280a1b28e33b")));

        mongoClient.close();
    }
}
