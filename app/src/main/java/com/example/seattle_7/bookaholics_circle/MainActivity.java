package com.example.seattle_7.bookaholics_circle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1=(ImageView)findViewById(R.id.i2);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //admin

                Intent i=new Intent(MainActivity.this,UserMainActivity.class);
                startActivity(i);

            }
        });



    }
}
