package com.akshaythorve.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

/**
 * Java MongoDB : Convert JSON data to DBObject
 *
 */

public class StoreToMongoDB {

	public String saveToMongoDB(String data, String collectionName) {
		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("surveyDB");
			DBCollection collection = db.getCollection(collectionName);

			// convert JSON to DBObject directly
			DBObject dbObject = (DBObject) JSON.parse(data);

			collection.insert(dbObject);

			// DBCursor cursorDoc = collection.find();
			// while (cursorDoc.hasNext()) {
			// System.out.println(cursorDoc.next());
			// }

			System.out.println("Saved to MongoDB");
			return "Saved to MongoDB";

		} catch (MongoException e) {
			e.printStackTrace();
			return "Issue saving to MongoDB";
		}

	}

	public static void main(String[] args) {

	}

}
