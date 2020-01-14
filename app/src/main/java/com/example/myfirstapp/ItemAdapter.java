package com.example.myfirstapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

  private ArrayList<String> keys;
  private ArrayList<String> values;
  private LayoutInflater inflater;

  ItemAdapter(Context context) {
    keys = new ArrayList<>();
    values = new ArrayList<>();
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return keys.size();
  }

  @Override
  public Object getItem(int position) {
    return keys.get(0);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  public void addItem(String key, String value) {
    keys.add(key);
    values.add(value);
    notifyDataSetChanged();
  }

  @Override
  public View getView(int index, View view, ViewGroup parent) {
    if (view == null) {
      view = inflater.inflate(R.layout.item_adapter, parent, false);
    }
    TextView key = view.findViewById(R.id.key);
    TextView value = view.findViewById(R.id.value);
    key.setText(keys.get(index));
    value.setText(values.get(index));
    Log.i("ItemAdapter", keys.get(index)+" => "+values.get(index));
    return view;
  }
}
