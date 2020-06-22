package com.nicolegongora.progra3_proyecto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicolegongora.progra3_proyecto.R;
import com.nicolegongora.progra3_proyecto.model.MainMenuTask;

import java.util.List;

public class MainMenuAdapter extends BaseAdapter {
    private Context context;
    private List<MainMenuTask> item;

    public MainMenuAdapter(Context contest, List<MainMenuTask> item){
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
            view = inflater.inflate(R.layout.activity_mainmenu,null);
            viewHolder.mainMenuUsername_id = view.findViewById(R.id.mainMenuUserName_id);
            viewHolder.mainMenuImage_id = view.findViewById(R.id.mainMenuImage_id);
            viewHolder.mainMenuDescription_id = view.findViewById(R.id.mainMenuDescription_id);
            viewHolder.mainMenuTy_id = view.findViewById(R.id.mainMenuTy_id);
            viewHolder.mainMenuShare_id = view.findViewById(R.id.mainMenuShare_id);
            viewHolder.mainMenuBookmark_id = view.findViewById(R.id.mainMenuBookmark_id);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();

        }
        MainMenuTask task = this.item.get(position);
        viewHolder.mainMenuUsername_id.setText(task.getMainMenuUserName_id());
        viewHolder.mainMenuImage_id.setImageResource(task.getMainMenuImage_id());
        viewHolder.mainMenuDescription_id.setText(task.getMainMenuDescription_id());
        viewHolder.mainMenuTy_id.setImageResource(task.getMainMenuTy_id());
        viewHolder.mainMenuShare_id.setImageResource(task.getMainMenuBookmark_id());
        viewHolder.mainMenuBookmark_id.setImageResource(task.getMainMenuShare_id());

        return view;
    }

    static class ViewHolder{
        TextView mainMenuUsername_id;
        ImageView mainMenuImage_id;
        TextView mainMenuDescription_id;
        ImageView mainMenuTy_id;
        ImageView mainMenuBookmark_id;
        ImageView mainMenuShare_id;


    }
}
