package com.blue339.lolive.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blue339.lolive.R;
import com.blue339.lolive.adapter.TvLiveAdapter;
import com.blue339.lolive.views.RecycleViewDivider;

/**
 * Created by Blue on 2016/5/19.
 */
public class TvLiveFragment extends Fragment {

    private int index;

    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;

    private SwipeRefreshLayout refresh;

    public TvLiveFragment(){
        super();
    }

    public TvLiveFragment(int i) {
        super();
        this.index = i;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvlive, container, false);
        TextView textView = (TextView) view.findViewById(R.id.content);
        textView.setText("Fragment(" + (index + 1) + ")");

        mRecycleView = (RecyclerView) view.findViewById(R.id.tvlive_recycleview);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(mLayoutManager);
        //mRecycleView.addItemDecoration(new RecycleViewDivider(getActivity()));
        mRecycleView.setAdapter(new TvLiveAdapter());

        refresh = (SwipeRefreshLayout) view.findViewById(R.id.tvlive_refresh);
        refresh.setColorSchemeResources(R.color.colorTheme);

        return view;
    }


}
