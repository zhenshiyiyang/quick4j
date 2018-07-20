package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.web.model.MetaTable;
import com.eliteams.quick4j.web.model.MetaTableExample;
import java.util.List;
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
}