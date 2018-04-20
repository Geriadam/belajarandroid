package com.geriadam.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.geriadam.myrecyclerview.adapter.CardviewPresidentAdapter;
import com.geriadam.myrecyclerview.adapter.GridPresidentAdapter;
import com.geriadam.myrecyclerview.adapter.ListPresidentAdapter;
import com.geriadam.myrecyclerview.model.President;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<President> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView)findViewById(R.id.rv_catergory);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PresidentData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
        listPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(listPresidentAdapter);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,1));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);
    }

    private void showRecyclerCard(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardviewPresidentAdapter cardviewPresidentAdapter = new CardviewPresidentAdapter(this);
        cardviewPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(cardviewPresidentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        String title = null;
        switch (menuItem.getItemId()){
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title = "Mode Cardview";
                showRecyclerCard();
                break;
        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(menuItem);
    }
}
