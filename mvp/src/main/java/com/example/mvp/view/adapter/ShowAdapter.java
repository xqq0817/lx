package com.example.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.model.bean.GoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private Context context;
    private List<GoodsBean.ResultBean.MlssBean.CommodityListBeanXX> mlssdata;

    public ShowAdapter(Context context, List<GoodsBean.ResultBean.MlssBean.CommodityListBeanXX> mlssdata) {
        this.context = context;
        this.mlssdata = mlssdata;
    }

    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder viewHolder, int i) {
        viewHolder.simp_img.setImageURI(mlssdata.get(i).getMasterPic());
        viewHolder.title.setText(mlssdata.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return mlssdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simp_img;
        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simp_img = itemView.findViewById(R.id.simp_img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
