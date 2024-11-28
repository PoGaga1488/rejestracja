package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView Textv1;
    private EditText email, passw, passwP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Textv1 = findViewById(R.id.textv1);
        email = findViewById(R.id.email);
        passwP = findViewById(R.id.passw2);
        passw = findViewById(R.id.passw);
        Button submit = findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email = MainActivity.this.email.getText().toString().trim();
                String password = passw.getText().toString().trim();
                String passSubmit = passwP.getText().toString().trim();
                Pattern emailP = Pattern.compile(".+@.+");

                if(!emailP.matcher(email).matches()){ // lub !Patterns.EMAIL_ADDRESS.matcher(email).matches() //
                    Textv1.setText("Nieprawidłowy adres e-mail");
                } else if(!password.equals(passSubmit)){
                    Textv1.setText("Hasła się rożnią");
                } else {
                    Textv1.setText("Witaj " + email);
                }

            }
        });

    }
}