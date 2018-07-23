package com.eliteams.quick4j.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eliteams.quick4j.core.page.Page;
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
	public Model selectListByPage(String pageNow, Model model) {
		Page page = null;

		List<MetaTable> metaTables = new ArrayList<MetaTable>();

		int totalCount = metaTableMapper.getMetaCount();

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
			metaTables = metaTableMapper.selectMetaByPage(page.getStartPosMeta(), page.getMetaPageSize());
		} else {
			page = new Page(totalCount, 1);
			metaTables = metaTableMapper.selectMetaByPage(page.getStartPosMeta(), page.getMetaPageSize());
		}
		model.addAttribute("mlist",metaTables);
		model.addAttribute("page",page);
		return model;
	}

	@Override
	public Model selectMetaByCond(String pageNow, Model model, Map map) {

		Page page = null;

		List<MetaTable> metaTables = new ArrayList<MetaTable>();

		int totalCount = metaTableMapper.getMetaCountByCond(map);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
			metaTables = metaTableMapper.selectMetaByCond(page.getStartPosMeta(), page.getMetaPageSize(),map);
		} else {
			page = new Page(totalCount, 1);
			metaTables = metaTableMapper.selectMetaByCond(page.getStartPosMeta(), page.getMetaPageSize(),map);
		}
		model.addAttribute("mlist",metaTables);
		model.addAttribute("page",page);
		return model;
	}

	@Override
    public int insert(MetaTable model){
        return metaTableMapper.insert(model);
    }

	public int delete(Integer id){
		return metaTableMapper.deleteByPrimaryKey(id);
	}
}
