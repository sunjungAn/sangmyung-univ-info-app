package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogingPageActivity extends AppCompatActivity {

    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loging_page);
        loginbtn = findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.login_btn:
                    Login();
            }
        }
    };

    private void Login(){
        Intent intent = new Intent(this, tablemap.class);
        startActivity(intent);
    }
}