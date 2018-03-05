package com.example.mca003.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class signin_page extends AppCompatActivity {


    public static final String FIRSTNAME="key first name";
    public static final String LASTNAME="key last name";
    public static final String EMAIL ="key email";
    public static final String USERNAME="key usrname";
    public static final String PASS1="key password1";
    public static final String PASS2="key password2";


SharedPreferences sharedpref;
    TextView frstname, secondname,usrnm,email,pass1,pass2,menu,btnsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);


        frstname = (TextView) findViewById(R.id.txtfrstname);
        secondname = (TextView) findViewById(R.id.txtsecnam);
        usrnm = (TextView) findViewById(R.id.txtusrnm);
        email=(TextView)findViewById(R.id.txtemail);
        pass1 = (TextView) findViewById(R.id.txtpas1);
        pass2 = (TextView) findViewById(R.id.txtpas2);
        menu = (TextView) findViewById(R.id.btnmenu);
        btnsig = (Button) findViewById(R.id.btnsign);


        sharedpref = getSharedPreferences("MySharedPreferences",MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedpref.edit();

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(frstname.getText().toString())) {
                    frstname.setError("Please enter First Name");

                }
                else if (TextUtils.isEmpty(secondname.getText().toString())) {
                    secondname.setError("please enter Second Name");

                }
                else if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("please enter Email");

                }
                else if (TextUtils.isEmpty(usrnm.getText().toString())) {
                    usrnm.setError("please enter Username");

                }else if (TextUtils.isEmpty(pass1.getText().toString())) {
                    pass1.setError("please enter Password");

                } else if (TextUtils.isEmpty(pass2.getText().toString())) {
                    pass2.setError("please Reenter Password");

                } else if ((pass1.getText().toString().equals(pass2.getText().toString()))) {
                    editor.putString(FIRSTNAME,String.valueOf(frstname.getText()));
                    editor.putString(LASTNAME,String.valueOf(secondname.getText()));
                    editor.putString(USERNAME,String.valueOf(usrnm.getText()));
                    editor.putString(EMAIL,String.valueOf(email.getText()));
                    editor.putString(PASS1,String.valueOf(pass1.getText()));
                    editor.putString(PASS2,String.valueOf(pass2.getText()));
                    editor.commit();

                    Toast.makeText(signin_page.this, "SUCCESSFUL LOGIN", Toast.LENGTH_LONG).show();



                } else {
                    Toast.makeText(signin_page.this, "PASSWORDS DOSENT MATCH", Toast.LENGTH_LONG).show();
                    //Intent i = new Intent(MainActivity.this,second_activity.class);
                    //startActivity(i);
                }
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(signin_page.this, menu);
                popupMenu.getMenuInflater().inflate(R.menu.contextmenu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int id1 = menuItem.getItemId();

                        switch (id1){
                            case R.id.mnu_clear:
                                frstname.setText("");
                                usrnm.setText("");
                                email.setText("");
                                secondname.setText("");
                                pass1.setText("");
                                pass2.setText("");
                                frstname.requestFocus();
                                break;

                            case R.id.mnu_logpg:
                                Intent i = new Intent(signin_page.this,MainActivity.class);
                                startActivity(i);
                        }

                        //Toast.makeText(signin_page.this, ""+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();

            }
        });


    }

}
