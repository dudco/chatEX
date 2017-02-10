package com.example.dudco.chatex.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.dudco.chatex.FriendListAdapter;
import com.example.dudco.chatex.R;
import com.example.dudco.chatex.User;

import java.util.ArrayList;
import java.util.List;

public class FriendFragment extends Fragment {
    private EditText friend_edit;
    private RecyclerView friend_list;
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
        friend_list = (RecyclerView) view.findViewById(R.id.friend_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        friend_list.setLayoutManager(layoutManager);

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
        return view;
    }


}
