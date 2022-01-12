package com.example.seattle_7.bookaholics_circle;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class searchbook extends AppCompatActivity {
    Cursor c1,c2;

    String phone,user,book;

    String book_user,bookname;

    EditText e1,e2;

    SmsManager sms;
    Spinner s1,s2 ;
    String source,dest;
    Button b1;
    String t1,t2;
    TextView i1,i2;
    ArrayAdapter sp,sp1;
    List rn=new ArrayList();
    List ds=new ArrayList();
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);

        user=getIntent().getExtras().getString("user");
        book=getIntent().getExtras().getString("book");
        e1=(EditText)findViewById(R.id.editText2);

        e2=(EditText)findViewById(R.id.editText);



        if(!book.isEmpty())

        {

            Toast.makeText(getApplicationContext(), "No data found"+book, Toast.LENGTH_LONG).show();


                SQLiteDatabase myDb = openOrCreateDatabase("bookresale", Context.MODE_PRIVATE, null);

               if (myDb != null) {

                  // Cursor c = myDb.rawQuery("SELECT * from bookdetails where s1='"+book+"'", null);

                   Cursor c = myDb.rawQuery("SELECT * from bookdetails", null);



                   if (c.moveToFirst()) {
                    do {

                        Toast.makeText(getApplicationContext(), " connect", Toast.LENGTH_LONG).show();


                        bookname= c.getString(c.getColumnIndexOrThrow("s1"));

                        book_user= c.getString(c.getColumnIndexOrThrow("s6"));



                        e1.setText("  "+book_user);
                        e2.setText(""+bookname);



                    } while (c.moveToNext());//Move the cursor to the next row.
                } else {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                }


            }


        }













        //action










    }
}
