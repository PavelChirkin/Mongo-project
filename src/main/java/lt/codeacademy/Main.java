package lt.codeacademy;

import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;



public class Main {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        //MongoClient client = new MongoClient(new MongoClientURI("mongoDB://localhost:27017"));

        MongoDatabase database = client.getDatabase("testNyDb");

        MongoIterable<String> names = database.listCollectionNames();
        for(String name : names){
            System.out.println(name);
        }

        ListCollectionsIterable<Document> documents = database.listCollections();
        for(Document d: documents) {
            System.out.println(d);
            System.out.println(d.get("name"));
        }

        client.close();
    }
}
