package com.bibe.crm.dao;
import java.util.Collection;

import com.bibe.crm.entity.dto.PermissionUpdateDTO;
import com.bibe.crm.entity.po.RolesPermissionRelation;import org.apache.ibatis.annotations.Param;import java.util.List;import java.util.Set;

public interface RolesPermissionRelationMapper {
    int insert(RolesPermissionRelation record);

    int insertSelective(RolesPermissionRelation record);

    /**
     * 获取角色权限
     *
     * @param roleId
     * @return
     */
    Set<String> getRolePrimary(Integer roleId);

    int insertList(@Param("list")List<RolesPermissionRelation> list);

    int deleteByRoleId(@Param("roleId") Integer roleId, @Param("type")Integer type);


    /**
     * 启用 禁用权限 0 1
     * @param updateList
     * @return
     */
    int updateStatus(@Param("updateList")List<PermissionUpdateDTO> updateList);
}