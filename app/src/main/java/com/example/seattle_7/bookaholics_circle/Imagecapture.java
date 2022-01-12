package com.example.seattle_7.bookaholics_circle;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Imagecapture extends AppCompatActivity {
    FileOutputStream fileoutputstream;
    Bitmap b;
     String rp;
    File file;
    TextView t1,t2,t3;


    String photoPath = null;
    private static final int CAMERA_REQUEST = 1888;
    // MyDataBase myDataBase;
    Intent cameraIntent;
    SQLiteDatabase database;
    byte[] img, img1;
    private Uri mImageCaptureUri;
    String selectedImagePath;
    ImageView mimageView;
    private String imgPath;

    String result;
    Button b1,b2,b3,b4,b5;
    String strAddress,s1="";

    StringBuffer str ;
    String phone;
String location;
    int click=0;
    String ss;

    Cursor c,c1;
    String data;
    String address;
    double lat=0.0,lon=0.0,latitude=0.0,longitude=0.0,la=0.0,lo=0,fg=0,fg1=0,radius=0;
    protected LocationManager lm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagecapture);




        mimageView = (ImageView) this.findViewById(R.id.image_from_camera);


        Button button = (Button) this.findViewById(R.id.take_image_from_camera);
       // location=getIntent().getExtras().getString("location");
      //  Toast.makeText(this," Location to be sent "+location,Toast.LENGTH_LONG).show();
    }

    public void takeImageFromCamera(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //  if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Block in", Toast.LENGTH_SHORT).show();

            // Uri imageFileUri = data.getData();
            // String path=getRealPathFromURI(this,imageFileUri);
            // Bitmap bitmap = (Bitmap) data.getExtras().get("data");

//            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath(data.toString());
            // Toast.makeText(this,"Absolute path "+absolutePath,Toast.LENGTH_SHORT).show();
            // myDataBase = new MyDataBase(getApplicationContext(), "imagedata", null, 1);

            // database = myDataBase.getWritableDatabase();

            //Uri uriFromPath = Uri.fromFile(new File(realPath));
            Bitmap mphoto = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            mphoto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            img = stream.toByteArray();

            mimageView.setImageBitmap(mphoto);





            //open dband process

            file = new File(Environment.getExternalStorageDirectory() + "/SampleImage.png");

           rp= Environment.getExternalStorageDirectory() + "/SampleImage.png";

            try

            {
                file.createNewFile();

                fileoutputstream = new FileOutputStream(file);

                fileoutputstream.write(stream.toByteArray());

                fileoutputstream.close();






        } catch (Exception e)

            {

                e.printStackTrace();

            }
            Toast.makeText(this,"Path "+rp,Toast.LENGTH_SHORT).show();
          //  Toast.makeText(this,"location "+location,Toast.LENGTH_SHORT).show();






          //  Toast.makeText(this,"Current Location is "+location,Toast.LENGTH_LONG).show();

            Thread thread = new Thread() {
                @Override
                public void run() {



                   // GMailSender sender = new GMailSender("hasidata@gmail.com", "hasi@12345");



                }
            };
            thread.start();
            // file.delete();

            // Bitmap mphoto1=(Bitmap ) data.getAction()
            // mimageView.setImageBitmap(mphoto);
        }
    }


    public String getAbsolutePath(Uri uri) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }


}



