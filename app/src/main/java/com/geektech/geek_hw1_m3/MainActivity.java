package com.geektech.geek_hw1_m3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button send;
    private EditText address;
    private EditText subjects;
    private EditText emailtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button) findViewById(R.id.emailsendbutton);
        address = (EditText) findViewById(R.id.emailaddress);
        subjects = (EditText) findViewById(R.id.emailsubject);
        emailtext = (EditText) findViewById(R.id.emailtext);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String to = address.getText().toString();
                String subject = subjects.getText().toString();
                String message = emailtext.toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);


                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Выберите email клиент :"));


                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"matadon.kg@gmail.com"});

                email.putExtra(Intent.EXTRA_SUBJECT, subject);

                email.putExtra(Intent.EXTRA_TEXT, "Privet");

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Выберите email клиент :"));


            }
        });
    }
}
