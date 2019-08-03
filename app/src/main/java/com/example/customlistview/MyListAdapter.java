package com.example.customlistview;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.customlistview.Hero;
import com.example.customlistview.R;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Hero> {

    List<Hero> heroList;

    Context context;

    int resources;


    public MyListAdapter(Context context, int resource, List<Hero> heroList) {
        super(context, resource, heroList);

        this.context = context;
        this.resources = resource;
        this.heroList = heroList;
    }

    @NonNull

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.my_custom_list, null, false);

        ImageView imageView = view.findViewById(R.id.ImageView);
        TextView textName = view.findViewById(R.id.textViewName);
        TextView textTeam = view.findViewById(R.id.textViewTeam);
        Button button = view.findViewById(R.id.buttonDelete);

        Hero hero = heroList.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));

        textName.setText(hero.getName());
        textTeam.setText(hero.getTeam());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeHero(position);
            }
        });

        return view;
    }

    private void removeHero(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are u sure wanna delete this item ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    heroList.remove(position);

                    notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}