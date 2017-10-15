package muhanxi.myapplication.presenter;

import muhanxi.myapplication.bean.Bean;
import muhanxi.myapplication.model.MainActivityModel;
import muhanxi.myapplication.model.MainActivityModelListener;
import muhanxi.myapplication.view.MainActivityViewListener;

/**
 * Created by muhanxi on 17/10/14.
 */

public class MainActivityPresenter {


    private MainActivityViewListener listener;
    private MainActivityModel mainActivityModel;

    public MainActivityPresenter(MainActivityViewListener listener){

        this.listener = listener;
        this.mainActivityModel = new MainActivityModel();
    }


    public void getData(boolean up){

        mainActivityModel.getData(up, new MainActivityModelListener() {
            @Override
            public void callBackSuccess(Bean bean) {
                listener.callBackSuccess(bean);
            }

            @Override
            public void callBackFailure(int code) {
                listener.callBackFailure(code);
            }
        });

    }



}
