package adapter.smart.com.smartadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class MutSmartAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public MutSmartAdapter(Context paramContext, List<T> paramList) {
        this.mContext = paramContext;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mDatas = paramList;
    }

    private SmartViewHolder getViewHolder(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return SmartViewHolder.get(this.mContext, paramView, paramViewGroup, getItemLayout(paramInt,getItem(paramInt)), paramInt,false);
    }
    public abstract int getItemLayout(int positon,T paramT);
    public abstract void convert(SmartViewHolder paramViewHolder, T paramT, int position,int itemId);

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
        convert(viewHolder, getItem(paramInt), paramInt,getItemLayout(paramInt,getItem(paramInt)));
        return viewHolder.getConvertView();
    }
}