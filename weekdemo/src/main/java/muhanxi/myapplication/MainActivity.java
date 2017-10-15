package muhanxi.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import muhanxi.myapplication.bean.Bean;
import muhanxi.myapplication.presenter.MainActivityPresenter;
import muhanxi.myapplication.view.MainActivityViewListener;


/**
 * okhttp + recycleview + mvp
 * login + mvp
 * mvp
 *  activity  充当View
 *  presenter
 *  Model ＋
 */


public class MainActivity extends Activity implements MainActivityViewListener{

    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.springview)
    SpringView springview;
    private MainActivityPresenter presenter;
    private IAdapter adapter;
    private StaggeredGridLayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        springview.setHeader(new MeituanHeader(this));
        springview.setFooter(new MeituanFooter(this));

        presenter = new MainActivityPresenter(this);


        manager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recycleview.setLayoutManager(manager);


        adapter = new IAdapter(this);

        recycleview.setAdapter(adapter);

        HorizontalDividerItemDecoration  horizontalDividerItemDecoration =  new HorizontalDividerItemDecoration.Builder(this)
                .color(Color.RED)
//                .sizeResId(R.dimen.divider)
//                .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                .build() ;
        //分割线
        recycleview.addItemDecoration(horizontalDividerItemDecoration);

        presenter.getData(true);


        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {

                presenter.getData(true);



            }

            @Override
            public void onLoadmore() {
                presenter.getData(true);

            }
        });

    }

    @Override
    public void callBackSuccess(final Bean bean) {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter.setData(bean);
                springview.onFinishFreshAndLoad();

            }
        });



    }

    @Override
    public void callBackFailure(int code) {

    }
}
