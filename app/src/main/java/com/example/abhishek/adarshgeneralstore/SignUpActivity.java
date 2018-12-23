package com.example.abhishek.adarshgeneralstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText Name, Phone, Email, Password;
    private Button Register;
    private TextView Login;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    //Upload data to the database
                    String User_Email = Email.getText().toString().trim();

                    String User_Password = Password.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(User_Email,User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                         Toast.makeText(SignUpActivity.this, "Registeration Successful",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                        }else{
                                Toast.makeText(SignUpActivity.this, "Registeration Failed",Toast.LENGTH_SHORT).show();
                            }
                    });
                }

            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        }
    }

    private void setupUIViews() {
        Name = (EditText) findViewById(R.id.enName);
        Phone = (EditText) findViewById(R.id.enPhone);
        Email = (EditText) findViewById(R.id.enEmail);
        Password = (EditText) findViewById(R.id.enPass);
        Register = (Button) findViewById(R.id.rbt);
        Login = (TextView) findViewById(R.id.ack);
    }

    private Boolean validate() {
        Boolean result = false;

        String name1 = Name.getText().toString();
        String email1 = Email.getText().toString();
        String password1 = Password.getText().toString();
        String phone1 = Phone.getText().toString();
        if (name1.isEmpty() || password1.isEmpty() || email1.isEmpty() || phone1.isEmpty()) {
            Toast.makeText(this, "Enter All Details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}