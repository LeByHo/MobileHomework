package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup;
    RadioButton men;
    RadioButton women;
    CheckBox sns;
    CheckBox mail;
    Button btn;
    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.writeText);
        radioGroup = (RadioGroup)findViewById(R.id.Radio);
        men=(RadioButton)findViewById(R.id.menCheck);
        women=(RadioButton)findViewById(R.id.womenCheck);
        sns=(CheckBox)findViewById(R.id.SNScheck);
        mail=(CheckBox)findViewById(R.id.emailCheck);
        btn=(Button)findViewById(R.id.btn);
        //Make a new intent to move MainActivity information to Register.class
        intent=new Intent(MainActivity.this,Register.class);
        //Make a new bundle
        bundle = new Bundle();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put EditText string in bundle
                bundle.putString("name",editText.getText().toString());
                // get a radio group id
                    int radio=radioGroup.getCheckedRadioButtonId();
                // put radio button text in bundle depends on radio button id
                if(radio==men.getId())
                        bundle.putString("st",men.getText().toString());
                    else if(radio==women.getId())
                        bundle.putString("st",women.getText().toString());
                //relieve the radio button check
                men.setChecked(false);
                women.setChecked(false);
                String msg="";
                //put checkbox text in bundle depends on checkbox checked
                if(sns.isChecked()) {
                        msg+="SNS ";
                        sns.setChecked(false);
                }
                 if(mail.isChecked()) {
                    msg+="e-mail ";
                    mail.setChecked(false);
                }
                bundle.putString("st2",msg);
                //move to bundle Register class
                intent.putExtras(bundle);
                editText.setText("");
                startActivity(intent);
            }
        });

    }
}
