package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogingPageActivity extends AppCompatActivity {

    private static final String TAG = "LogInActivity";

    private FirebaseAuth mAuth;

    Button loginbtn;
    Button signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loging_page);
        loginbtn = findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(onClickListener);
        signupbtn = findViewById(R.id.signup_btn);
        signupbtn.setOnClickListener(onClickListener);

        mAuth = FirebaseAuth.getInstance();
    }


    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.login_btn:
                    logIn();
                    break;
                case R.id.signup_btn:
                    SignUP();
            }
        }
    };

    private void logIn() {
        String email = ((EditText)findViewById(R.id.loginId)).getText().toString();
        String password = ((EditText)findViewById(R.id.loginPw)).getText().toString();
        if(email.length() > 0 && password.length() > 0){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인 완료!");
                                Log.d(TAG, "bcdefg");
                                CompleteLogin();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                startToast("로그인 실패...");
                            }
                        }
                    });
        }else{ //이메일이나 비번이 입력하지 않을 때
            startToast("이메일이나 비밀번호를 입력안하시면 어떡합니까...");
        }
    }
    // 토스트 메세지를 표시하는 함수
    private void startToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    private void CompleteLogin(){
        Intent intent = new Intent(this, tablemap.class);
        startActivity(intent);
    }

    private void SignUP(){
        Intent intent = new Intent(this, SignupPageActivity.class);
        startActivity(intent);
    }
}