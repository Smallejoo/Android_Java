package com.example.resycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager LayoutMannager;
    private RecyclerView recyclerView;
    private ArrayList<DataModule> FichersList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.ResView);
        LayoutMannager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutMannager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        System.out.println("befor the data transfer");
        for(int i=0;i<DataBase.DescriptionArrays.length;i++)
        {
            DataModule datka=new DataModule(DataBase.NamesArrays[i]
            ,DataBase.DescriptionArrays[i],DataBase.PicArray[i]);
            FichersList.add(datka);
            System.out.println("names that got printed "+datka.getName());

        }
        for (DataModule data:FichersList)
        {
            System.out.println(data.getName());


        }
        CusAdaptor adaptor=new CusAdaptor(FichersList);
        recyclerView.setAdapter(adaptor);

    }
}