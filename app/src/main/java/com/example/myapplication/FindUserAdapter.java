package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class FindUserAdapter extends BaseAdapter {

    Context mContext = null;
    ArrayList<Users> mData = null;
    LayoutInflater mLayoutInflater = null;

    public FindUserAdapter(Context context, ArrayList<Users> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from((mContext));
    }

    public int getCount() {
        return mData.size();
    }

    public long getItemId(int position) {
        return position;
    }

    public Users getItem(int position) {
        return mData.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View itemLayout = mLayoutInflater.inflate(R.layout.find_user_content, null);

        TextView user_name = (TextView) itemLayout.findViewById(R.id.find_user_name);
        TextView user_text = (TextView) itemLayout.findViewById(R.id.find_user_text);

        user_name.setText(mData.get(position).mUserName);
        user_text.setText(mData.get(position).mtext);
        return itemLayout;
    }
}
