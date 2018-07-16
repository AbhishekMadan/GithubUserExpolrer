package com.aerofs.takehometest.model;

import com.aerofs.takehometest.network.pojo.Repo;
import com.aerofs.takehometest.network.pojo.User;

import java.util.ArrayList;

public class UserInfo {

    private static UserInfo mUserInfo;
    private User user;
    private ArrayList<Repo> repos;

    private UserInfo() {
        user = null;
        repos = null;
    }

    public static UserInfo getInstance() {
        if (mUserInfo==null) {
            mUserInfo = new UserInfo();
        }
        return mUserInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Repo> getRepos() {
        return repos;
    }

    public void setRepos(ArrayList<Repo> repos) {
        this.repos = repos;
    }
}
