package adapter.smart.com.smartadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class SmartAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected int mItemLayoutId;
    private View view;

    public SmartAdapter(Context paramContext, List<T> paramList, int paramInt) {
        this.mContext = paramContext;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mDatas = paramList;
        this.mItemLayoutId = paramInt;
    }

    public SmartAdapter(Context paramContext, List<T> paramList, View view) {
        this.mContext = paramContext;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mDatas = paramList;
        this.view = view;
    }

    private SmartViewHolder getViewHolder(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (view != null) {
            return SmartViewHolder.get(this.mContext, paramView, paramViewGroup, this.view, paramInt);
        } else {
            return SmartViewHolder.get(this.mContext, paramView, paramViewGroup, this.mItemLayoutId, paramInt,false);
        }
    }

    public abstract void convert(SmartViewHolder paramViewHolder, T paramT, int position);

    public int getCount() {
        return this.mDatas.size();
    }

    public T getItem(int paramInt) {
        return (T) this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {

        SmartViewHolder viewHolder = getViewHolder(paramInt, paramView, paramViewGroup);
        convert(viewHolder, getItem(paramInt), paramInt);
        return viewHolder.getConvertView();
    }
}