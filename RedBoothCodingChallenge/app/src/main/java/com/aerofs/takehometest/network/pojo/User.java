package com.aerofs.takehometest.network.pojo;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("email")
    private String email;

    @SerializedName("public_repos")
    private Integer publicRepos;

    @SerializedName("followers")
    private Integer followers;

    @SerializedName("following")
    private Integer following;

    public User(String login, String avatarUrl, String gravatarId, String name, String location, String email, Integer publicRepos, Integer followers, Integer following) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.name = name;
        this.location = location;
        this.email = email;
        this.publicRepos = publicRepos;
        this.followers = followers;
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getFollowing() {
        return following;
    }
}
