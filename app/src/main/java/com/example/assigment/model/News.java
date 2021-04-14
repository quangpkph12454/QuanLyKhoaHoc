package com.example.assigment.model;

import android.text.Html;

public class News {
    public String title,description,link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        if (description.contains("</br>")){
            int index = description.lastIndexOf("</br>");
            return description.substring(index +5);
        }else {
            return String.valueOf(Html.fromHtml(description));
        }

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public News() {
    }

    public News(String title, String description,String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }
}
