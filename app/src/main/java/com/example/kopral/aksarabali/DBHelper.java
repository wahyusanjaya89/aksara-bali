package com.example.kopral.aksarabali;

/**
 * Created by kopral on 4/19/17.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_aksarabali.sqlite";
    private static String DB_PATH = null;
    public static final String DB_TABLE = "tblPengenalan";
    public static final int SCHEMA_VERSION = 1;
    private final Context myContext;
    private SQLiteDatabase myDataBase;

    static {
        DB_PATH = "/data/data/com.example.kopral.aksarabali/databases/";
    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA_VERSION);
        this.myContext = context;
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createDataBase() throws IOException {
        if (!checkDataBase()) {
            getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SCHEMA_VERSION);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        if (checkDB != null) {
            return true;
        }
        return false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = this.myContext.getAssets().open(DB_NAME);
        OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] buffer = new byte[1024];
        while (true) {
            int length = myInput.read(buffer);
            if (length <= 0) {
                myOutput.flush();
                myOutput.close();
                myInput.close();
                return;
            }
            myOutput.write(buffer, 0, length);
        }
    }

    public void openDataBase() throws SQLException {
        this.myDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SCHEMA_VERSION);
    }

    public Cursor getAll(String xkey) {
        return getReadableDatabase().rawQuery("SELECT bali, latin, info, warga FROM tblPengenalan WHERE aks_bali ='" + xkey + "'", null);
    }

    public Cursor getAllAksara(String xkey) {
        return getReadableDatabase().rawQuery("SELECT aks_bali, aks_gntng FROM tblKruna WHERE latin = '" + xkey + "'", null);
    }

    public Cursor getAdaAksara(String xkey) {
        return getReadableDatabase().rawQuery("SELECT aks_bali FROM tblKruna WHERE latin = '" + xkey + "'", null);
    }

    public synchronized void close() {
        if (this.myDataBase != null) {
            this.myDataBase.close();
        }
        super.close();
    }
}
