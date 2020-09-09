package com.example.cps.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentDBHelper extends SQLiteOpenHelper {

    private static final String COLUMN_SUBJECTNAME = "subject";
    private static final String COLUMN_MARKS = "0";
    private static final String TABLE_NAME = "student_Table";

    public StudentDBHelper(Context context) {
        super(
                context,
                StudentContract.DB_NAME,
                null,
                StudentContract.VERSION
        );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_STUDENT_TABLE = "CREATE TABlE IF NOT EXISTS " +
                StudentContract.StudentEntry.TABLE_NAME +
                " (" +
                StudentContract.StudentEntry._ID +
                " PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                StudentContract.StudentEntry.COLUMN_SUBJECTNAME +
                " TEXT NOT NULL, " +
                StudentContract.StudentEntry.COLUMN_MARKS +
                " NUMBER DEFAULT NULL)";

        sqLiteDatabase.execSQL(SQL_CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String SQL_CREATE_STUDENT_TABLE = "DROP TABLE IF EXISTS " + StudentContract.StudentEntry.TABLE_NAME;

        sqLiteDatabase.execSQL(SQL_CREATE_STUDENT_TABLE);
        this.onCreate(sqLiteDatabase);
    }

    public boolean addData(String subject_name, String marks){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_SUBJECTNAME, subject_name);
        contentValues.put(COLUMN_MARKS, marks);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

//    public Cursor getAllFriends(SQLiteDatabase db) {
//        return db.query(
//                StudentContract.StudentEntry.TABLE_NAME,
//                null,
//                null,
//                null,
//                null,
//                null,
//                null
//        );
//    }
}
