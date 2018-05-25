package com.andela.android.gmailapp.model;

/**
 * Created by chike on 23/05/2018.
 */

public class Message {
    private String from;
    private String subject;
    private String message;
    private String timestamp;
    private String picture;
    private int color;

    public Message(String from, String subject, String message, String timestamp, String picture, int color) {
        this.picture = picture;
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
        this.color = color;
    }

    public String getPicture() {
        return picture;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getColor() {
        return color;
    }
}
