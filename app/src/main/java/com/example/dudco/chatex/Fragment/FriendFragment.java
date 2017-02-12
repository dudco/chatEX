package com.example.dudco.chatex.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dudco.chatex.Adapter.FriendListAdapter;
import com.example.dudco.chatex.ChatActivity;
import com.example.dudco.chatex.Datas.User;
import com.example.dudco.chatex.R;

import java.util.ArrayList;
import java.util.List;

public class FriendFragment extends Fragment {
    private EditText friend_edit;
    private ListView friend_list;
    private FriendListAdapter listAdapter;
    private List<User> items = new ArrayList<>();
    public FriendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        friend_edit = (EditText) view.findViewById(R.id.friend_edit);
        friend_list = (ListView) view.findViewById(R.id.friend_list);

        items.add(new User("search"));
        items.add(new User("name"));
        items.add(new User("이름"));
        items.add(new User("friend"));

        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));
        items.add(new User("박태준"));

        listAdapter = new FriendListAdapter(getContext(), items);
        friend_list.setAdapter(listAdapter);

        friend_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = (TextView) view.findViewById(R.id.profile_text);
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                intent.putExtra("name",name.getText().toString());
                startActivity(intent);
            }
        });
        return view;
    }


}
