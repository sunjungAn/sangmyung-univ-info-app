package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

public class mypage extends AppCompatActivity {

    static final String TAG = "myPageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            Log.d("logout", "user = null");
            CompleteSignUp();
        }else{
            Log.d("logout", "user != null");
            if(dbFunc.uid == null){
                dbFunc.uid = user.getUid();
            }
            if(dbFunc.member == null){
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Log.d("checkfunc", "1");
                final DocumentReference docRef = db.collection("Users").document(dbFunc.uid);
                Log.d("checkfunc", "2");
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        dbFunc.member = documentSnapshot.toObject(memberInfo.class);
                        profileShow();
                    }
                });
                Log.d("checkfunc", "4");
            }else{ profileShow(); }
        }

        findViewById(R.id.mypageLogout).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.mypageLogout:
                    Log.d("logout", "button clicked");
                    FirebaseAuth.getInstance().signOut();
                    Log.d("logout", "logout done");
                    CompleteSignUp();
                    break;
            }
        }
    };

    private void profileShow(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Log.d("showFunc", "will get");
        memberInfo userObject = dbFunc.backinfo();
        Log.d("showFunc", "geted");
        Log.d("tryfunc", dbFunc.uid);
        TextView nameText = (TextView) findViewById(R.id.user_name);
        if(userObject != null){
            Log.d("func", userObject.getName());
            nameText.setText(userObject.getName());
        }else{
            Log.d("showFunc", "what");
        }


//        DocumentReference docRef = db.collection("Users").document(user.getUid());
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//               memberInfo member = documentSnapshot.toObject(memberInfo.class);
//               TextView nameText = (TextView) findViewById(R.id.user_name);
//               nameText.setText(member.getName().toString());
//            }
//        });
    }


    private void startToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    private void CompleteSignUp(){
        Intent intent = new Intent(this, LogingPageActivity.class);
        startActivity(intent);
    }
}