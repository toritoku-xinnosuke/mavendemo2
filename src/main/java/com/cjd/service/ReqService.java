package com.cjd.service;

import com.cjd.domain.Req;

public interface ReqService {
    public Req select();
    public int insert(Req req);
    public int update(Req req);
}
