package muhanxi.myapplication.model;

import muhanxi.myapplication.bean.Bean;

/**
 * Created by muhanxi on 17/10/14.
 */

public interface MainActivityModelListener {


    public void callBackSuccess(Bean bean);
    public void callBackFailure(int code);


}
