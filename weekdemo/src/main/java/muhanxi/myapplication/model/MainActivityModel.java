package muhanxi.myapplication.model;

import com.google.gson.Gson;

import java.io.IOException;

import muhanxi.myapplication.bean.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by muhanxi on 17/10/14.
 */

public class MainActivityModel {



    public void getData(boolean up,final MainActivityModelListener listener){


        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder().url("http://qhb.2dyt.com/Bwei/news?type=9&postkey=109rff1d1AK").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 1 网络
                listener.callBackFailure(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();


                Gson gson = new Gson();
                Bean bean =  gson.fromJson(result, Bean.class);

                listener.callBackSuccess(bean);


            }
        });


    }





}
