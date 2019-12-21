package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// FIXME toast在进入某些事件如onResume由于页面未初始化会不显示
// 观察Activity生命周期要看log
/* 几个常见的应用切换情景
 * 1. 回到桌面：Pause->Stop
 * 2. 【Recent Apps key】：Pause->Stop
 * 3. 回到APP：onRestart->onStartResume
 * 4. 在Recent Apps中划掉应用：onDestroy
 * 5. Activity1切换到2：Pause1->Create2->Start2->Resume2->Stop2
 * 6. Activity2切回1：Pause2->restart1->start1-resume1-stop2-destroy2
 * */
public class MainActivity extends AppCompatActivity {

  public static final String TAG = "ActivityLifecycle1";

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

    // secondActivity部分
    Button secondActivity = findViewById(R.id.secondActivity);
    secondActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(startIntent);
      }
    });

    // 平方计算部分
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

    // ToastButton部分
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
