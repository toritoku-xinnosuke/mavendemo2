package com.cjd.domain;

public class Req {
    private int reqId;
    private String reqStatus;
    private String reqTime;

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public Req(int reqId, String reqStatus, String reqTime) {
        this.reqId = reqId;
        this.reqStatus = reqStatus;
        this.reqTime = reqTime;
    }

    public Req() {

    }

    @Override
    public String toString() {
        return "Req{" +
                "reqId=" + reqId +
                ", reqStatus='" + reqStatus + '\'' +
                ", reqTime='" + reqTime + '\'' +
                '}';
    }
}
