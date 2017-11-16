package info.chenghuan.com.dam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import info.chenghuan.com.dam.R;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class ShowPhotoAdapter extends RecyclerView.Adapter<ShowPhotoAdapter.MyHolder> {
    private Context context;
    private List<Bitmap> bitmapList;


    public ShowPhotoAdapter(Context context, List<Bitmap> bitmapList) {
        this.context = context;
        this.bitmapList = bitmapList;
    }

    public void setBitmapList(List<Bitmap> bitmapList) {
        this.bitmapList = bitmapList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_show_photo,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.ivShowPhoto.setImageBitmap(bitmapList.get(position));
    }

    @Override
    public int getItemCount() {
        return bitmapList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private ImageView ivShowPhoto;
        public MyHolder(View itemView) {
            super(itemView);
            ivShowPhoto = (ImageView) itemView.findViewById(R.id.iv_show_photo);
        }
    }
}
