package com.google.mentalhealthchec_in;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    Context context;
    private static String DATABASE_NAME = "mydb.db";
    private static int DATABASE_VERSION = 1;
    private static String createTableQuery = "create table imageInfo (id INTEGER PRIMARY KEY NOT NULL,imageName TEXT " + ", image BLOB)";
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInBytes;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(createTableQuery);
            Toast.makeText(context, "Table Created Successfully!", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "onCreate: Table Created");
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storeImage(ModelClass objectModelClass) {
        try {
            SQLiteDatabase objectSqLiteDatabase = this.getWritableDatabase();
            Bitmap imageToStoreBitmap = objectModelClass.getImage();
            objectByteArrayOutputStream = new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100, objectByteArrayOutputStream);

            imageInBytes = objectByteArrayOutputStream.toByteArray();
            ContentValues objectContentValues = new ContentValues();

            objectContentValues.put("imageName", objectModelClass.getImageName());
            objectContentValues.put("image", imageInBytes);

            long checkIfQueryRuns = objectSqLiteDatabase.insert("imageInfo", null, objectContentValues);
            if (checkIfQueryRuns != 0) {

                Toast.makeText(context, "" + checkIfQueryRuns, Toast.LENGTH_SHORT).show();

                Toast.makeText(context, "Data Added Into Table", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onCreate: Data Added");
                objectSqLiteDatabase.close();
            } else {
                Toast.makeText(context, "Failed To Add", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onCreate: Failed To Add Data");
            }

        } catch (Exception ex) {
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<ModelClass> getAllImagesData() {

        try {
            ArrayList<ModelClass> objectModelClassList = new ArrayList<>();

            SQLiteDatabase objectSqLiteDatabase = this.getReadableDatabase();

            Cursor objectCursor = objectSqLiteDatabase.rawQuery("select * from imageInfo", null);

            if (objectCursor.getCount() != 0) {
                while (objectCursor.moveToNext()) {
                    String nameOfImage = objectCursor.getString(1);
                    byte[] imageBytes = objectCursor.getBlob(2);

                    Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                    objectModelClassList.add(new ModelClass(nameOfImage, objectBitmap));
                }
                return objectModelClassList;
            } else {
                Toast.makeText(context, "No Data Exist In Database", Toast.LENGTH_SHORT).show();
                return objectModelClassList;
            }
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}