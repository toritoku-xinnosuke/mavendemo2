package com.cjd.senddemo;

import com.cjd.domain.Req;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class ReqGen {
    private final Req req = new Req();

    public Req getNewReq(int opType){
        Random ra = new Random();
        //this.req.setReqId(Integer.valueOf(UUID.randomUUID().toString().replace("-","")));
        this.req.setReqId(ra.nextInt(1000)+1);
        if(opType == 1){
            this.req.setReqStatus("insert");
        }else{
            this.req.setReqStatus("update");
        }

        this.req.setReqTime(new Date().toString());
        return req;
    }

    public Req getUpdateReq(int opType,int no){
        Random ra = new Random();
        //this.req.setReqId(Integer.valueOf(UUID.randomUUID().toString().replace("-","")));
        this.req.setReqId(no);
        if(opType == 1){
            this.req.setReqStatus("insert");
        }else{
            this.req.setReqStatus("update");
        }

        this.req.setReqTime(new Date().toString());
        return req;
    }

}
