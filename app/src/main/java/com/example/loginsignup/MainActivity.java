package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.loginsignup.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;

    TextView t;

    ActivityMainBinding binding;
    DataBaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DataBaseHelper(this);
    /////////////////////////////////////////////////////////////////////////////////////////
//        username = findViewById(R.id.username);
//        password = findViewById(R.id.password);
//
//        String savedUser = getString(R.string.user);
//        String savedPass = getString(R.string.password);
//        loginButton = findViewById(R.id.loginButton);
//        t = findViewById(R.id.signupText);
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                if (username.getText().toString().equals(savedUser) && password.getText().toString().equals(savedPass)) {
//                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
//                    intent.putExtra("LoginInfo", "successful");
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
//                }
////                String app_name = getResources().getString(R.string.app_name);
////                app_name = username.getText().toString();
////                Toast.makeText(MainActivity.this, app_name, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        t.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
//                startActivity(intent);
//            }
//        });
    ///////////////////////////////////////////////////////////////////////////////////////////////////

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                if(email.equals("")||password.equals(""))
                    Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);
                    if(checkCredentials == true){
                        Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        binding.password.setText("");
                        Intent intent  = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        binding.signupRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}