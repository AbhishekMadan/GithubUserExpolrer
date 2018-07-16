package com.aerofs.takehometest.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.aerofs.takehometest.R;
import com.aerofs.takehometest.model.UserInfo;
import com.aerofs.takehometest.network.NetworkClient;
import com.aerofs.takehometest.network.NetworkInterface;
import com.aerofs.takehometest.network.pojo.Repo;
import com.aerofs.takehometest.network.pojo.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    @BindView(R.id.et_username)
    EditText mUsername;
    @BindView(R.id.bt_get_detail_button)
    Button mSubmitButton;
    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    private ISearchFragmentResult mSearchFragmentResultCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSearchFragmentResultCallback = (ISearchFragmentResult) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideProgressBar();
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void disableButton() {
        mSubmitButton.setEnabled(false);
    }

    private void enableButton() {
        mSubmitButton.setEnabled(true);
    }

    @OnClick(R.id.bt_get_detail_button)
    public void onClickSubmit() {
        closeKeyboard();
        if (!isNetworkAvailable()) {
            mSearchFragmentResultCallback.onNetworkOperationFailure(getString(R.string.no_internet));
            return;
        }
        if (!TextUtils.isEmpty(mUsername.getText())) {
            showProgressBar();
            disableButton();
            getUserDetails(mUsername.getText().toString());
        }
    }

    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (getActivity().getCurrentFocus()!=null) {
            inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void getUserDetails(String username) {
        NetworkInterface networkInterface = NetworkClient.getClient(getActivity()).create(NetworkInterface.class);
        Call<User> call = networkInterface.fetchUserDetails(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    UserInfo.getInstance().setUser(response.body());
                    getRepoDetailsForUser(response.body());
                } else {
                    hideProgressBar();
                    enableButton();
                    mSearchFragmentResultCallback.onNetworkOperationFailure(getString(R.string.no_user));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                hideProgressBar();
                enableButton();
                mSearchFragmentResultCallback.onNetworkOperationFailure(t.getMessage().toString());
            }
        });
    }

    /**
     * check if internet is connected.
     *
     * @return
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void getRepoDetailsForUser(final User user) {
        NetworkInterface networkInterface = NetworkClient.getClient(getActivity()).create(NetworkInterface.class);
        Call<ArrayList<Repo>> call = networkInterface.fetchUserRepoDetails(user.getLogin());
        call.enqueue(new Callback<ArrayList<Repo>>() {
            @Override
            public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
                hideProgressBar();
                enableButton();
                UserInfo.getInstance().setRepos(response.body());
                mSearchFragmentResultCallback.onNetworkOperationSuccessful();
            }

            @Override
            public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {
                hideProgressBar();
                enableButton();
                mSearchFragmentResultCallback.onNetworkOperationFailure(t.getMessage().toString());
            }
        });
    }

    public interface ISearchFragmentResult {
        void onNetworkOperationFailure(String message);

        void onNetworkOperationSuccessful();
    }
}
