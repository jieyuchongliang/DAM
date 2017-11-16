package info.chenghuan.com.dam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.bean.ShowBean;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class ShowFragmentAdapter extends BaseAdapter {

    private Context mContext;
    private List<ShowBean.RowsBean> mData;

    public ShowFragmentAdapter(Context mContext, List<ShowBean.RowsBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public void setmData(List<ShowBean.RowsBean> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        if (mData == null) {
            return null;
        }
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder;
        if (convertView == null) {
            holder = new MyHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_show_ring_info, parent, false);
            holder.tsid = (TextView) convertView.findViewById(R.id.tv_list_tsid);
            holder.ringNumber = (TextView) convertView.findViewById(R.id.tv_list_ring_num);
            holder.distance = (TextView) convertView.findViewById(R.id.tv_list_distance);
            holder.status = (TextView) convertView.findViewById(R.id.tv_list_status);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        holder.tsid.setText(mData.get(position).getTsId());
        holder.ringNumber.setText(mData.get(position).getRingId());
        holder.distance.setText(mData.get(position).getDistance());
        switch (mData.get(position).getStatus()) {
            case 0:
                holder.status.setText("正常");
                break;
            case 1:
                holder.status.setText("破损");
                break;
            case 2:
                holder.status.setText("开裂");
                break;
            case 3:
                holder.status.setText("渗漏水");
                break;
            case 4:
                holder.status.setText("错台");
                break;
        }

        return convertView;
    }

    class MyHolder {
        private TextView tsid,ringNumber, distance, status;
    }
}
