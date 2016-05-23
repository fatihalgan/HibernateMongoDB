package hello.world.mongodb.helloworld;

import java.net.UnknownHostException;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class App {

	public static void main(String[] args) {
		try {
			// connect to the MongoDB store
			Mongo mongo = new Mongo("127.0.0.1", 27017);
			// get the MongoDB database, helloworld_db
			DB db = mongo.getDB("helloworld_db");
			//get the MongoDB collection named helloworld
			DBCollection dbCollection = db.getCollection("helloworld");
			// create a document for storing a key/value pair
			BasicDBObject basicDBObject = new BasicDBObject();
			basicDBObject.put("Lucky number", new Random().nextInt(1000));
			// save the pair into helloworld collection
			dbCollection.insert(basicDBObject);
			System.out.println("MongoDB has stored the lucky number!");
		} catch(UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch(MongoException e) {
			System.out.println(e.getMessage());
		}
	}

}
