package lt.codeacademy;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;
import org.bson.io.BsonOutput;

import java.util.Collection;
import java.util.Iterator;

public class MainCollectionDataExample {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("ExamDB");
        MongoCollection<Document> collection = database.getCollection("db.MyCollectionWithParams");

        FindIterable<Document> documents = collection.find();
        Iterator<Document> iterator = documents.iterator();
        Document document = iterator.next();
        System.out.println(document);
        System.out.println(document.get("vardas") + " " + " " + document.get("pavarde"));

        mongoClient.close();
    }
}
