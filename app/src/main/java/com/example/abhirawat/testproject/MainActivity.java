package com.example.abhirawat.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abhirawat.testproject.com.novo.interfaces.LoginViewInterface;
import com.example.abhirawat.testproject.com.novo.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginViewInterface, View.OnClickListener{
private EditText edUsername,edPassword;
private Button btnLogin;
private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);


    }

    @Override
    public String getUsername() {
        return edUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return edPassword.getText().toString();    }

    @Override
    public void showErrorWhenUsernameIsEmpty(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showErrorWhenPasswordIsEmpty(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showErrorWhenIncorrectDetails(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showOnSucess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLogin:
                loginPresenter.onLoginButtonClicked();
                break;


        }


    }
}
