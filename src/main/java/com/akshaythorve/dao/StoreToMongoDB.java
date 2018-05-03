package com.akshaythorve.dao;

import com.mongodb.*;
import com.mongodb.util.JSON;

/**
 * Java MongoDB : Convert JSON data to DBObject
 */

public class StoreToMongoDB {

    public static void main(String[] args) {

    }

    public String saveToMongoDB(String data, String collectionName, String userName, String iAm) {
        try {

            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("surveyDB");
            DBCollection collection = db.getCollection(collectionName);


            // convert JSON to DBObject directly
            DBObject dbObject = (DBObject) JSON.parse(data);
dbObject.put("_id",userName);
dbObject.put("iAm",iAm);
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

    public String getProfile(String userName,String collectionName) {
        try {

            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("surveyDB");
            DBCollection collection = db.getCollection(collectionName);



            DBObject userProfile=collection.findOne(userName);

            String behaviour= userProfile.get("iAm").toString();

            // DBCursor cursorDoc = collection.find();
            // while (cursorDoc.hasNext()) {
            // System.out.println(cursorDoc.next());
            // }

            System.out.println("Retrived behaviour as: "+behaviour);

            return behaviour;

        } catch (MongoException e) {
            e.printStackTrace();
            return "Issue saving to MongoDB";
        }

    }




}
