package com.example.numad21fa_zanyuanyang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinkCollectorActivity extends AppCompatActivity implements LinkCollectorDialog.ExampleDialogListener {

    private ArrayList<LinkList> linkList;
    private RecyclerView recyclerView;

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_collector);

        recyclerView = findViewById(R.id.recyclerView);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDialog();
            }
        });

        linkList = new ArrayList<>();

        setLinkListInfo();
        setAdapter();

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(linkList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setLinkListInfo() {
        linkList.add(new LinkList("baidu", "www.baidu.com"));
        linkList.add(new LinkList("google", "www.google.com"));
        linkList.add(new LinkList("apple", "www.apple.com"));

    }

    public void openDialog(){
        LinkCollectorDialog linkCollectorDialog = new LinkCollectorDialog();
        linkCollectorDialog.show(getSupportFragmentManager(), "Link Collector Dialog");
    }

    @Override
    public void applyTexts(String name, String url){
        linkList.add(new LinkList(name, url));
    }
}
