package com.panos.it21848;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import androidx.annotation.*;
import java.util.*;

public class SQLiteHelper extends SQLiteOpenHelper{
    public static String DB_NAME="TEST";
    public static String TABLE_NAME="USERS";
    public static String FIELD_1="USERID";
    public static String FIELD_2="LONGITUDE";
    public static String FIELD_3="LATITUDE";
    public static String FIELD_4="TIMESTAMP";
    public static String SQL_QUERY="CREATE TABLE "+TABLE_NAME+"("+FIELD_1+" TEXT,"+FIELD_2+" REAL,"+FIELD_3+" REAL,"+FIELD_4+" TEXT)";
    public SQLiteHelper(@Nullable Context context){
        super(context,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(SQL_QUERY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1){}
    public long insertUser(User user){
        ContentValues values=new ContentValues();
        values.put(FIELD_1,user.getUserid());
        values.put(FIELD_2,user.getLongitude());
        values.put(FIELD_3,user.getLatitude());
        values.put(FIELD_4,user.getTimestamp());
        return this.getWritableDatabase().insert(TABLE_NAME,null,values);
    }
    public ArrayList<String> getAllTimeStamps(){
        ArrayList<String> list=new ArrayList<>();
        Cursor cursor=this.getReadableDatabase().query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.getCount()>0){
            while(cursor.moveToNext())
                list.add(cursor.getString(cursor.getColumnIndex(FIELD_4)));
        }
        cursor.close();
        return list;
    }
    public ArrayList<User> getAllUserByIdAndTimestamp(String userid,String timestamp){
        ArrayList<User> users=new ArrayList<>();
        Cursor cursor=this.getReadableDatabase().query(TABLE_NAME,null,"USERID=? and TIMESTAMP=?",new String[]{userid,timestamp},null,null,null);
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                String useridr=cursor.getString(0);
                float longituder=Float.parseFloat(cursor.getString(1));
                float latituder=Float.parseFloat(cursor.getString(2));
                String timer=cursor.getString(3);
                User user=new User(useridr,longituder,latituder,timer);
                users.add(user);
            }
        }
        cursor.close();
        return users;
    }
}