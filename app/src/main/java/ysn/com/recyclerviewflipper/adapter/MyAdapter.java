package ysn.com.recyclerviewflipper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ysn.com.recyclerviewflipper.R;

/**
 * @Author yangsanning
 * @ClassName MyAdapter
 * @Description 一句话概括作用
 * @Date 2019/6/3
 * @History 2019/6/3 author: description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private List<String> data;
    private int size;
    private LayoutInflater inflate;

    public MyAdapter(List<String> data, Context context) {
        this.data = data;
        size = this.data.size();
        inflate = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflate.inflate(R.layout.item_my, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String text = data.get(position % size);
        holder.textView.setText(text);
        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
            Log.d("test", data.get(position % size));
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;

        MyHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.my_item_text);
        }
    }
}
