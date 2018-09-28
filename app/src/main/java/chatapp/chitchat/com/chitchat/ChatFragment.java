package chatapp.chitchat.com.chitchat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        prepareChatList();

        return rootView;
    }

    private void prepareChatList() {
        ChatRow chatRow = new ChatRow("Aswin Manoharan1","this is the last message","11:30AM",R.drawable.rdjr);
        chatlist.add(chatRow);
        chatRow = new ChatRow("Aswinn Manohar","last message can be anything","12:01AM",R.drawable.chths);
        chatlist.add(chatRow);
        chatListAdapter.notifyDataSetChanged();
    }

}
