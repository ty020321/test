package com.accp.domain;

public class User {
    private Integer userid;

    private String name;

    private String lxr;

    private String createdate;

    private String lxrphone;

    private Integer addressid;

    private String fzr;

    private String djh;

    private String address;
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getLxrphone() {
        return lxrphone;
    }

    public void setLxrphone(String lxrphone) {
        this.lxrphone = lxrphone;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }
}