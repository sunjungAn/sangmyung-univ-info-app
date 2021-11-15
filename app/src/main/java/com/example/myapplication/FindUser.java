package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FindUser  extends AppCompatActivity {

    ListView mListView = null;
    FindUserAdapter mAdapter = null;
    ArrayList<Users> mData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        mData = new ArrayList<Users>();

        for (int i = 0; i < 10; i++) {
            Users user = new Users();
            user.mUserName = "컴과 수석";
            user.mtext = "나는야 상명대학교 컴과의 미래";
            mData.add(user);
        }

        mAdapter = new FindUserAdapter(this, mData);
        mListView = (ListView) findViewById(R.id.find_user_listview);
        mListView.setAdapter(mAdapter);
    }

}
