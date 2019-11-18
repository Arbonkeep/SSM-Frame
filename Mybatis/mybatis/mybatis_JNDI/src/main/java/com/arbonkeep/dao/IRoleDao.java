package com.arbonkeep.dao;

import com.arbonkeep.domain.Role;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/18 - 13:45
 */
public interface IRoleDao {
    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();
}
