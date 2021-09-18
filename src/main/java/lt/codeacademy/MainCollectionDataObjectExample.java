package lt.codeacademy;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Andrius Baltrunas
 */
/* public class MainCollectionDataObjectExample {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        MongoClient client = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("testNyDb");
        MongoCollection<Document> collection = database.getCollection("MyCollectinWithParams");
        Iterator<Document> iterator = collection.find().iterator();

        while(iterator.hasNext()){
            Document d = iterator.next();
            users.add(new User(d.getObjectId("_id").toString(), d.getString("vardas"), d.getString("pavarde"), d.getInteger("alga")));
        }
        client.close();

        users.forEach(System.out::println);
    }
}

 */
public class MainCollectionDataObjectExample {
    public static void main(String[] args) {


        MongoClient client = MongoClientProvider.getClient();
        MongoDatabase database = client.getDatabase("newDatabase");

        MongoCollection<User> collection = database.getCollection("users", User.class);

        Iterator<User> iterator = collection.find().iterator();

        while(iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }

        System.out.println("----------");
        // atspausdinti useri kurio alga 95000
        iterator = collection.find(Filters.eq("salary", 95000)).iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("----------");
        // atspausdinti useri kurio alga 95200
        iterator = collection.find().sort(new BasicDBObject("salary", 1)).iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------");
        iterator = collection.find().sort(new BasicDBObject("salary", 1)).iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------");
        //surasti Jonas Jonaitis
        //iterator = collection.find(Filters.and(new BasicDBObject("name", "Jonas"), new BasicDBObject("surname", "Jonaitis"))).iterator();
        iterator = collection.find(Filters.and(Filters.eq("name", "Jonas"), Filters.eq("surname", "Jonaitis"))).iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // surati visus kuriu alga > 50000
        iterator = collection.find(Filters.gt("salary", 50000)).iterator();
        // surasti visu usersiu kuriu alga yra nedidesne negu 80000
        iterator = collection.find(Filters.not(Filters.gt("salary", 80000))).iterator();
        client.close();

    }
}