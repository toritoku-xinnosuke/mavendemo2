package com.cjd.dao;


import com.cjd.domain.Req;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("ReqDao")
public interface ReqDao {
    public Req select();
    public int insert(Req req);
    public int update(Req req);
}
