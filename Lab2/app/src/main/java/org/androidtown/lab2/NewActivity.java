package org.androidtown.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent passedIntent=getIntent();
        if(passedIntent!=null){
            String loginName = passedIntent.getStringExtra("name");
            String loginAge = passedIntent.getStringExtra("age");
            Toast.makeText(getApplicationContext(),loginName+" "+loginAge,Toast.LENGTH_LONG).show();

        }
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
