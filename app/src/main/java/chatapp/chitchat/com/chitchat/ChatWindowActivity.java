package chatapp.chitchat.com.chitchat;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatWindowActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView userImage;
    private TextView userName, userStatus;
    private EditText chatMessage;
    private ImageView sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);


        chatMessage = findViewById(R.id.chat_window_chat_message);
        sendButton = findViewById(R.id.chat_window_send_message_btn);
        toolbar = findViewById(R.id.chat_window_toolbar);

        Intent homeIntent = getIntent();
        Bundle bd = homeIntent.getExtras();
        String userNameStr = bd.getString("USERS_NAME");
        int imageIdInt = bd.getInt("USER_IMAGE_ID");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Homeintent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(Homeintent);
            }
        });


        userName = (TextView)findViewById(R.id.chat_window_user_name);
        userImage = (ImageView)findViewById(R.id.chat_window_user_image);
        userStatus = (TextView)findViewById(R.id.chat_window_user_status);

        userName.setText(userNameStr);
        userImage.setImageResource(imageIdInt);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.chat_window_menu_items,menu);
        return true;
    }
}
