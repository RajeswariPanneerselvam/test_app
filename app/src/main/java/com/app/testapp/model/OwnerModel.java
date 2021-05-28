package com.app.testapp.model;

public class OwnerModel {
    public String login;
    public String id ;
    public String node_id;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public OwnerModel(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String avatar_url;
    public String url;
    public String html_url;
    public String gravatar_id;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String  starred_url;
    public String  subscriptions_url;
    public String  organizations_url;
    public String  repos_url;
    public String  events_url;
    public String  received_events_url;
    public String  type;
    public Boolean site_admin;
    }

