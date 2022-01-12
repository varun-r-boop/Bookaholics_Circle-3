package com.example.seattle_7.bookaholics_circle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class upload_doc extends AppCompatActivity {
    Button b1,b2,b3,b4;

    int count=0;
    String user;

    byte[] img, img1;
    Cursor c;
    EditText e1;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);

        b3=(Button)findViewById(R.id.b3);


        b4=(Button)findViewById(R.id.button4);

        b1=(Button)findViewById(R.id.button);



        user=getIntent().getExtras().getString("user");


        e1=(EditText)findViewById(R.id.edittext3);





        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i=new Intent(upload_doc.this,UserHome.class);

                i.putExtra("user", user);
                startActivity(i);
                Toast.makeText(getApplicationContext(), " Upload Success",Toast.LENGTH_SHORT).show();


            }
        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i=new Intent(upload_doc.this,MainActivity.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), " Upload Success",Toast.LENGTH_SHORT).show();


            }
        });



        //search process


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                  //search process


                Intent i=new Intent(upload_doc.this,searchbook.class);


                i.putExtra("user",user);

                i.putExtra("book",e1.getText().toString());


                startActivity(i);



                //Toast.makeText(getApplicationContext(), " Upload Success",Toast.LENGTH_SHORT).show();


            }
        });











    }







}
