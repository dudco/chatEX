package com.example.dudco.chatex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dudco.chatex.Datas.User;

import java.util.List;

/**
 * Created by dudco on 2017. 2. 10..
 */

public class FriendListAdapter extends BaseAdapter{
    private Context context;
    private List<User> items;

    public FriendListAdapter(Context context, List<User> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(position == 0){
            view = LayoutInflater.from(context).inflate(R.layout.search, null);
        }else if(position == 1 || position == 3){
            view = LayoutInflater.from(context).inflate(R.layout.text, null);
            TextView text = (TextView) view.findViewById(R.id.text_text);

            String _text = position == 1 ? "내 프로필" : "친구";
            text.setText(_text);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.item_profileview, null);
            TextView name = (TextView) view.findViewById(R.id.profile_text);
            name.setText(items.get(position).getName());
        }
        return view;
    }

}