package org.abhinay.linkdin;

public class JobPosting {
    private final String id;
    private String title;
    private String desc;

    public JobPosting(String id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
