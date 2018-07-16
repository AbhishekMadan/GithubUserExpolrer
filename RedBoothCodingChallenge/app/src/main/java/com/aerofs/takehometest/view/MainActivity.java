package com.aerofs.takehometest.view;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.aerofs.takehometest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SearchFragment.ISearchFragmentResult{

    private FragmentManager mFragmentManager;
    private DetailsFragment mDetailsFragment;
    private SearchFragment mSearchFragment;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    public void init() {
        mDetailsFragment = new DetailsFragment();
        mSearchFragment  = new SearchFragment();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,mSearchFragment);
        transaction.commit();
    }

    @Override
    public void onNetworkOperationFailure(String message) {
        showErrorSnackBar(message);
    }

    @Override
    public void onNetworkOperationSuccessful() {
        showUserDetailsFragment();
    }

    private void showUserDetailsFragment() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.exit_to_right);
        transaction.replace(R.id.fragment_container,mDetailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showErrorSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(mCoordinatorLayout,message,Snackbar.LENGTH_SHORT);
        View mView = snackbar.getView();
        TextView mTextView = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            mTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();
    }
}
