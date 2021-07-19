package com.masai.setiv_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText metEmail;
    private EditText metPassword;
    private Button mbnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        mbnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail() && isValidPassword()) {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("User-Mail", metEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        metEmail = findViewById(R.id.etEmail1);
        metPassword = findViewById(R.id.etPassword1);
        mbnConfirm = findViewById(R.id.BtnLogin);
        TextView mtvWelcome = findViewById(R.id.tvWel);
    }

    public boolean isValidEmail() {
        if (metEmail.getText().toString().length() > 1 &&
                metEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            metEmail.setError("Invalid Email");
            return false;
        }
    }

    public boolean isValidPassword() {
        if (metPassword.getText().toString().length() > 1) {
            return true;
        } else {
            metPassword.setError("Password is very short");
            return false;
        }
    }

}
