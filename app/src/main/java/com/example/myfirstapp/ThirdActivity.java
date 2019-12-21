package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

  public static final String TAG = "ActivityLifecycle3";

  // 封装Toast消息方法
  public void sendToast(CharSequence Message) {
    Log.d(TAG, ""+Message);
    Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_third);
    sendToast("onCreate");

    Button gotoThird = findViewById(R.id.gotoFirst);
    gotoThird.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent redirect = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(redirect);
      }
    });

  }

  @Override
  protected void onStart() {
    super.onStart();
    sendToast("onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(TAG, "onRestart");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy");
  }
}
