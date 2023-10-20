package com.example.quan_ly_kho_hang.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quan_ly_kho_hang.database.dbHelper;
import com.example.quan_ly_kho_hang.model.Bill;
import com.example.quan_ly_kho_hang.model.BillDetail;

import java.util.ArrayList;

public class billDao {
    private  final dbHelper dbHelper;

    public billDao(Context context) {
        dbHelper = new dbHelper(context);
    }
    public ArrayList<Bill> selectAll(){
        ArrayList<Bill>list= new ArrayList<>();
        SQLiteDatabase database =dbHelper.getReadableDatabase();
        try{
            Cursor cursor =database.rawQuery("select * from Bill", null);
                if (cursor.getCount()>0){
                    cursor.moveToFirst();
                }while (!cursor.isAfterLast()){
                        Bill bill = new Bill();
                        bill.setId(cursor.getInt(0));
                        bill.setProductID(cursor.getInt(1));
                        bill.setName(cursor.getString(2));
                        bill.setQuantity(cursor.getString(3));
                        bill.setCreateByUser(cursor.getString(4));
                        bill.setCreatedDate(cursor.getString(5));
                        list.add(bill);
                        cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /// check hoa don theo ngay
    public ArrayList<Bill> checkHoaDon(){
        ArrayList<Bill>list= new ArrayList<>();
        SQLiteDatabase database =dbHelper.getReadableDatabase();
        try{
            Cursor cursor =database.rawQuery("SELECT * FROM Bill WHERE createdDate LIKE '2023-10-18%'", null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
            }while (!cursor.isAfterLast()){
                Bill bill = new Bill();
                bill.setId(cursor.getInt(0));
                bill.setProductID(cursor.getInt(1));
                bill.setName(cursor.getString(2));
                bill.setQuantity(cursor.getString(3));
                bill.setCreateByUser(cursor.getString(4));
                bill.setCreatedDate(cursor.getString(5));
                bill.setNote(cursor.getString(6));
                list.add(bill);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /// kiem tra hoa don theo nguoi dung
    public ArrayList<Bill> checkUser(){
        ArrayList<Bill>list= new ArrayList<>();
        SQLiteDatabase database =dbHelper.getReadableDatabase();
        try{
            Cursor cursor =database.rawQuery("SELECT * FROM Bill WHERE createdDate LIKE '2023-10-18%'", null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
            }while (!cursor.isAfterLast()){
                Bill bill = new Bill();
                bill.setId(cursor.getInt(0));
                bill.setProductID(cursor.getInt(1));
                bill.setName(cursor.getString(2));
                bill.setQuantity(cursor.getString(3));
                bill.setCreateByUser(cursor.getString(4));
                bill.setCreatedDate(cursor.getString(5));
                bill.setNote(cursor.getString(6));
                list.add(bill);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Bill> tongSL() {
        ArrayList<Bill> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = database.rawQuery("SELECT billID, SUM(quantity) AS total_quantity FROM BillDetail GROUP BY billID", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
            }
            while (!cursor.isAfterLast()) {
                Bill bill = new Bill();
                bill.setId(cursor.getInt(0));
                bill.setQuantity(cursor.getString(2));
                list.add(bill);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//    int id;// ma hoa don
//    int productID; // khoa ngoai
//    String name; // tên sản phẩm
//    String quantity;//<0 nhap kho >0 xuat kho;
//    String createByUser;// tao boi ai
//    String createDate; // ngay tao hoa don
//    String note; // ghi chu
}
