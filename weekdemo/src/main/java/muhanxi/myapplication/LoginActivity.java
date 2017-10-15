package muhanxi.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muhanxi.myapplication.presenter.LoginActivityPresenter;
import muhanxi.myapplication.view.LoginActivityViewListener;

public class LoginActivity extends Activity implements LoginActivityViewListener {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    private LoginActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        presenter = new LoginActivityPresenter(this);



    }

    @OnClick(R.id.login)
    public void onClick() {

        presenter.login(username.getText().toString().trim(),password.getText().toString().trim());


    }

    @Override
    public void success(Object object) {

        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onfailed() {

    }
}
