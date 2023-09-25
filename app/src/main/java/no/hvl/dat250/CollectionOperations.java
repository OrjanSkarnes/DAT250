package no.hvl.dat250;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class CollectionOperations {
    private final MongoClient mongoClient;

    public CollectionOperations(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void runAggregation() {
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("mycollection");

        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }

        // Define the aggregation stages
        Document groupFields = new Document("_id", "$occupation");
        groupFields.put("averageAge", new Document("$avg", "$age"));
        Document group = new Document("$group", groupFields);


        // Run aggregation
        AggregateIterable<Document> result = collection.aggregate(List.of(group));


        // Create a new collection for the results
        MongoCollection<Document> outputCollection = database.getCollection("average_age_by_occupation");
        outputCollection.drop();  // Drop the collection if it exists
        for (Document doc : result) {
            outputCollection.insertOne(doc);
        }

        System.out.println("Average age by occupation:");
        for (Document doc : outputCollection.find()) {
            System.out.println(doc.toJson());
        }
    }
}
