package com.nicolegongora.progra3_proyecto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nicolegongora.progra3_proyecto.R;
import com.nicolegongora.progra3_proyecto.model.RegisButton;

import java.util.List;

public class OptionAdapter extends BaseAdapter {
    private Context context;
    private List<RegisButton> options;

    public OptionAdapter(Context context, List<RegisButton> options) {
        this.context = context;
        this.options = options;
    }

    @Override
    public int getCount() {
        return this.options.size();
    }

    @Override
    public Object getItem(int position) {
        return this.options.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.options.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.register_button_layout, null);
        vh.nameTextView=convertView.findViewById(R.id.nameTextView);
        vh.iconImageView=convertView.findViewById(R.id.iconImageView);
        RegisButton rg=this.options.get(position);
        vh.nameTextView.setText(rg.getName());
        vh.iconImageView.setImageResource(rg.getImage());
        return convertView;
    }

    static class ViewHolder {
        TextView nameTextView;
        ImageView iconImageView;
    }

}
