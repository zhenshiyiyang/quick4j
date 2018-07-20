package com.eliteams.quick4j.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.eliteams.quick4j.web.dao.MetaTableMapper;
import com.eliteams.quick4j.web.model.MetaTable;
import com.eliteams.quick4j.web.service.MetaTableService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
@Service
public class MetaTableServiceImpl extends GenericServiceImpl<MetaTable, Integer> implements MetaTableService{
   
	@Resource
	private MetaTableMapper metaTableMapper;

	@Override
	public GenericDao<MetaTable, Integer> getDao() {
		return null;
	}

	@Override
	public MetaTable selectByName(String name) {
		return null;
	}

	@Override
	public Model selectByType(String pageNow, Model model, String type) {
		return null;
	}

	@Override
	public Model selectByTypeWithoutGJAndS(String pageNow, Model model) {
		return null;
	}

	@Override
	public List<MetaTable> listAll() {
		return null;
	}

	@Override
    public int insert(MetaTable model){
        return metaTableMapper.insert(model);
    }
}
