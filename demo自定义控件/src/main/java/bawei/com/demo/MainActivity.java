package bawei.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //创建自定义控件
    private TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化自定义控件
        topBar = (TopBar) findViewById(R.id.topbar);

        //为自定义控件添加按钮的监听事件
        topBar.setOnTopBarBtnsClick(new TopBar.TopBarBtnsOnClickListener() {
            @Override
            public void leftBtnOnClick() {
                Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightBtnOnClick() {
                Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
