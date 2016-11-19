package com.mi.cardviewtest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.twotoasters.jazzylistview.JazzyEffect;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;
/**
 * compile 'com.twotoasters.jazzylistview:library:1.2.1'
 compile 'com.twotoasters.jazzylistview:library-recyclerview:1.2.1'
 动画item的出现的设置
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        JazzyRecyclerViewScrollListener jazzyRecyclerViewScrollListener=new JazzyRecyclerViewScrollListener();//创建滚动的时候的监听的对象
        jazzyRecyclerViewScrollListener.setTransitionEffect(JazzyHelper.WAVE);//为该监听的对象设置过渡的效果为JazzyHelper类中的静态的变量
        recyclerView.setOnScrollListener(jazzyRecyclerViewScrollListener);//将该动画加入recyclerView的滚动事件中
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        recyclerView.setAdapter(new MyAdapter());
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>

    {
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyHolder holder=new MyHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.iv.setImageResource(R.mipmap.imgs3);
        }

        @Override
        public int getItemCount() {
            return 30;
        }

        class MyHolder extends RecyclerView.ViewHolder
        {
            private ImageView iv;
            public MyHolder(View itemView) {
                super(itemView);
                iv= (ImageView) itemView.findViewById(R.id.iv);
            }
        }
    }
}
