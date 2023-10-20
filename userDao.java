package com.example.quan_ly_kho_hang.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quan_ly_kho_hang.database.dbHelper;
import com.example.quan_ly_kho_hang.model.Product;
import com.example.quan_ly_kho_hang.model.User;

import java.util.ArrayList;

public class userDao {
    private  final dbHelper dbHelper;

    public userDao(Context context) {
        dbHelper = new dbHelper(context);
    }
    public ArrayList<User> selectAll(){
        ArrayList<User>list= new ArrayList<>();
        SQLiteDatabase database =dbHelper.getReadableDatabase();
        try{
            Cursor cursor =database.rawQuery("select * from User", null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
            }while (!cursor.isAfterLast()){
                User user = new User();
                user.setUserName(cursor.getString(0));
                user.setPassword(cursor.getString(1));
                user.setNumberPhone(cursor.getString(2));
                user.setPosition(cursor.getString(3));
                user.setAvatar(cursor.getString(4));
                user.setProfile(cursor.getString(5));
                user.setLastLogin(cursor.getString(6));
                user.setCreatedDate(cursor.getString(7));
                user.setLastAction(cursor.getString(8));
                list.add(user);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<User> checkUser(){
        ArrayList<User>list= new ArrayList<>();
        SQLiteDatabase database =dbHelper.getReadableDatabase();
        try{
            Cursor cursor =database.rawQuery("select * from User", null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
            }while (!cursor.isAfterLast()){
                User user = new User();
                user.setUserName(cursor.getString(0));
                user.setAvatar(cursor.getString(1));
                list.add(user);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
//    String userName;// khoa chinh
//    String password;
//    String numberPhone;
//    String position;// chuc vu
//    String avatar;
//    String profile;// gioi thieu tom tat
//    String lastLogin;// lan cuoi dang nhap
//    String screatedDate; // ngay tao tai khoan
//    String lastAction; // lan cuoi hanh dong tren he thong
}
