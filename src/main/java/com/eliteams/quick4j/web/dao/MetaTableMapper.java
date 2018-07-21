package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.web.model.MetaTable;
import com.eliteams.quick4j.web.model.MetaTableExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MetaTableMapper {
    int countByExample(MetaTableExample example);

    int deleteByExample(MetaTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MetaTable record);

    int insertSelective(MetaTable record);

    List<MetaTable> selectByExample(MetaTableExample example);

    MetaTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MetaTable record, @Param("example") MetaTableExample example);

    int updateByExample(@Param("record") MetaTable record, @Param("example") MetaTableExample example);

    int updateByPrimaryKeySelective(MetaTable record);

    int updateByPrimaryKey(MetaTable record);

    List<MetaTable> selectMetaByPage(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);

    int getMetaCount();

    List<MetaTable> selectMetaByCond(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize,@Param(value = "map")Map map);

    int getMetaCountByCond(@Param(value = "map")Map map);
}