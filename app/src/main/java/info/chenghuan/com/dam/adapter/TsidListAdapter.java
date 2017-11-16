package info.chenghuan.com.dam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.base.LVBaseAdapter;
import info.chenghuan.com.dam.bean.ProjectInfoBean;

/**
 * Created by 860617010 on 2017/11/6.
 */

public class TsidListAdapter extends LVBaseAdapter<ProjectInfoBean.RowsBean> {

    public TsidListAdapter(Context context, List<ProjectInfoBean.RowsBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_show_tsid, parent, false);
            holder = new MyHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.tv_show_tsid);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getWorksiteName());
        return convertView;
    }

    class MyHolder {
        private TextView textView;
    }
}
