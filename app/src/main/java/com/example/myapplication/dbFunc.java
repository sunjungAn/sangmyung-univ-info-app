package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class dbFunc {

    public dbFunc(){}

    public static String uid;
    public static memberInfo member;

    public static void onlyAddName(String uid, String name){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        memberInfo user = new memberInfo(name,"0", "0", "0");
        db.collection("Users").document(uid).set(user);

    }

    private static int a = 0;

    public static void writeMemberObject(String uid){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Log.d("checkfunc", "1");
        DocumentReference docRef = db.collection("Users").document(uid);
        Log.d("checkfunc", "2");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("checkfunc", "3");
                member = documentSnapshot.toObject(memberInfo.class);
                a = 1;
                Log.d("inFunc","inobiect");
                Log.d("inFunc", String.valueOf(a));
                Log.d("func", "infowrited");
            }
        });
        Log.d("checkfunc", "4");
        Log.d("inFunc", String.valueOf(a));
    }

    public static void writeUid(String loginUid){
        uid = loginUid;
        Log.d("func","uidwrited");
    }

    public static memberInfo backinfo(){
        return member;
    }

}
