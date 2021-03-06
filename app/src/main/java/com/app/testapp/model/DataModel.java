package com.app.testapp.model;

public class DataModel {


    public String id;
    public String node_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
    public String full_name;
   // public Boolean private;
    public OwnerModel owner;

    public String html_url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description;
    public Boolean fork;

    public String url;
    public String     forks_url;
    public String      keys_url;
    public String     collaborators_url;
    public String    teams_url;
    public String     hooks_url;
    public String       issue_events_url;
    public String    events_url;
    public String    assignees_url;
    public String     branches_url;
    public String     tags_url;
    public String    blobs_url;
    public String      git_tags_url;
    public String     git_refs_url;
    public String    trees_url;
    public String     statuses_url;
    public String    languages_url;
    public String    stargazers_url;
    public String    contributors_url;
    public String       subscribers_url;
    public String     subscription_url;
    public String     commits_url;
    public String    git_commits_url;
    public String      issue_comment_url;
    public String      contents_url;
    public String       compare_url;
    public String       merges_url;
    public String      archive_url;
    public String       downloads_url;
    public String        issues_url;
    public String      pulls_url;
    public String      milestones_url;
    public String     notifications_url;
    public String     labels_url;
    public String    releases_url;
    public String       deployments_url;
}

