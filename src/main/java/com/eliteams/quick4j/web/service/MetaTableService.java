package com.eliteams.quick4j.web.service;

import java.util.List;

import com.eliteams.quick4j.web.model.MetaTable;
import org.springframework.ui.Model;

import com.eliteams.quick4j.core.generic.GenericService;

public interface MetaTableService extends GenericService<MetaTable, Integer>{
	  /**
     * 插入对象
     *
     * @param model 对象
     */
    int insert(MetaTable model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int update(MetaTable model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int delete(Integer id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    MetaTable selectById(Integer id);

    MetaTable selectByName(String name);

    Model selectByType(String pageNow, Model model, String type);

    Model selectByTypeWithoutGJAndS(String pageNow, Model model);
    /**
     * 查询单个对象
     *
     * @return 对象
     */
    MetaTable selectOne();
    
    List<MetaTable> listAll();


    /**
     * 查询多个对象
     *
     * @return 对象集合
     */
    List<MetaTable> selectList();

}
