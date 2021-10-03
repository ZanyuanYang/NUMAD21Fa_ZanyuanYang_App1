package com.example.numad21fa_zanyuanyang;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkCollectorActivity extends AppCompatActivity implements LinkCollectorDialog.ExampleDialogListener, recyclerAdapter.OnLinkListener {

    private ArrayList<LinkList> linkList;
    private RecyclerView recyclerView;

    private FloatingActionButton floatingActionButton;

    ConstraintLayout linkCollectorLayout;

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

//        System.out.println(recyclerView.findViewHolderForAdapterPosition(1));

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(linkList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setLinkListInfo() {
//        linkList.add(new LinkList("baidu", "www.baidu.com"));
//        linkList.add(new LinkList("google", "www.google.com"));
//        linkList.add(new LinkList("apple", "www.apple.com"));
    }

    public void openDialog(){
        LinkCollectorDialog linkCollectorDialog = new LinkCollectorDialog();
        linkCollectorDialog.show(getSupportFragmentManager(), "Link Collector Dialog");
    }

    @Override
    public void applyTexts(String name, String url){

        linkCollectorLayout = findViewById(R.id.linkCollectorLayout);

        if(isValidUrl(url)){
            linkList.add(new LinkList(name, url));

            Snackbar.make(linkCollectorLayout, "Link Create Successfully!", Snackbar.LENGTH_SHORT)
                    .setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View v){

                        }
                    })
                    .show();
        }
        else{
            Snackbar.make(linkCollectorLayout, "URL Invalid!", Snackbar.LENGTH_LONG)
                    .setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View v){

                        }
                    })
                    .show();
        }
    }

    private boolean isValidUrl(String url) {
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(url.toLowerCase());
        return m.matches();
    }

    @Override
    public void onLinkClick(int position) {
        Log.d("lIKN-LINK-LINK:", "onLinkClick: click." +  position);
        recyclerAdapter adapter = new recyclerAdapter(linkList, this);

        String url = adapter.getItemUrl(position);

        if (!url.startsWith("https://")) {
            if(!url.startsWith("http://")){
                url = "https://" + url;
            }
        }

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
