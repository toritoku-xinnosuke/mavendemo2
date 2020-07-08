package com.cjd.service.impl;

import com.cjd.dao.ReqDao;
import com.cjd.domain.Req;
import com.cjd.service.ReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


@Service
public class ReqServiceImpl implements ReqService {
    @Autowired
    private ReqDao reqDao;

    @Override
    public Req select() {
        return reqDao.select();
    }

    @Override
    public int insert(Req req) {
        return reqDao.insert(req);
    }

    @Override
    public int update(Req req) {
        return reqDao.update(req);
    }

    abstract class taskRunner{

        String name;
        taskRunner(String name){
            this.name = name;
        }




    }
}
