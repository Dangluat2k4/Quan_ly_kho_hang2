package com.example.quan_ly_kho_hang.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quan_ly_kho_hang.database.dbHelper;
import com.example.quan_ly_kho_hang.model.BillDetail;
import com.example.quan_ly_kho_hang.model.Product;

import java.util.ArrayList;

public class productDao {
    private  final dbHelper dbHelper;

    public productDao(Context context) {
        dbHelper = new dbHelper(context);
    }
    public ArrayList<Product> selectAll(){
        ArrayList<Product>list= new ArrayList<>();
        SQLiteDatabase database =dbHelper.getReadableDatabase();
        try{
            Cursor cursor =database.rawQuery("select * from Product", null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
            }while (!cursor.isAfterLast()){
                Product product = new Product();
                product.setId(cursor.getInt(0));
                product.setName(cursor.getString(1));
                product.setQuantity(cursor.getString(2));
                product.setPrice(cursor.getString(3));
                product.setPhoto(cursor.getString(4));
                product.setUserID(cursor.getString(5));
                list.add(product);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
//    int id;// khoa chinh - tu tang 0-n
//    String name;// ten san pham
//    // luu kho xuat ko nam trong hoa don
//    String quantity;// so luong cua san pham
//    String price;// gia cua san pham
//    String photo;//anh cua san pham khi vao kho
//    String userID;// id cua nguoi tao
}
