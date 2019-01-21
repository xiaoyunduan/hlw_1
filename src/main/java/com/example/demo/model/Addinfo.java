package com.example.demo.model;

public class Addinfo {
    private Integer userId;

    private String address;

    private String aboutMe;

    private byte[] upload;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe == null ? null : aboutMe.trim();
    }

    public byte[] getUpload() {
        return upload;
    }

    public void setUpload(byte[] upload) {
        this.upload = upload;
    }
}