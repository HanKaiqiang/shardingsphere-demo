package com.shardingsphere.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.shardingsphere.demo.entity.User;

@Mapper
public interface UserRepository extends BaseRepository<User, Long> {

}
