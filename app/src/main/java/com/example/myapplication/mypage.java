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

    TextView follower;
    TextView following;
    TextView followerInt;
    TextView followingInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        findViewById(R.id.mypageLogout).setOnClickListener(onClickListener);
        follower = (TextView) findViewById(R.id.followerStr);
        follower.setOnClickListener(onClickListener);
        following = (TextView) findViewById(R.id.followingStr);
        following.setOnClickListener(onClickListener);
        followerInt = (TextView) findViewById(R.id.num_of_follower);
        followerInt.setOnClickListener(onClickListener);
        followingInt = (TextView) findViewById(R.id.num_of_following);
        followerInt.setOnClickListener(onClickListener);

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
                final DocumentReference docRef = db.collection("Users").document(dbFunc.uid);
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
                case R.id.followerStr:
                case R.id.num_of_follower:
                    followerFindUser();
                    break;
                case R.id.followingStr:
                case R.id.num_of_following:
                    followingFindUser();
                    break;
            }
        }
    };

    private void profileShow(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        memberInfo userObject = dbFunc.backinfo();
        TextView nameText = (TextView) findViewById(R.id.user_name);
        TextView majorText = (TextView) findViewById(R.id.my_intro_main);
        TextView erNum = (TextView) findViewById(R.id.num_of_follower);
        TextView ingNum = (TextView) findViewById(R.id.num_of_following);
        if(userObject != null){
            nameText.setText(userObject.getName());
            majorText.setText(userObject.getMajor());
            erNum.setText(String.valueOf(userObject.getFollowerNum()));
            ingNum.setText(String.valueOf(userObject.getFollowingNum()));
        }else{
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
    private void followerFindUser(){
        Intent intent = new Intent(this, FindUser.class);
        intent.putExtra("where", 1); //1은 follower
        startActivity(intent);
    }
    private void followingFindUser(){
        Intent intent = new Intent(this, FindUser.class);
        intent.putExtra("where", 2); //2는 following
        startActivity(intent);
    }
}