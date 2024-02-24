package com.example.resycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager LayoutMannager;
    private RecyclerView recyclerView;
    private ArrayList<DataModule> FichersList= new ArrayList<>();
    private ArrayList<DataModule> cFichersList= new ArrayList<>();
    private  EditText sarchBar;

    public void EmptySB()
    {
        for(int i=0;i<DataBase.DescriptionArrays.length;i++)
        {
            DataModule datka=new DataModule(DataBase.NamesArrays[i]
                    ,DataBase.DescriptionArrays[i],DataBase.PicArray[i]);
            FichersList.add(datka);
           // System.out.println("names that got printed "+datka.getName());

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sarchBar=findViewById(R.id.SarchBar);
        recyclerView=findViewById(R.id.ResView);
        LayoutMannager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutMannager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //System.out.println("befor the data transfer");
        EmptySB();
        for (DataModule data:FichersList)
        {
            System.out.println(data.getName());


        }
        CusAdaptor adaptor=new CusAdaptor(FichersList);
        recyclerView.setAdapter(adaptor);
        sarchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String sarchBtext=sarchBar.getText().toString();
                System.out.println("ssarch barxxxxx,"+sarchBtext);
                cFichersList.clear();
                for(int i=0;i<DataBase.NamesArrays.length;i++)
                {
                    if(DataBase.NamesArrays[i].contains(sarchBtext))
                    {

                        DataModule datka=new DataModule
                                        (DataBase.NamesArrays[i]
                                        , DataBase.DescriptionArrays[i]
                                        ,DataBase.PicArray[i] );
                        cFichersList.add(datka);
                    }

                }
                if(cFichersList.isEmpty())
                {
                    for(int i=0;i<DataBase.DescriptionArrays.length;i++)
                    {
                        DataModule datka=new DataModule(DataBase.NamesArrays[i]
                                ,DataBase.DescriptionArrays[i],DataBase.PicArray[i]);
                        cFichersList.add(datka);
                        // System.out.println("names that got printed "+datka.getName());

                    }
                }
                adaptor.UpdateNewData(cFichersList);
                recyclerView.setAdapter(adaptor);

            }
        });



    }
}