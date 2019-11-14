package com.example.tibiarapv01.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Achievement {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("grade")
    @Expose
    private Integer grade;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("secret")
    @Expose
    private Integer secret;
    @SerializedName("spoiler")
    @Expose
    private String spoiler;
    @SerializedName("related_achievements")
    @Expose
    private Object relatedAchievements;
    @SerializedName("checked")
    @Expose
    private Boolean checked;
    @SerializedName("bookmarked")
    @Expose
    private Boolean bookmarked;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    /**
     * No args constructor for use in serialization
     *
     */
    public Achievement() {
    }

    /**
     *
     * @param createdAt
     * @param relatedAchievements
     * @param bookmarked
     * @param grade
     * @param name
     * @param description
     * @param checked
     * @param spoiler
     * @param id
     * @param secret
     * @param type
     * @param points
     */
    public Achievement(Integer id, String name, String description, Integer points, Integer grade, String type, Integer secret, String spoiler, Object relatedAchievements, Boolean checked, Boolean bookmarked, String createdAt) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.points = points;
        this.grade = grade;
        this.type = type;
        this.secret = secret;
        this.spoiler = spoiler;
        this.relatedAchievements = relatedAchievements;
        this.checked = checked;
        this.bookmarked = bookmarked;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSecret() {
        return secret;
    }

    public void setSecret(Integer secret) {
        this.secret = secret;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
    }

    public Object getRelatedAchievements() {
        return relatedAchievements;
    }

    public void setRelatedAchievements(Object relatedAchievements) {
        this.relatedAchievements = relatedAchievements;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
