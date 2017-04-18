package org.androidtown.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by LEE on 2017-04-18.
 */

public class Register extends AppCompatActivity {
    TextView t1, t2, t3;
    Button btn;
    Bundle bundle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        btn = (Button) findViewById(R.id.btn);
        //get a intent
        intent = getIntent();
        //pull the bundle in intent
        bundle = intent.getExtras();
        //set text to EditText
        t1.setText(bundle.getString("name"));
        t2.setText(bundle.getString("st"));
        t3.setText(bundle.getString("st2"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish the Register activity
                finish();
            }
        });

    }
}
