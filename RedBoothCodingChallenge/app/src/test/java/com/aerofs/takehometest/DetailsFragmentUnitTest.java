package com.aerofs.takehometest;

import com.aerofs.takehometest.model.UserInfo;
import com.aerofs.takehometest.network.pojo.Repo;
import com.aerofs.takehometest.network.pojo.User;
import com.aerofs.takehometest.view.DetailsFragment;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DetailsFragmentUnitTest {

    private void initModel() {
        UserInfo.getInstance().setUser(new User("Sam",
                "http://gif.com/avatar",
                "CHV1121",
                "Sam",
                "San Jose, CA",
                "sam@gmail.com",
                12, 1, 1));
        ArrayList repoList = new ArrayList();
        repoList.add(new Repo(1212, "Java Project", 1, "java", 0, 0));
        UserInfo.getInstance().setRepos(repoList);
    }

    @Test
    public void testMakeRepoList() throws Exception {
        DetailsFragment frag = new DetailsFragment();
        initModel();
        frag.makeRepoList();
        Assert.assertEquals(frag.getmUserRepoInfo().size(),2);
    }
}