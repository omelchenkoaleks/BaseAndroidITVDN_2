package com.omelchenkoaleks.baseandroiditvdn_2.register_or_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

import java.util.List;

public class RegisterOrLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    private CheckBox mCheckBox;
    private TextView mPressNameTextView; // подгружаем при влюченном checkbox
    private EditText mTextNameEditText; // подгружаем при влюченном checkbox
    private FrameLayout mAdditionTextFrameLayout;
    private FrameLayout mAdditionFieldFrameLayout;
    private Button mLoginButton;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_or_login);

        mLoginEditText = findViewById(R.id.login_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mCheckBox = findViewById(R.id.check_box);
        mAdditionTextFrameLayout = findViewById(R.id.addition_text);
        mAdditionFieldFrameLayout = findViewById(R.id.addition_field);
        mLoginButton = findViewById(R.id.login_button);
        mResultTextView = findViewById(R.id.result_text_view);

        // программное создание view
        mPressNameTextView = new TextView(this);
        mPressNameTextView.setText(getString(R.string.press_name_text_view));
        mTextNameEditText = new EditText(this);
        mTextNameEditText.setEms(10);
        mTextNameEditText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mCheckBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mResultTextView.setText(R.string.empty_text);

        if (mCheckBox.isChecked()) {
            // пример динамического добавления view
            mAdditionFieldFrameLayout.addView(mTextNameEditText);
            mAdditionTextFrameLayout.addView(mPressNameTextView);
            mLoginButton.setText(getString(R.string.register_text));
        } else {
            mAdditionTextFrameLayout.removeView(mPressNameTextView);
            mAdditionFieldFrameLayout.removeView(mTextNameEditText);
            mLoginButton.setText(getString(R.string.login_text));
        }
    }

    public void loginOnClick(View view) {
        // получаем данные из EditText, введенные пользователем
        String loginText = mLoginEditText.getText().toString();
        String passwordText = mPasswordEditText.getText().toString();

        if (mCheckBox.isChecked()) {
            // получаем данные из EditText, введенные пользователем на регистрации
            String nameText = mTextNameEditText.getText().toString();
            register(nameText, loginText, passwordText);
        } else {
            login(loginText, passwordText);
        }
    }

    private void register(String name, String login, String password) {
        User user = new User(name, login, password);
        List<User> users = User.getAllUsers();

        // проверка = если такого юзера не содержится
        if (!users.contains(user)) {
            User.getAllUsers().add(user);
            mResultTextView.setText("Registration successful " + user.getName() + " registered");
        } else {
            Toast.makeText(this, "This user is exists!  :(", Toast.LENGTH_SHORT).show();
        }
    }

    private void login(String login, String password) {
        User user = new User(null, login, password);
        List<User> users = User.getAllUsers();

        if (users.contains(user)) {
            User currentUser = getUser(user.getLogin(), users);
            checkPassword(password, currentUser);
        } else {
            Toast.makeText(this, "User not registered", Toast.LENGTH_SHORT).show();
        }
    }

    private User getUser(String login, List<User> users) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    private void checkPassword(String password, User user) {
        if (password.equals(user.getPassword())) {
            goToUserActivity("Hello " + user.getName());
        } else {
            Toast.makeText(this, "Uncorrect password", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToUserActivity(String message) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
