package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupPageActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.complete_signup).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.complete_signup:
                    signUp();
                    break;
            }
        }
    };

    private void signUp() {
        String email = ((EditText)findViewById(R.id.signup_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.signup_password)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.signup_passwordCheck)).getText().toString();
        String name = ((EditText)findViewById(R.id.signUpUserName)).getText().toString();
        //비번 체크란 만들어야 돼요
        if(email.length() > 0 && password.length() > 0){
            if(password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("회원가입이 완료되었습니다!");
                                    dbFunc.onlyAddName(user.getUid(), name);
                                    //CompleteSignUp();
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    startToast("회원가입이 실패하였습니다...");
                                }
                            }
                        });
            }else{ //비번이 일치하지 않을 때
                startToast("비밀번호가 일치하지 않습니다.");
            }
        }else{ //이메일이나 비번이 입력하지 않을 때
            startToast("이메일이나 비밀번호를 입력안하시면 어떡합니까...");
        }
    }

    private void addUserInfo(String name, String uid){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        memberInfo user = new memberInfo(name,"0", "0", "0", 0, 0);
        db.collection("Users").document(uid).set(user);
    }



    // 토스트 메세지를 표시하는 함수
    private void startToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    private void CompleteSignUp(){
        Intent intent = new Intent(this, LogingPageActivity.class);
        startActivity(intent);
    }
}