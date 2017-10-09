package com.htichina.web.tag;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Tag {
    private String id;
    private String name;
    private String count;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "tag [count=" + count + ", id=" + id + ", name=" + name + "]";
    }
}
