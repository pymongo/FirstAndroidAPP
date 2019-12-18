package com.example.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final EditText squareInput = findViewById(R.id.squareInput);
    final TextView squareOutput = findViewById(R.id.squareOutput);
    Button squareCalc = findViewById(R.id.squareCalc);
    squareCalc.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int input = Integer.parseInt(squareInput.getText().toString());
        squareOutput.setText(String.valueOf(input * input));
      }
    });

    Button toastButton = findViewById(R.id.toastButton);
    toastButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "[Toast]:网络请求失败！请检查您的网络";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
      }
    });
  }
}
