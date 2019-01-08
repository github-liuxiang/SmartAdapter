package adapter.smart.com.smartadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SmartViewHolder
{
  private View mConvertView;
  private int mPosition;
  private final SparseArray<View> mViews;

  private SmartViewHolder(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.mPosition = paramInt2;
    this.mViews = new SparseArray();
    this.mConvertView = LayoutInflater.from(paramContext).inflate(paramInt1, paramViewGroup, false);
    this.mConvertView.setTag(this);
  }
    private SmartViewHolder(Context paramContext, ViewGroup paramViewGroup, View view, int paramInt2)
    {
        this.mPosition = paramInt2;
        this.mViews = new SparseArray();
        this.mConvertView = view;
        this.mConvertView.setTag(this);
    }
  public static SmartViewHolder get(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2, boolean isnodata)
  {
    if (isnodata){
      if (paramView != null && paramView instanceof LinearLayout){
        return (SmartViewHolder)paramView.getTag();
      }else{
        return new SmartViewHolder(paramContext, paramViewGroup, paramInt1, paramInt2);
      }
    }
    if (paramView == null) {
      return new SmartViewHolder(paramContext, paramViewGroup, paramInt1, paramInt2);
    }
    return (SmartViewHolder)paramView.getTag();
  }
    public static SmartViewHolder get(Context paramContext, View paramView, ViewGroup paramViewGroup, View view, int paramInt2)
    {
        if (paramView == null) {
            return new SmartViewHolder(paramContext, paramViewGroup, view, paramInt2);
        }
        return (SmartViewHolder)paramView.getTag();
    }
  public View getConvertView()
  {
    return this.mConvertView;
  }

  public int getPosition()
  {
    return this.mPosition;
  }

  public <T extends View> T getView(int paramInt)
  {
    View localView2 = (View)this.mViews.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.mConvertView.findViewById(paramInt);
      this.mViews.put(paramInt, localView1);
    }
    return (T) localView1;
  }

  public SmartViewHolder setImageBitmap(int paramInt, Bitmap paramBitmap)
  {
    ((ImageView)getView(paramInt)).setImageBitmap(paramBitmap);
    return this;
  }

  public SmartViewHolder setImageByUrl(int paramInt, String paramString)
  {
    return this;
  }

  public SmartViewHolder setImageResource(int paramInt1, int paramInt2)
  {
    ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
    return this;
  }

  public SmartViewHolder setText(int paramInt, String paramString)
  {
    ((TextView)getView(paramInt)).setText(paramString);
    return this;
  }
}