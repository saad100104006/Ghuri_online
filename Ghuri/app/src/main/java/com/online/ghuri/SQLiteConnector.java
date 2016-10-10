/*
package com.online.ghuri;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class SQLiteConnector {

	private SQLiteDatabase database;
	private SQLiteHelper sqlHelper;
	private Cursor cursor;
	private static final String EVENT_TBL = "event_tbl";
	private static final String TABLE_CAT = "category_tbl";
	//private static final String FAV_TBL = "fav_tbl";

	public SQLiteConnector(Context context) {

		sqlHelper = new SQLiteHelper(context);
	}


	public List<room> GetAllEVENT() {
		List<room> myCategories = new ArrayList<room>();

		String query = "SELECT * FROM " + EVENT_TBL;

	//	String query = "SELECT * FROM " + TABLE_SMS + " WHERE category='" + category
	//			+ "'";
		database = sqlHelper.getReadableDatabase();
		cursor = database.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {

				int id=cursor.getInt(0);
				String image=cursor.getString(1);
				String datetime=cursor.getString(2);
				String title=cursor.getString(3);
				String location=cursor.getString(4);
				String description=cursor.getString(7);
				int similiar_id=cursor.getInt(6);
				int popular_id=cursor.getInt(5);


				room event=new room();

			    event.setId(id);
				event.setImage(image);
				event.setDateTime(datetime);
				event.setTitle(title);
				event.setLocation(location);
				event.setDescription(description);
				event.setSimiliar(similiar_id);
				event.setPopular(popular_id);

				myCategories.add(event);

			} while (cursor.moveToNext());
		}
		database.close();
		return myCategories;
	}


*/
/*	public void insertSms( String sms, String category, String image,int total_sms,
						  String like
	) {
		// for logging
		// Log.d("InsertDatabase", title);
		// 1. get reference to writable DB
		SQLiteDatabase db = sqlHelper.getWritableDatabase();
		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();

		values.put("sms", sms);
		values.put("category", category);
		values.put("image", image);
		values.put("total_sms", total_sms);
		values.put("like", like);

		// 3. insert
		db.insert(TABLE_SMS, null, values);
		// 4. close
		// db.close();
	}

	public int updateSms(String oldname, String sms, String category, String image,int id,int total_sms,
						  String like) {


		SQLiteDatabase db = sqlHelper.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("sms", sms);
		values.put("category", category);
		values.put("image", image);
		values.put("id", id);
		values.put("total_sms", total_sms);
		values.put("like", like);



		String[] where = { oldname };
		int count = db.update(TABLE_SMS, values, "like" + " =? ", where);
		System.out.println("count " + count);
		return count;
	}*//*





*/
/*
	public List<room> GetAllFavourite() {
		List<room> myCategories = new ArrayList<room>();

		String query = "SELECT * FROM " + FAV_TBL;
		database = sqlHelper.getReadableDatabase();
		cursor = database.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				String sMs=cursor.getString(0);
				String category1=cursor.getString(1);
				String image=cursor.getString(2);
				int id=cursor.getInt(3);
				int total_sms=cursor.getInt(4);

				room sms=new room();

				sms.setCategory(category1);
				sms.setSms(sMs);
				sms.setImage(image);
				sms.setTotal_sms(total_sms);
				sms.setId(id);

				myCategories.add(sms);

			} while (cursor.moveToNext());
		}
		database.close();
		return myCategories;
	}*//*


	public List<String> GetAllSmsImage() {
		List<String> myCategories = new ArrayList<String>();

		String query = "SELECT * FROM " + TABLE_CAT;
		database = sqlHelper.getReadableDatabase();
		cursor = database.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				//myCategories.add(cursor.getString(0));
				myCategories.add(cursor.getString(1));

			} while (cursor.moveToNext());
		}
		database.close();
		return myCategories;
	}



*/
/*	public void insertQuiz(String sms, String category, String image,
			int id,int  total_image) {
		// for logging
		// Log.d("InsertDatabase", title);
		// 1. get reference to writable DB
		database = sqlHelper.getWritableDatabase();
		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("sms", sms);
		values.put("category", category);
		values.put("image", image);
		values.put("id", id);
		values.put("total_image", total_image);


		// 3. insert
		database.insert(FAV_TBL, null, values);
		// 4. close
		database.close();
	}*//*





*/
/*	public void deleteUser(String sms) {
		database = sqlHelper.getWritableDatabase();
		try {
			database.delete(FAV_TBL, "sms = ?",
					new String[] { sms });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// database.close();
		}
	}*//*

	
	 */
/* public void delete(String id) {

	  database = sqlHelper.getWritableDatabase(); // db.delete("quiz_tbl",
	  "option1", new String[] {id}); int count = database.delete(TABLE_RECORD,
	  "field2" + "=" + id, null);


	  System.out.println("marr" + count);

	  }


	public List<String> getAllTheoryCategory() {
		List<String> studentList = new ArrayList<String>();
		String selectQuery = "SELECT  * FROM " + TABLE_MATH;

		database = sqlHelper.getReadableDatabase();
		cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				studentList.add(cursor.getString(0));

			} while (cursor.moveToNext());
		}
		database.close();
		return studentList;

	}

*//*


}
*/
