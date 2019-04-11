package com.example.xqq407.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xqq407.R;
import com.example.xqq407.entity.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultBean> showdata;


    public ShowAdapter(Context context, List<ShowBean.ResultBean> showdata) {
        this.context = context;
        this.showdata = showdata;
    }

    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.simp_img.setImageURI(showdata.get(i).getImageUrl());
        viewHolder.title.setText(showdata.get(i).getName());
        viewHolder.price.setText(showdata.get(i).getRank()+"");
        //点击条目
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click!=null){
                    click.OnClick(showdata.get(i).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return showdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simp_img;
        private final TextView title;
        private final TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simp_img = itemView.findViewById(R.id.simp_img);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
    private Click click;


    public void setClick(Click click){
        this.click=click;
    }
    public interface Click{
        void OnClick(int id);
    }
}
