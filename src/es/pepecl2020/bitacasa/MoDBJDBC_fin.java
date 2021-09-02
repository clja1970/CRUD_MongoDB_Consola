package es.pepecl2020.bitacasa;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MoDBJDBC_fin{
	public static void main( String args[] )
	{
		try
		{   
			// mongodb , aquí se va a hacer la conexión a la BBDD
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

			MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
			System.out.println("Connect to database successfully");

			MongoCollection<Document> collection = mongoDatabase.getCollection("test");
			System.out.println("Prueba Conexión");
		}catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		//Insertar documentos en MongoDB

		try{   
			// mongodb 
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

			
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
			//System.out.println("Connect to database successfully");

			MongoCollection<Document> collection = mongoDatabase.getCollection("test");
			System.out.println("Prueba 3");
			

			Document document = new Document("title", "MongoDB").  
					append("description", "database").  
					append("likes", 100).  
					append("by", "Fly");  
			List<Document> documents = new ArrayList<Document>();  
			documents.add(document);  
			collection.insertMany(documents);  
			System.out.println("Prueba Insert");  
		}catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		//Obtención de documentos
		try{   

			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


			MongoDatabase mongoDatabase = mongoClient.getDatabase("BitacoraCasa");  
			System.out.println("Connect to database successfully");

			MongoCollection<Document> collection = mongoDatabase.getCollection("BitacoraCasa");
			System.out.println("Prueba Consulta"); 

			FindIterable<Document> findIterable = collection.find();  
			MongoCursor<Document> mongoCursor = findIterable.iterator();  
			while(mongoCursor.hasNext()){  
				System.out.println(mongoCursor.next());  
			}  

		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		//Modificación de documentos
		try{   
	         
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         
	         
	         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
	         System.out.println("Connect to database successfully");
	         
	         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
	         System.out.println("Prueba de modificación");
	         
	           
	         collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));  
	           
	         FindIterable<Document> findIterable = collection.find();  
	         MongoCursor<Document> mongoCursor = findIterable.iterator();  
	         while(mongoCursor.hasNext()){  
	            System.out.println(mongoCursor.next());  
	         }  
	      
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	}

}