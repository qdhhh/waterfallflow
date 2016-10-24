package com.android.qdhhh.waterfallflowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_id)
    RecyclerView rv_id;
    List<String> stringData;

    int[] pic = {R.mipmap.qwe, R.mipmap.qwe1, R.mipmap.qwe2,
            R.mipmap.qwe3, R.mipmap.qwe4, R.mipmap.qwe5, R.mipmap.qwe6,
            R.mipmap.qwe7, R.mipmap.qwe8, R.mipmap.qwe9, R.mipmap.qwe10};

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setStringData();
        setRecyclerView();

    }

    private void setStringData() {
        stringData = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            stringData.add("哈哈" + i);
        }
    }

    private void setRecyclerView() {

        myAdapter = new MyAdapter();
        rv_id.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        rv_id.setAdapter(myAdapter);
    }

    private final class MyAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder vp = new MyViewHolder(View.inflate(MainActivity.this, R.layout.item, null));
            return vp;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//            ViewGroup.LayoutParams lp = ((MyViewHolder) holder).item_tv_id.getLayoutParams();
//            lp.height = (int) (Math.random() * 300 + 100);
//            ((MyViewHolder) holder).item_tv_id.setLayoutParams(lp);
            ((MyViewHolder) holder).item_tv_id.setImageResource(pic[position % pic.length]);
        }

        @Override
        public int getItemCount() {
            return stringData.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView item_tv_id;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_tv_id = (ImageView) itemView.findViewById(R.id.item_tv_id);
        }

    }
}
