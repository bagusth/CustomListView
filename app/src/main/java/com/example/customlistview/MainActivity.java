package com.example.customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hero> heroList;

    ListView listView;

    int[] image = {R.drawable.spiderman, R.drawable.joker, R.drawable.ironman, R.drawable.doctorstrange, R.drawable.captainamerica, R.drawable.batman};
    String[] name = {"Spiderman", "Joker", "Iron Man", "Doctor Strange", "Captain America", "Batman"};
    String[] team = {"Avengers", "Injustice Gang", "Avengers", "Avengers", "Avengers", "Justice League"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroList = new ArrayList<>();
        listView = findViewById(R.id.listView);

        for (int i=0;i<image.length;i++){
            Hero hero = new Hero(image[i],name[i],team[i]);
            heroList.add(hero);
        }

        MyListAdapter adapter = new MyListAdapter(this, R.layout.my_custom_list, heroList);

        listView.setAdapter(adapter);
    }
}
