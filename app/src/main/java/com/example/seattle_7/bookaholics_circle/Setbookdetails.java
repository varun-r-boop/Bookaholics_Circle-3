package com.example.seattle_7.bookaholics_circle;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setbookdetails extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    String user;
    String empty="";
    String name,mail,phone,address;
    int age,fg=0;
    Button b1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resale);

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);

        user=getIntent().getExtras().getString("user");

        b1=(Button)findViewById(R.id.b1);


        final SQLiteDatabase db=openOrCreateDatabase("bookresale", Context.MODE_PRIVATE,null);
        String q1="CREATE TABLE bookdetails(s1 TEXT ,s2 TEXT,s3 TEXT,s4 TEXT,s5 TEXT,s6 TEXT);";
        try{

            db.execSQL(q1);
        }
        catch (Exception e){
            Toast.makeText(this,"Exception "+e,Toast.LENGTH_SHORT).show();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=e1.getText().toString();

                mail=e3.getText().toString();
                phone=e4.getText().toString();
                address=e5.getText().toString();
                if(name.equals(empty) || mail.equals(empty) || phone.equals(empty)|| address.equals(empty))
                {

                    Toast.makeText(getApplicationContext()," Field can't be empty All the field shoul be fill",Toast.LENGTH_SHORT).show();

                }

                else{
                    String insert="INSERT INTO bookdetails(s1,s2,s3,s4,s5,s6) VALUES('"+name+"','"+e2.getText().toString()+"','"+mail+"','"+phone+"','"+address+"','"+user+"')";
                    try{
                       db.execSQL(insert);
                        Toast.makeText(getApplicationContext(), " Book Exchage Details Upload  successfully", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Setbookdetails.this,UserHome.class);
                        i.putExtra("user", user);

                        startActivity(i);

                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Exception in inserting "+e,Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
