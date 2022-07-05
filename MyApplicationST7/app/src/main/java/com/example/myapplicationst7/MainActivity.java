package com.example.myapplicationst7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {
    private List<Product> productList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_item) {
            Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "del", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView =  findViewById(R.id.recycler);
        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        initData();
        MasonryAdapter adapter=new MasonryAdapter(productList);
        recyclerView.setAdapter(adapter);


        // Setup onItemTouchHandler
        ItemTouchHelper.Callback callback = new RVOnItemTouchHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);

        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(10);
        recyclerView.addItemDecoration(decoration);

        // Set On Click
        recyclerView.addOnItemTouchListener(new RVItemClickListener(this, new RVItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String value = "Clicked Item " + productList.get(position) + " at " + position;
                Log.d("TAG", value);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        }));


    }

    private void initData() {
        productList=new ArrayList<Product>();

        Product p1=new Product(R.drawable.p1,"我是照片1");
        productList.add(p1);
        Product p2=new Product(R.drawable.p2,"我是照片2");
        productList.add(p2);
        Product p3=new Product(R.drawable.p3,"我是照片3");
        productList.add(p3);
        Product p4=new Product(R.drawable.p4,"我是照片4");
        productList.add(p4);
        Product p5=new Product(R.drawable.p5,"我是照片5");
        productList.add(p5);
        Product p6=new Product(R.drawable.p6,"我是照片6");
        productList.add(p6);
        for (int i = 0; i < 100; i++) {
            productList.add(productList.get(new Random().nextInt(6)));
        }
    }

}