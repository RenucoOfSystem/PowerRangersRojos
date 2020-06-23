package com.nicolegongora.progra3_proyecto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicolegongora.progra3_proyecto.R;
import com.nicolegongora.progra3_proyecto.model.MainMenuEmployer;

import java.util.List;

public class MainMenuEmployeeAdapter extends BaseAdapter{



    private Context context;
    private List<MainMenuEmployer> item;

    public MainMenuEmployeeAdapter(Context context, List<MainMenuEmployer> item){
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return this.item.size();
    }

    @Override
    public Object getItem(int position) {
        return this.item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.item.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_mainmenuemployee,null);
            viewHolder.mainMenuUsername_id = view.findViewById(R.id.mainMenuUserName1_id);
            viewHolder.mainMenuImage_id = view.findViewById(R.id.mainMenuImage1_id);
            viewHolder.mainMenuDescription_id = view.findViewById(R.id.mainMenuDescription1_id);
            viewHolder.mainMenuEdit_id = view.findViewById(R.id.mainMenuEdit_id);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();

        }
        MainMenuEmployer task = this.item.get(position);
        viewHolder.mainMenuUsername_id.setText(task.getMainMenuUserName_id());
        viewHolder.mainMenuImage_id.setImageResource(task.getMainMenuImage_id());
        viewHolder.mainMenuDescription_id.setText(task.getMainMenuDescription_id());
        viewHolder.mainMenuEdit_id.setImageResource(task.getMainMenuEdit_id());
        return view;
    }

    static class ViewHolder{
        TextView mainMenuUsername_id;
        ImageView mainMenuImage_id;
        TextView mainMenuDescription_id;
        ImageView mainMenuEdit_id;

    }
}