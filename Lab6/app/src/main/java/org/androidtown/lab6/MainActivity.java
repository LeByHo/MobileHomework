package org.androidtown.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;
    EditText edit;
    File sdCard;
    File directory;
    File file;
    FileOutputStream fOut;
    FileInputStream fIn;
    OutputStreamWriter osw;
    InputStreamReader isr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit =(EditText)findViewById(R.id.txtData);
         sdCard = Environment.getExternalStorageDirectory(); // make a environment for storage
         directory = new File(sdCard.getAbsolutePath()+"/MyFiles"); // make a directory path
        directory.mkdir(); // make a directory
        file = new File(directory, "textfile.txt"); // make a file
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() { // save a data
            @Override
            public void onClick(View v) {
                try { // write a sentence to "textfile.txt"
                    fOut = new FileOutputStream(file,true);
                    osw= new OutputStreamWriter(fOut);
                    osw.write(edit.getText().toString());
                    osw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // clear edittext
                edit.setText("");
            }
        });
        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fIn = new FileInputStream(file);
                    if(fIn!=null){ //read a text file
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));
                        String str="";
                        StringBuffer buf = new StringBuffer();
                        while((str= reader.readLine())!=null){
                            buf.append(str+"\n"); // append textfile line to string buffer
                        }
                        fIn.close();
                        edit.setText(buf.toString()); // set  a edit text
                    }

            }catch (java.io.FileNotFoundException e){
                }catch (Throwable t) {

                }        }
        });
        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }); //finish app

    }
}
