package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Example1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_example1);
        findViewById(R.id.login_button2).setOnClickListener(onClickListener);
        findViewById(R.id.resister_button).setOnClickListener(onClickListener);
        findViewById(R.id.logout_button).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) { //클릭된 위젯의 id를 이용
            switch (v.getId()) {
                case R.id.login_button2:

                    //Log
                    break;
                case R.id.resister_button:
                    break;
                case R.id.logout_button:
                    //SignOut();
            }
        }
    };

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void startSignUpActivity() {
        Intent intent = new Intent(this, MainActivity.class);
    }

}
