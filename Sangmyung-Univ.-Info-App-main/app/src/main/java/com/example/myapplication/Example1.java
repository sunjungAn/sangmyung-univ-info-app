package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Example1 extends AppCompatActivity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
<<<<<<< HEAD
            setContentView(R.layout.activity_main);
=======
            setContentView(R.layout.activity_example1);
>>>>>>> 3caceadeb9a749559e729c99c3ed1422c59a6fe3
            findViewById(R.id.login_button2).setOnClickListener(onClickListener);
            findViewById(R.id.resister_button).setOnClickListener(onClickListener);
            findViewById(R.id.logout_button).setOnClickListener(onClickListener);

        }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) { //클릭된 위젯의 id를 이용
            switch (v.getId()) {
                case R.id.login_button2:
<<<<<<< HEAD
                    //Login();
                    break;
                case R.id.resister_button:
                    //startSignUpActivity();
=======
                    startToast("로그인 되었습니다.");
                    break;
                case R.id.resister_button:
                    startSignupActivity();
>>>>>>> 3caceadeb9a749559e729c99c3ed1422c59a6fe3
                    break;
                case R.id.logout_button:
                    //SignOut();
            }
        }
    };
<<<<<<< HEAD
    private void startToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
    private void startSignUpActivity(){
        Intent intent = new Intent(this, MainActivity.class);
=======

    private void startToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
    public void startSignupActivity(){
        Intent intent = new Intent(this, Example2.class);
        startActivity(intent);
    }
    public void startMainActivity(){
        Intent intent = new Intent(Example1.this, MainActivity.class);
>>>>>>> 3caceadeb9a749559e729c99c3ed1422c59a6fe3
        startActivity(intent);
    }

}
