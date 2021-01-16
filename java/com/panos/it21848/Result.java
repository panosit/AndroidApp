package com.panos.it21848;
import androidx.appcompat.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import java.util.*;

public class Result extends AppCompatActivity{
    ListView listView;
    SQLiteHelper sqLiteHelper=new SQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listView=findViewById(R.id.listview);
        Intent intent=getIntent();
        String userid=intent.getStringExtra("userid");
        String timestamp=getIntent().getStringExtra("timestamp");
        ArrayList<User> result=sqLiteHelper.getAllUserByIdAndTimestamp(userid,timestamp);
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,result));
    }
}