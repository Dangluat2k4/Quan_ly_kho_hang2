package com.example.quan_ly_kho_hang.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quan_ly_kho_hang.database.dbHelper;
import com.example.quan_ly_kho_hang.model.Bill;
import com.example.quan_ly_kho_hang.model.BillDetail;

import java.util.ArrayList;

public class billDetailDao {
    private final dbHelper dbHelper;

    public billDetailDao(Context context) {
        dbHelper = new dbHelper(context);
    }

    public ArrayList<BillDetail> selectAll() {
        ArrayList<BillDetail> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = database.rawQuery("select * from BillDetail", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
            }
            while (!cursor.isAfterLast()) {
                BillDetail bill = new BillDetail();
                bill.setId(cursor.getInt(0));
                bill.setBillID(cursor.getInt(1));
                bill.setQuantity(cursor.getString(2));
                bill.setCreatedDate(cursor.getString(3));
                list.add(bill);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // sắp xếp theo giá sản phẩm
    public ArrayList<BillDetail> sapXepTheoGia() {
        ArrayList<BillDetail> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM Product ORDER BY CAST(price AS INTEGER) ASC", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
            }
            while (!cursor.isAfterLast()) {
                BillDetail bill = new BillDetail();
                bill.setId(cursor.getInt(0));
                bill.setBillID(cursor.getInt(1));
                bill.setQuantity(cursor.getString(2));
                bill.setCreatedDate(cursor.getString(3));
                list.add(bill);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // tính tổng số lượng cho 1 nhóm cụ thể

//    int id;
//    int billID;
//    String quantity;// so luong san pham
//    String createdDate;

}
