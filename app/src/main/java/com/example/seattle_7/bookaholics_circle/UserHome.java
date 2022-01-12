package com.example.seattle_7.bookaholics_circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UserHome extends AppCompatActivity {

    ImageView i1,i2;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofilemain);

        i1=(ImageView)findViewById(R.id.i2);
        i2=(ImageView)findViewById(R.id.i4);
        user=getIntent().getExtras().getString("user");

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //admin

                Intent i=new Intent(UserHome.this,Setbookdetails.class);
                i.putExtra("user", user);
                startActivity(i);

            }
        });


        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //user
                Intent i=new Intent(UserHome.this,booklist.class);
                startActivity(i);



            }
        });









    }
}
