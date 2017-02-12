package com.example.dudco.chatex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dudco.chatex.Adapter.ChatingListAdapter;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ListView chatingList;
    private List<JSONObject> items = new ArrayList<>();
    private ChatingListAdapter chat_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        String name = getIntent().getStringExtra("name");
        Toolbar toolbar = (Toolbar) findViewById(R.id.chat_toolbar);
        //custom toolbar
        View custom_toolbar = LayoutInflater.from(this).inflate(R.layout.custom_toolbar, null);
        TextView name_view = (TextView) custom_toolbar.findViewById(R.id.c_toolbar_text);
        custom_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        name_view.setText(name);

        setSupportActionBar(toolbar);
        //don't show toolbar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setCustomView(custom_toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        //chat
        chatingList = (ListView) findViewById(R.id.chat_list);
        chatingList.setFooterDividersEnabled(false);
        chatingList.setHeaderDividersEnabled(false);
        chatingList.setDividerHeight(0);
        chat_adapter = new ChatingListAdapter(this, items);
        chatingList.setAdapter(chat_adapter);

        //socket
        mSocket.connect();
        findViewById(R.id.chat_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.chat_edit);
                String msg = edit.getText().toString();
                mSocket.emit("chat message", msg);
                JSONObject json = new JSONObject();
                try {
                    json.put("who", "me");
                    json.put("msg", msg);
                    addChat(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                edit.setText("");
            }
        });
        mSocket.on("send message", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                JSONObject json = new JSONObject();
                try {
                    Log.d("dudco", data.getString("msg"));
                    json.put("who", "other");
                    json.put("msg", data.getString("msg"));
                    addChat(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addChat(JSONObject json) {
        items.add(json);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                chat_adapter.notifyDataSetChanged();
            }
        });
    }

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://nh.applepi.kr");
        } catch (URISyntaxException e) {}
    }


}
