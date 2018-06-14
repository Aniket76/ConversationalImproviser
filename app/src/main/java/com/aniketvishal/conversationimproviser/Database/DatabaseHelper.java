package com.aniketvishal.conversationimproviser.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import com.aniketvishal.commonindianwords.Models.WordListModel;

import com.aniketvishal.conversationimproviser.Models.MainCategoryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aniketvishal on 30/11/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "patternsdb.db";
    public static String DBLOCATION = null;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context, DBNAME, null,1);
        this.mContext = context;
        DBLOCATION = "/data/data/" + context.getPackageName() + "/databases/";
    }

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()){
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null,SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase(){
        if (mDatabase!=null){
            mDatabase.close();
        }
    }

    public String getpatterns(String table, String category,int i){
        MainCategoryModel wordListModel = null;
        List<MainCategoryModel> wordList = new ArrayList<>();
        openDatabase();

        String patternsExp = new String();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+table+" WHERE pattern = '"+category+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            patternsExp = cursor.getString(i);
//            wordListModel = new MainCategoryModel(cursor.getString(1));
//            wordList.add(wordListModel);
            cursor.moveToNext();
            i++;
        }
        cursor.close();

        closeDatabase();
        return patternsExp;
    }

    public String getconversations(String table, String category,int i){
        MainCategoryModel wordListModel = null;
        List<MainCategoryModel> wordList = new ArrayList<>();
        openDatabase();

        String patternsExp = new String();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+table+" WHERE category = '"+category+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            patternsExp = cursor.getString(i);
//            wordListModel = new MainCategoryModel(cursor.getString(1));
//            wordList.add(wordListModel);
            cursor.moveToNext();
            i++;
        }
        cursor.close();

        closeDatabase();
        return patternsExp;
    }


    public  List<MainCategoryModel> getCategorieList(String table){
        MainCategoryModel wordListModel = null;
        List<MainCategoryModel> wordList = new ArrayList<>();
        openDatabase();

            Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+table, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                wordListModel = new MainCategoryModel(cursor.getString(1));
                wordList.add(wordListModel);
                cursor.moveToNext();
            }
            cursor.close();

        closeDatabase();
        return wordList;
    }

    public boolean updateData(String is_fav,String word, String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_fav",is_fav);
        db.update(table, contentValues, "word = ?",new String[] { word });
        return true;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
