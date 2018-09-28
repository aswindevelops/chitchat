package chatapp.chitchat.com.chitchat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder> {
    private List<ChatRow> chatlist;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView, lastMessageView, timeView;
        private ImageView userImageView;

        public  MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            nameView = (TextView)itemView.findViewById(R.id.home_chat_recyclerview_row);
            lastMessageView = (TextView)itemView.findViewById(R.id.home_chat_last_message);
            timeView = (TextView)itemView.findViewById(R.id.home_chat_time);
            userImageView = (ImageView)itemView.findViewById(R.id.home_chat_user_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ChatListAdapter(List<ChatRow> chatlist){
            this.chatlist = chatlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_row_layout,parent,false);
        return new MyViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChatRow chatRow = chatlist.get(position);
        holder.nameView.setText(chatRow.getName());
        holder.lastMessageView.setText(chatRow.getLastMessage());
        holder.timeView.setText(chatRow.getTime());
        holder.userImageView.setImageResource(chatRow.getImageId());
    }

    @Override
    public int getItemCount() {
        return chatlist.size();
    }
}
