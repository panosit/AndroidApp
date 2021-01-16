package com.panos.it21848;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.*;
import java.util.*;

public class Show extends AppCompatActivity{
    EditText userid;
    String useridr,SearchTimestamp;
    Button button,button1;
    Spinner spinner;
    public SQLiteHelper sqLiteHelper=new SQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        userid=findViewById(R.id.userid2);
        button=findViewById(R.id.button3);
        button1=findViewById(R.id.button4);
        spinner=findViewById(R.id.spinner);
        ArrayList<String> list=sqLiteHelper.getAllTimeStamps();
        spinner.setAdapter(new ArrayAdapter<>(this,R.layout.spinner_layout,R.id.txt,list));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView,View view,int i,long l){
                SearchTimestamp=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){}
        });
        button.setOnClickListener(view->{
            useridr=userid.getText().toString();
            if(useridr.isEmpty())
                Toast.makeText(Show.this, "PLease complete Userid and timestamp!",Toast.LENGTH_SHORT).show();
            else{
                Intent intent=new Intent(Show.this,Result.class);
                intent.putExtra("userid", useridr);
                intent.putExtra("timestamp",SearchTimestamp);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(view->{
            useridr=userid.getText().toString();
            Intent intent=getPackageManager().getLaunchIntentForPackage("com.panos.newa");
            intent.putExtra("userid",useridr);
            startActivity(intent);
        });
    }
}