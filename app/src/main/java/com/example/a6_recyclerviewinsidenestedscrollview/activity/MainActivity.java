package com.example.a6_recyclerviewinsidenestedscrollview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a6_recyclerviewinsidenestedscrollview.R;
import com.example.a6_recyclerviewinsidenestedscrollview.adapter.CustomAdapter;
import com.example.a6_recyclerviewinsidenestedscrollview.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Context context;
NestedScrollView nestedScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members  =  prepareMemberList();
        refreshAdapter(members);

    }
    private void initView(){

        nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recycleViewMain);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }
    private  void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false); // harakatlanishni tezlashtiradi va yaxshilaydi.
    }
    private List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        members.add(new Member()); // for holder
        for (int i = 0; i < 30; i++) {
            if (i == 1 || i == 10){
                members.add(new Member(i +")Sherzod", i + ")Jurabekov",false));
            }else{
                members.add(new Member(i +")Javohir", i + ")Jurabekov",true));
            }

        }
        members.add(new Member());
        return members;
    }
}