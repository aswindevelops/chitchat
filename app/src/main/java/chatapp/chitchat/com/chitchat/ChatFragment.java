package chatapp.chitchat.com.chitchat;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private RecyclerView chat_list_recyclerview;
    private List<ChatRow> chatlist = new ArrayList<>();
    private ChatListAdapter chatListAdapter;


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        chat_list_recyclerview =(RecyclerView) rootView.findViewById(R.id.home_chat_recyclerview);
        chatListAdapter = new ChatListAdapter(chatlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        chat_list_recyclerview.setLayoutManager(mLayoutManager);
        chat_list_recyclerview.setItemAnimator(new DefaultItemAnimator());
       // chat_list_recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        chat_list_recyclerview.setAdapter(chatListAdapter);

        chatListAdapter.setOnItemClickListener(new ChatListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
               String str = chatlist.get(position).getName();
                Intent chatWindowIntent = new Intent(getContext(),ChatWindowActivity.class);
                chatWindowIntent.putExtra("USERS_NAME",chatlist.get(position).getName());
                chatWindowIntent.putExtra("USER_IMAGE_ID",chatlist.get(position).getImageId());
                startActivity(chatWindowIntent);

            }
        });

        chatlist.clear();
        prepareChatList();

        return rootView;
    }

    private void prepareChatList() {
        ChatRow chatRow = new ChatRow("Robert Downey","i am iron-man","11:30AM",R.drawable.rdjr);
        chatlist.add(chatRow);
        chatRow = new ChatRow("Chris Hemsworth","bring me thanos","12:01AM",R.drawable.chths);
        chatlist.add(chatRow);
        chatListAdapter.notifyDataSetChanged();
    }

}
