package com.example.joseph.cardviewer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joseph on 2015-10-07.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    private LayoutInflater inflater;
    private List<Object> list;

    public ListAdapter(Activity activity, List<Object> list){
        inflater = activity.getLayoutInflater();
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.setContent(list.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        Object thing = list.get(position);
        if( thing instanceof String)
            return R.layout.list_item;
        return R.layout.error_item;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListViewHolder holder;
        if(viewType == R.layout.list_item)
            holder = new ButtonViewHolder(inflater.inflate(viewType, parent, false));
        else holder = new ErrorViewHolder(inflater.inflate(viewType, parent, false));
        return holder;
    }




    public abstract class ListViewHolder<T> extends RecyclerView.ViewHolder{

        public ListViewHolder(View itemView) {
            super(itemView);
        }

        abstract void setContent(T thing);
    }

    public class ButtonViewHolder extends ListViewHolder<String>{
        private TextView textView;

        public ButtonViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }


        public void setContent(String str) {
            textView.setText(str);
        }
    }

    public class ErrorViewHolder extends ListViewHolder<Object>{

        public ErrorViewHolder(View itemView){
            super(itemView);
        }

        @Override
        void setContent(Object thing) {
        }
    }
}
