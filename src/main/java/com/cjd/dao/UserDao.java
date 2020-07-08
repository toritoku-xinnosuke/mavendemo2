package com.cjd.dao;

import com.cjd.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Component(value="UserDao")
public interface UserDao {

    public List<User> findAll();
}
