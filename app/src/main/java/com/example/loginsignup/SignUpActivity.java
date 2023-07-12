package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.loginsignup.databinding.SignupPageBinding;

import androidx.appcompat.app.AppCompatActivity;


public class SignUpActivity extends AppCompatActivity {
    EditText usernameS;
    EditText passwordS;
    Button loginButtonS;

    String User;
    String Pass;

    TextView ts;

    SignupPageBinding binding;
    DataBaseHelper databaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupPageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        databaseHelper = new DataBaseHelper(this);


  //////////////////////////////////////////////////////////////////////////////
//        usernameS = findViewById(R.id.usernameS);
//        passwordS = findViewById(R.id.passwordS);
//        loginButtonS = findViewById(R.id.signupButton);
//        ts = findViewById(R.id.loginText);
//
//        loginButtonS.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                User = usernameS.getText().toString();
//                Pass = passwordS.getText().toString();
//
//                Toast.makeText(SignUpActivity.this, User, Toast.LENGTH_SHORT).show();
//                Toast.makeText(SignUpActivity.this, Pass, Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//        ts.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    //////////////////////////////////////////////////////////////////////////////////
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.usernameS.getText().toString();
                String password = binding.passwordS.getText().toString();
                String confirmPassword = binding.confirmPassword.getText().toString();
                if(email.equals("")||password.equals("")||confirmPassword.equals(""))
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(confirmPassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);
                        if(checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email, password);
                            if(insert == true){
                                Toast.makeText(SignUpActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                binding.usernameS.setText("");
                                binding.passwordS.setText("");
                                binding.confirmPassword.setText("");
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);    //remember to change
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUpActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUpActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        binding.loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
