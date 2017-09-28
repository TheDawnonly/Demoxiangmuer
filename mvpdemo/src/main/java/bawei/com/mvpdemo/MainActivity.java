package bawei.com.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText mainUsername;
    private EditText mainPassword;
    private Button mainBtn;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mainUsername = (EditText) findViewById(R.id.main_username);
        mainPassword = (EditText) findViewById(R.id.main_password);
        mainBtn = (Button) findViewById(R.id.main_btn);
        presenter = new MainActivityPresenter(this);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mainUsername.getText().toString().trim();
                String password = mainPassword.getText().toString().trim();
                presenter.login(username, password);
            }
        });
    }

    @Override
    public void usernameNull() {
        Toast.makeText(this, "usernameNull", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordNull() {
        Toast.makeText(this, "passwordNull", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "loginSuccess", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
