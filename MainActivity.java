package com.example.calsys.retro_custom_class;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.calsys.retro_custom_class.Retro.Response.Tutorsubjectlistresponse;
import com.example.calsys.retro_custom_class.parser.Area_Worker;
import com.example.calsys.retro_custom_class.parser.Area_worker_callback;
import com.example.calsys.retro_custom_class.recy.ArrayAdapter;
import com.example.calsys.retro_custom_class.recy.Inventory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Area_worker_callback {

    RecyclerView recyc;
    ArrayAdapter adapter;
    ArrayList<Inventory> array_name = new ArrayList<>();

    String id = "1";
    String cat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Area_Worker area_worker =new Area_Worker(MainActivity.this,MainActivity.this,id,cat);

        recyc = findViewById(R.id.my_recy);
        adapter = new ArrayAdapter(array_name);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyc.setLayoutManager(lm);
        recyc.setItemAnimator(new DefaultItemAnimator());
        recyc.setAdapter(adapter);
    }



    @Override
    public void area_succes(Tutorsubjectlistresponse res) {

        for (int i = 0; i < res.getData().size(); i++) {
            String f_name = res.getData().get(i).getFirst_name();
            String l_name = res.getData().get(i).getLast_name();

            String name = f_name + " " + l_name;
            String id = res.getData().get(i).getId();


            Inventory d = new Inventory(name,id);
            array_name.add(d);
        }
        adapter.notifyDataSetChanged();

    }
}
