package bawei.com.mvpdemo;

/**
 * Created by Mr.周 on 2017/9/28.
 */

public interface LoginView {
    public void usernameNull();

    public void passwordNull();

    public void loginSuccess(String result);
}
