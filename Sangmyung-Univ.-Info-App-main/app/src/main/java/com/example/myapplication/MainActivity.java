package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.os.Bundle;
=======
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
>>>>>>> 3caceadeb9a749559e729c99c3ed1422c59a6fe3

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
<<<<<<< HEAD
=======
    private void startToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
    private void startSignUpActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

>>>>>>> 3caceadeb9a749559e729c99c3ed1422c59a6fe3
}