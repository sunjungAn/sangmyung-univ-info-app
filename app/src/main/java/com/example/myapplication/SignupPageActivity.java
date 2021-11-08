package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        findViewById(R.id.complete_signup).setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.complete_signup:
                    CompleteSignUp();
                    break;
            }
        }
    };
    private void CompleteSignUp(){
        Intent intent = new Intent(this, LogingPageActivity.class);
        startActivity(intent);

    }
}