package info.chenghuan.com.dam.base;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 860617010 on 2017/11/1.
 */

public abstract class LVBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> list;

    public LVBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list!= null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list!= null){
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
