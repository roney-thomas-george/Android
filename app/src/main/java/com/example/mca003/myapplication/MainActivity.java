package com.example.mca003.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mca003.myapplication.signin_page.PASS2;
import static com.example.mca003.myapplication.signin_page.USERNAME;


public class MainActivity extends AppCompatActivity {

    EditText name,pass;
    Button btnlog,btnsig;
    String uname,paswrd,tempusrname,temppass;
    SharedPreferences sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        name = (EditText) findViewById(R.id.txtusrnm);
        pass= (EditText) findViewById(R.id.txtpass);
        btnlog = (Button)findViewById(R.id.btnlogin);
        btnsig=(Button)findViewById(R.id.btnsign);

        sharedpref=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedpref.edit();

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("please enter name");

                }
                else if (TextUtils.isEmpty(pass.getText().toString()))
                {
                    pass.setError("please enter password");

                }

                else {

                    tempusrname=name.getText().toString();
                    temppass=pass.getText().toString();
                    if(sharedpref.contains(USERNAME)){
                        uname=sharedpref.getString(USERNAME,"");
                    }
                    if(sharedpref.contains(PASS2)){
                        paswrd =sharedpref.getString(PASS2,"");
                    }

                    if(tempusrname.equals(uname) && tempusrname.equals(paswrd)){


                        Toast.makeText(MainActivity.this, "Hi Welcometo Programing", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this,second_activity.class);
                        startActivity(i);
                        name.setText("");
                        pass.setText("");
                    }

                    else {
                        Toast.makeText(MainActivity.this, "INVALID username/password", Toast.LENGTH_SHORT).show();
                    }
                }


            }

        });

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent j = new Intent(MainActivity.this,signin_page.class);
            startActivity(j);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

                switch(id){
                    case R.id.mnu_about:
                        Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.app_bar_search:
                        String url = "http://www.google.com";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;

                    case R.id.mnu_exit:
                        finish();
                        System.exit(0);

                }

        return super.onOptionsItemSelected(item);
    }
}
