package adapter.smart.com.smartadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class MutSmartRecyclerAdapter<T> extends RecyclerView.Adapter<SmartRecyclerHolder> {

    private Context context;
    private List<T> list;
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private OnItemLongClickListener longClickListener;
    private RecyclerView recyclerView;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView parent, View view, int position);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(RecyclerView parent, View view, int position);
    }

    public MutSmartRecyclerAdapter(Context context,  List<T> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SmartRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(getItemLayout(viewType,list.get(viewType)), parent, false);
        return SmartRecyclerHolder.getRecyclerHolder(context, view);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final SmartRecyclerHolder holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null && view != null && recyclerView != null) {
                    int position = recyclerView.getChildAdapterPosition(view);
                    listener.onItemClick(recyclerView, view, position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (longClickListener != null && view != null && recyclerView != null) {
                    int position = recyclerView.getChildAdapterPosition(view);
                    longClickListener.onItemLongClick(recyclerView, view, position);
                    return true;
                }
                return false;
            }
        });
        convert(holder, list.get(position), position,getItemLayout(position,list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
    public abstract void convert(SmartRecyclerHolder holder, T item, int position,int itemId);
    public abstract int getItemLayout(int position,T paramT);
}
