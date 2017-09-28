package bawei.com.mvpdemo;

import android.text.TextUtils;

/**
 * Created by Mr.周 on 2017/9/28.
 */

public class MainActivityPresenter {
    private LoginView loginView;
    private MainActivityModel mainActivityModel;

    public MainActivityPresenter(LoginView loginView) {
        this.loginView = loginView;
        this.mainActivityModel = new MainActivityModel();
    }

    public void login(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            loginView.usernameNull();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            loginView.passwordNull();
            return;
        }
        mainActivityModel.login(username, password, new MainActivityModel.ModelListener() {
            @Override
            public void loginSuccess(String result) {
                loginView.loginSuccess(result);
            }
        });
    }

    public void detach() {
        loginView = null;
    }
}
