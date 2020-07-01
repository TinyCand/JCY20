package com.jcy20.yao.Lect10Net.bean;

public class VideoInfo {
    private String title;
    private String profile;
    private String filePath;
    private String thumbPath;
    private String id;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }
    public String getThumbPath() {
        return thumbPath;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
