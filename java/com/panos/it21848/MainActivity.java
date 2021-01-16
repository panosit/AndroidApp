package com.panos.it21848;
import androidx.appcompat.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity{
    Button button,button2;
    EditText userid,longtitude,latitude,timestamp;
    String useridr,timestampr;
    float longituder,latituder;
    public SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper=new SQLiteHelper(MainActivity.this);
        userid=findViewById(R.id.userid);
        longtitude=findViewById(R.id.longtitude);
        latitude=findViewById(R.id.latitude);
        timestamp=findViewById(R.id.timestamp);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button.setOnClickListener(view->{
            useridr=userid.getText().toString();
            longituder=Float.parseFloat(longtitude.getText().toString());
            latituder=Float.parseFloat(latitude.getText().toString());
            timestampr=timestamp.getText().toString();
            User user=new User(useridr,longituder,latituder,timestampr);
            Toast.makeText(MainActivity.this,sqLiteHelper.insertUser(user)+"",Toast.LENGTH_SHORT).show();
        });
        button2.setOnClickListener(view->{
            Toast.makeText(MainActivity.this,"second activity",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,Show.class);
            startActivity(intent);
        });
    }
}