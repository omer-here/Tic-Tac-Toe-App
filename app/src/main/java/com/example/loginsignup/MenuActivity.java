package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button singleBtn;
    Button multiBtn;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

//        String info = getIntent().getStringExtra("LoginInfo");
//        Toast.makeText(MenuActivity.this, info, Toast.LENGTH_SHORT).show();

        singleBtn = findViewById(R.id.single);
        multiBtn = findViewById(R.id.multi);

        singleBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SinglePlayer.class);
                intent.putExtra("GameType", "singleplayer");
                startActivity(intent);
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SinglePlayer.class);
                intent.putExtra("GameType", "multiplayer");
                startActivity(intent);
            }
        });
    }
}
