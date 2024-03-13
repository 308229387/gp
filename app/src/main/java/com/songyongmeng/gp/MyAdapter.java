package com.songyongmeng.gp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.ToolUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> data; // 数据列表
    private Context context;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = data.get(position);
        if(item.startsWith("title:")){
            holder.titleView.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.GONE);
            holder.titleView.setText(item.replace("title:", ""));
        }else if(item.startsWith("text:")){
            holder.titleView.setVisibility(View.GONE);
            holder.textView.setVisibility(View.VISIBLE);
            holder.imageView.setVisibility(View.GONE);
            holder.textView.setText(item.replace("text:", ""));
        }else if(item.startsWith("image:")){
            holder.titleView.setVisibility(View.GONE);
            holder.textView.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.VISIBLE);
            String image = Constants.COMMON_IMG_NAME+"/"+item.replace("image:", "");
            Glide.with(context).load(AssetsUtils.getBitmapFromAsset(context, image)).into(holder.imageView);
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context,BigImageActivity.class);
//                    intent.putExtra("image",id);
//                    context.startActivity(intent);
//                }
//            });
//
//            Glide.with(context).load(id).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title_text);
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
