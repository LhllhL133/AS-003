package com.example.toshiba.as_003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageid = new int[]{R.drawable.lion,R.drawable.tiger,
            R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listitem=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++)
        {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("name",names[i]);
            item.put("desc",imageid[i]);
            listitem.add(item);
        }
        SimpleAdapter s =new SimpleAdapter(this,listitem,R.layout.simple_item,
                new String[]{"name","desc"},
                new int[]{R.id.name,R.id.desc});
        ListView list=(ListView)findViewById(R.id.listView);
        list.setAdapter(s);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
