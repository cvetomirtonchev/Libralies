package com.example.tsvetomirtonchev.userwiki.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;
import com.example.tsvetomirtonchev.userwiki.ui.base.BaseActivity;
import com.example.tsvetomirtonchev.userwiki.ui.main.MainActivity;
import com.example.tsvetomirtonchev.userwiki.util.SharedPreferenceManager;

//1.1
public class LoginActivity extends BaseActivity implements LoginContract.View {
    //Data
    private LoginContract.Presenter mPresenter;
    //Views
    private EditText mUserIdET;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenter(this);
        initViews();
        setUpViews();
    }

    private void initViews() {
        mUserIdET = findViewById(R.id.login_id_et);
        mLoginButton = findViewById(R.id.login_button);
    }

    private void setUpViews() {
        mLoginButton.setOnClickListener(v -> {
            if (TextUtils.isEmpty(mUserIdET.getText().toString())) {
                Toast.makeText(this, "User id can not be empty", Toast.LENGTH_SHORT).show();
            } else {
                mPresenter.loginUser(mUserIdET.getText().toString());
                mLoginButton.setEnabled(false);
                mUserIdET.setEnabled(false);
            }
        });
    }

    @Override
    public void handleLogin(User user) {
        SharedPreferenceManager.getInstance(this).saveCurrentUser(user);
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void enableViews() {
        mLoginButton.setEnabled(true);
        mUserIdET.setEnabled(true);
    }
}

