package com.example.dudco.chatex.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dudco.chatex.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by dudco on 2017. 2. 12..
 */

public class ChatingListAdapter extends BaseAdapter {
    private List<JSONObject> items;
    private Context context;

    public ChatingListAdapter(Context context, List<JSONObject> items) {
        this.items = items;
        this.context = context;
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JSONObject item = items.get(position);
        Drawable backgroud = null;
        String msg = "";
        View view = LayoutInflater.from(context).inflate(R.layout.chat, null);
        LinearLayout container = (LinearLayout) view.findViewById(R.id.container);
        TextView chat_card = (TextView) view.findViewById(R.id.chat_box);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        try {
            if(item.getString("who").equals("me")){
                container.setGravity(Gravity.RIGHT);
                backgroud = context.getResources().getDrawable(R.drawable.chat_box_me, context.getTheme());

                msg = item.getString("msg");
            }else{
//                chat_card.setGravity(Gravity.LEFT);
                backgroud = context.getResources().getDrawable(R.drawable.chat_box_other, context.getTheme());
                msg = item.getString("msg");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        chat_card.setBackground(backgroud);
        chat_card.setText(msg);

//        parent.addView(container);
        return view;
    }
}
