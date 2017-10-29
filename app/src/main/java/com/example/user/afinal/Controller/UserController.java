package com.example.user.afinal.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.afinal.Domain.User;
import com.example.user.afinal.Repository.DBContract;
import com.example.user.afinal.Repository.DBHelper;


public class UserController extends DBHelper {

    public UserController(Context context) {
        super(context);
    }

    public boolean create(User user){
        System.out.println("user: " + user.toContentValues());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean isCreate = db.insert(DBContract.UserEntry.TABLE_NAME, null, user.toContentValues()) > 0;

        db.close();
        return isCreate;
    }

    public Cursor getAllUsers() {
        return getReadableDatabase()
                .query(
                        DBContract.UserEntry.TABLE_NAME, null, null, null, null, null, null);
    }


    public boolean dropTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,2);
        return true;
    }


    public boolean update(User user){

        ContentValues values = new ContentValues();


        String where = "username = ?";

        String[] whereArgs = {user.getUserName()};

        SQLiteDatabase db = this.getWritableDatabase();

        boolean isUpdate = db.update(DBContract.UserEntry.TABLE_NAME, values,
                where, whereArgs) > 0;

        db.close();

        return  isUpdate;

    }
    public boolean delete(int contatoID){

        boolean isDeletado = false;

        SQLiteDatabase db = this.getWritableDatabase();
        isDeletado = db.delete("contato", "id ='" + contatoID + "'", null) > 0;
        db.close();

        return isDeletado;

    }
}
