package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FindUser  extends AppCompatActivity {

    private static final String TAG = "searchQuery";
    ListView mListView = null;
    FindUserAdapter mAdapter = null;
    ArrayList<memberInfo> mData = new ArrayList<memberInfo>();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText searchText;
    //CollectionReference usersDb = db.collection("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        searchText = findViewById(R.id.userSearchEditText);

        mAdapter = new FindUserAdapter(this, mData);
        Log.d("pst","1");
        mListView = (ListView) findViewById(R.id.find_user_listview);
        Log.d("pst","2");

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Query yetknow = db.collection("Users").whereGreaterThanOrEqualTo("name",s.toString()).whereLessThanOrEqualTo("name",s.toString()+"zzzzzzzzzzzzz");
                yetknow.get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    mData.clear();
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        memberInfo m = document.toObject(memberInfo.class);
                                        mData.add(m);
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                    }
                                    mListView.setAdapter(mAdapter);
                                    Log.d("pst","3");
                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());
                                }
                            }
                        });
                Log.d("searchChange", "did: " + s + ", array: " +yetknow);

            }
        });

        //mData = new ArrayList<Users>();

//        for (int i = 0; i < 10; i++) {
//            Users user = new Users();
//            user.mUserName = "컴과 수석";
//            user.mtext = "나는야 상명대학교 컴과의 미래";
//            mData.add(user);
//        }


    }



}
