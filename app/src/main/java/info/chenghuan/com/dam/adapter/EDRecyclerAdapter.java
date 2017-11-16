package info.chenghuan.com.dam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.bean.EveryDuctBean;
import info.chenghuan.com.dam.utils.Base64Util;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class EDRecyclerAdapter extends RecyclerView.Adapter<EDRecyclerAdapter.MyViewHolder> {
    private List<EveryDuctBean.PieceListBean.RowsBean> mList;
    private Context mContext;

    public EDRecyclerAdapter(List<EveryDuctBean.PieceListBean.RowsBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public void setmList(List<EveryDuctBean.PieceListBean.RowsBean> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_every_duct_beifen,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (mList != null){
            holder.number.setText(mList.get(position).getRingNum());
            holder.projectName.setText(mList.get(position).getProjectName());
            holder.productNum.setText(mList.get(position).getManufacturingRingCode());
            holder.ductType.setText(mList.get(position).getPieceType());
            Log.i(TAG, "onBindViewHolder: " + mList.get(position).getQrPath());
            Bitmap bitmap = Base64Util.base64ToBitmap(mList.get(position).getQrPath());
            holder.imageView.setImageBitmap(bitmap);
//            Glide.with(mContext).load(mList.get(position).getUrl()).into(holder.url);
        }
    }

    private static final String TAG = "EDRecyclerAdapter";

    @Override
    public int getItemCount() {
        if (mList!=null) {
            return mList.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView number,projectName,productNum,productUnit,ductType;
        private ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.number);
            projectName = (TextView) itemView.findViewById(R.id.project_name);
            productNum = (TextView) itemView.findViewById(R.id.product_number);
            productUnit = (TextView) itemView.findViewById(R.id.product_unit);
            ductType = (TextView) itemView.findViewById(R.id.duct_type);
            imageView = (ImageView) itemView.findViewById(R.id.url);
        }
    }
}
