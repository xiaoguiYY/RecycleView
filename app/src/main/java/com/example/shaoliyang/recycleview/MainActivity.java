package com.example.shaoliyang.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRec_main_show;
    private List<String> mItemshows = new ArrayList<>();

    private int[] mListIcons = new int[]{R.mipmap.g1, R.mipmap.g2, R.mipmap.g3, R.mipmap.g4,
            R.mipmap.g5, R.mipmap.g6, R.mipmap.g7, R.mipmap.g8, R.mipmap.g9, R.mipmap.g10, R
            .mipmap.g11, R.mipmap.g12, R.mipmap.g13, R.mipmap.g14, R.mipmap.g15, R.mipmap
            .g16, R.mipmap.g17, R.mipmap.g18, R.mipmap.g19, R.mipmap.g20, R.mipmap.g21, R
            .mipmap.g22, R.mipmap.g23, R.mipmap.g24, R.mipmap.g25, R.mipmap.g26, R.mipmap
            .g27, R.mipmap.g28, R.mipmap.g29};

    private int[] mStraggeredIcons = new int[]{R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R
            .mipmap.p4, R.mipmap.p5, R.mipmap.p6, R.mipmap.p7, R.mipmap.p8, R.mipmap.p9, R
            .mipmap.p10, R.mipmap.p11, R.mipmap.p12, R.mipmap.p13, R.mipmap.p14, R.mipmap
            .p15, R.mipmap.p16, R.mipmap.p17, R.mipmap.p18, R.mipmap.p19, R.mipmap.p20, R
            .mipmap.p21, R.mipmap.p22, R.mipmap.p23, R.mipmap.p24, R.mipmap.p25, R.mipmap
            .p26, R.mipmap.p27, R.mipmap.p28, R.mipmap.p29, R.mipmap.p30, R.mipmap.p31, R
            .mipmap.p32, R.mipmap.p33, R.mipmap.p34, R.mipmap.p35, R.mipmap.p36, R.mipmap
            .p37, R.mipmap.p38, R.mipmap.p39, R.mipmap.p40, R.mipmap.p41, R.mipmap.p42, R
            .mipmap.p43, R.mipmap.p44};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        initArrayList();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //RecyclerView.LayoutManager layout = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, true);
        mRec_main_show.setLayoutManager(layout);

        mRec_main_show.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = View.inflate(parent.getContext(), R.layout.show_item, null);
                MyViewHolder myViewHolder = new MyViewHolder(view);
                return myViewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyViewHolder viewHolder = (MyViewHolder) holder;
                viewHolder.mItem_straggered_iv.setImageResource(mStraggeredIcons[position]);
                viewHolder.mItem_straggered_tv.setText(mItemshows.get(position));

            }

            @Override
            public int getItemCount() {
                return mItemshows.size();
            }

            class MyViewHolder extends RecyclerView.ViewHolder {

                private final ImageView mItem_straggered_iv;
                private final TextView mItem_straggered_tv;

                public MyViewHolder(View itemView) {
                    super(itemView);
                    mItem_straggered_iv = (ImageView) itemView.findViewById(R.id.item_straggered_iv);
                    mItem_straggered_tv = (TextView) itemView.findViewById(R.id.item_straggered_tv);
                }


            }


        });
    }

    private void initArrayList() {
        for (int i = 0; i < mStraggeredIcons.length; i++) {
            mItemshows.add("当前的数据" + i);
        }
    }

    private void initView() {
        mRec_main_show = (RecyclerView) findViewById(R.id.rec_main_show);
    }
}
