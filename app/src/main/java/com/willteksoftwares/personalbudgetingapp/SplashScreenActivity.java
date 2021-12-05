package com.willteksoftwares.personalbudgetingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH = 3000;
    Animation animation;
    private ImageView imageView;
    private TextView appName;

    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splash_screen);

        animation = AnimationUtils.loadAnimation(this, R.anim.animation);

        imageView = findViewById(R.id.imageView);
        appName = findViewById(R.id.appName);

        imageView.setAnimation(animation);
        appName.setAnimation(animation);

        if(mCurrentUser == null){

            mAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        Intent intent = new Intent(SplashScreenActivity.this, com.willteksoftwares.personalbudgetingapp.MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            });
        }else{
            Intent intent = new Intent(SplashScreenActivity.this, com.willteksoftwares.personalbudgetingapp.MainActivity.class);
            startActivity(intent);
            finish();
        }

       /**new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
               startActivity(intent);
               finish();
           }
       }, SPLASH);*/
    }
}