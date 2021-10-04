package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Example2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);
        findViewById(R.id.signup_button).setOnClickListener(onClickListener);
        findViewById(R.id.login_button1).setOnClickListener(onClickListener);


    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) { //클릭된 위젯의 id를 이용
            switch (v.getId()) {
                case R.id.signup_button:
                    Intent intent_profile = new Intent(Example2.this, Example1.class);

                    String email = ((EditText) findViewById(R.id.idsignup)).getText().toString();
                    String password = ((EditText) findViewById(R.id.passwordsignup)).getText().toString();
                    String re_password = ((EditText) findViewById(R.id.repasswordsignup)).getText().toString();
                    //가입조건이 충족됐을 때 프로필 수정 화면으로 넘어가는 조건이 되어야함
                    startToast(email + password);
                    startActivity(intent_profile);
                    break;
                case R.id.login_button1:
                    startLoginActivity(); // 로그인 창으로 간다
                    break;

            }
        }
    };
    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    // 로그인 창으로 가는 함수
    private void startLoginActivity() {
        Intent intent = new Intent(this, Example2.class);
        startActivity(intent);
    }
}
