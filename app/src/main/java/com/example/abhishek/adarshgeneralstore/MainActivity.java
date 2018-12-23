package com.example.abhishek.adarshgeneralstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int c=3;
    private TextView uRegisteration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = (EditText)findViewById(R.id.eEmail);
        Password = (EditText)findViewById(R.id.ePass);
        Info = (TextView) findViewById(R.id.inf);
        Login = (Button)findViewById(R.id.lbt);
        uRegisteration = (TextView)findViewById(R.id.rbt)
        Info.setText("No. Of Attempt Remaining: 3");
Login.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
        validate(Email.getText().toString(),Password.getText().toString());
    }
});
uRegisteration.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
    }
});
    }
private void validate (String Email , String Password)
{
    if((Email == "Admin") && (Password == "Admin"))
    {        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
    startActivity(Intent);

}
else
    {
c--;
Info.setText("No. Of Attempt Remaining:"+ String.valueOf(c));
if(c==0)
{Login.setEnabled(false);
}
