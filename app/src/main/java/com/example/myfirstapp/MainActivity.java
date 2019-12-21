package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = "Toast";

  // 封装Toast消息方法
  public void sendToast(CharSequence Message) {
    Log.d(TAG, ""+Message);
    Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    sendToast("onCreate");

    final EditText squareInput = findViewById(R.id.squareInput);
    final TextView squareOutput = findViewById(R.id.squareOutput);
    Button squareCalc = findViewById(R.id.squareCalc);
    squareCalc.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int input = Integer.parseInt(squareInput.getText().toString());
        String output = String.valueOf(input * input);
        squareOutput.setText(output);
        sendToast(output);
      }
    });

    Button toastButton = findViewById(R.id.toastButton);
    toastButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sendToast("网络请求失败！");
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
    Log.d(TAG, "onResume: ");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause: ");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop: ");
  }
}
