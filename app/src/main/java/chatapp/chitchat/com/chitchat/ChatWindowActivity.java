package chatapp.chitchat.com.chitchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ChatWindowActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        Intent homeIntent = getIntent();
        Bundle bd = homeIntent.getExtras();
        String userName = bd.getString("USERS_NAME");
        toolbar = findViewById(R.id.chat_window_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(userName);

    }
}
