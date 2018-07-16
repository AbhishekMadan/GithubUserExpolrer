package com.aerofs.takehometest.network.pojo;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("stargazers_count")
    private Integer stargazersCount;

    @SerializedName("language")
    private String language;

    @SerializedName("forks_count")
    private Integer forksCount;

    @SerializedName("watchers")
    private Integer watchers;


    public Integer getId() {
        return id;
    }

    public Repo(Integer id, String name, Integer stargazersCount, String language, Integer forksCount, Integer watchers) {
        this.id = id;
        this.name = name;
        this.stargazersCount = stargazersCount;
        this.language = language;
        this.forksCount = forksCount;
        this.watchers = watchers;
    }

    public String getName() {
        return name;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public Integer getWatchers() {
        return watchers;
    }
}
