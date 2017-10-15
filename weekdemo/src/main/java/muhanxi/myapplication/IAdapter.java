package muhanxi.myapplication;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import muhanxi.myapplication.bean.Bean;
import muhanxi.myapplication.utils.Utils;

import static muhanxi.myapplication.utils.Utils.getDisplayInfomation;

/**
 * Created by muhanxi on 17/10/14.
 */

public class IAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Bean.ListBean> list ;
    private int itemWidth ;

    public IAdapter(Context context) {

        this.context = context;

        Point point =  Utils.getDisplayInfomation(context);

        itemWidth = point.x / 3 ;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter, parent, false);


        IViewHolder viewHolder = new IViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if(holder instanceof IViewHolder){

            IViewHolder iViewHolder = (IViewHolder)holder;




            //        float scale =  (float) itemWidth / (float) list.get(position).getPicWidth()  ;
//        params.width = itemWidth;
//        params.height = (int)( (float)scale * (float)list.get(position).getPicHeight()) ;

            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iViewHolder.adapterImageview.getLayoutParams() ;
            params.width = itemWidth ;
            int height =  new Random().nextInt(1000);
            params.height =  height < 300 ? 300 : height ;

            iViewHolder.adapterImageview.setLayoutParams(params);

            Glide.with(context).load(list.get(position).getPic()).into(iViewHolder.adapterImageview);







        }




    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public void setData(Bean bean){

        if(this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getList());
        notifyDataSetChanged();

    }


    static class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_imageview)
        ImageView adapterImageview;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }



}
