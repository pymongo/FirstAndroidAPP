package com.example.myfirstapp;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView listView = findViewById(R.id.list_view);
    ItemAdapter adapter = new ItemAdapter(this);
    listView.setAdapter(adapter);
    String versionName = "";
    String versionCode = "";
    try {
      PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
      versionName = packageInfo.versionName;
      versionCode = packageInfo.versionCode+"";
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    }
    adapter.addItem("android.os.Build.DEVICE", android.os.Build.DEVICE);
    adapter.addItem("android.os.Build.MODEL", android.os.Build.MODEL);
    adapter.addItem("android.os.Build.PRODUCT", android.os.Build.PRODUCT);
    adapter.addItem("android.os.Build.VERSION.SDK", android.os.Build.VERSION.SDK);
    adapter.addItem("Build.VERSION.RELEASE", Build.VERSION.RELEASE);
    adapter.addItem("Build.VERSION.CODENAME", Build.VERSION.CODENAME);
    adapter.addItem("Build.VERSION.INCREMENTAL", Build.VERSION.INCREMENTAL);
    adapter.addItem("versionName", versionName);
    adapter.addItem("versionCode", versionCode);
  }

}
