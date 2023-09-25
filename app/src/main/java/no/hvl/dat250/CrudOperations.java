package no.hvl.dat250;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class CrudOperations {
    private final MongoClient mongoClient;

    public CrudOperations(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void runCrudOperations() {
        // Start with clean database
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("mycollection");

        collection.drop();  // Drop the collection if it exists

        // Create
        Document doc1 = new Document("name", "John").append("age", 20).append("occupation", "programmer");
        Document doc2 = new Document("name", "Jane").append("age", 40).append("occupation", "doctor");
        Document doc3 = new Document("name", "Emily").append("age", 30).append("occupation", "programmer");
        Document doc4 = new Document("name", "Kåre").append("age", 25).append("occupation", "programmer");

        collection.insertMany(Arrays.asList(doc1, doc2, doc3, doc4));

        // Read
        Document myDoc = collection.find().first();
        assert myDoc != null;

        // Update
        collection.updateOne(new Document("name", "John"), new Document("$set", new Document("age", 22)));

        // Delete
        collection.deleteOne(new Document("name", "John"));
    }
}
