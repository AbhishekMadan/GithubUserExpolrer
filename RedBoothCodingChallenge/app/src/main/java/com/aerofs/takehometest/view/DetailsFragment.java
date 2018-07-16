package com.aerofs.takehometest.view;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aerofs.takehometest.R;
import com.aerofs.takehometest.adapter.DetailsViewAdapter;
import com.aerofs.takehometest.model.UserInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    @BindView(R.id.list_item)
    RecyclerView mRecyclerView;

    private ArrayList mUserRepoInfo;

    public DetailsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this,view);
        makeRepoList();
        initRecyclerView();
        return view;
    }

    /**
     * Take the data from the UserInfo model( Userinfo + repoInfo) and put them
     * in a single list so as to display then in recycler view.
     */
    public void makeRepoList() {
        mUserRepoInfo = new ArrayList();
        mUserRepoInfo.add(UserInfo.getInstance().getUser());
        mUserRepoInfo.addAll(UserInfo.getInstance().getRepos());
    }

    private void initRecyclerView() {
        //recycler view layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //recycler view adapter
        DetailsViewAdapter adapter = new DetailsViewAdapter(getActivity(),mUserRepoInfo);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    public ArrayList getmUserRepoInfo() {
        return mUserRepoInfo;
    }
}
