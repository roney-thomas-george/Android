package com.example.mca003.myapplication;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.FormatFlagsConversionMismatchException;

public class mainpage extends AppCompatActivity {


    TextView ilogin,igallery,imusic;
    private static final int ACTIVITY_SELECT_IMAGE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        ilogin=(TextView)findViewById(R.id.imglogin);
        igallery=(TextView)findViewById(R.id.imaggallery);
        imusic=(TextView)findViewById(R.id.imagmusic);

        ilogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(mainpage.this,MainActivity.class);
                startActivity(k);

            }
        });

        igallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a=new Intent(Intent.ACTION_VIEW, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(a, ACTIVITY_SELECT_IMAGE);

                /*Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, ACTIVITY_SELECT_IMAGE);*/
            }
        });

        imusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(android.os.Build.VERSION.SDK_INT>=15){
                    Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,
                            Intent.CATEGORY_APP_MUSIC);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Min SDK 15
                    startActivity(intent);
                }else{
                    Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");//Min SDK 8
                    startActivity(intent);
                }
            }
        });
    }
}
