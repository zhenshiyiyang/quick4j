package com.eliteams.quick4j.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eliteams.quick4j.core.page.Page;
import com.eliteams.quick4j.web.model.testBean;
import com.google.gson.Gson;
@Controller
@RequestMapping("/search")
public class SearchController {
	String Driver = "";
	List<String> list_com = new LinkedList<String>();
	ArrayList<testBean> arraylistUsers = new ArrayList<testBean>();
	@RequestMapping("/getModuleName")
	public void getModuleName(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("yes");
		String driver = request.getParameter("driver");
		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		request.getSession().setAttribute("driver", driver);
		request.getSession().setAttribute("url", url);
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("pwd", pwd);

		String db = url.substring(url.lastIndexOf("/")+1);
		String sql = "select MODULE from TABLE_TYPE";
		Driver = "com.mysql.jdbc.Driver";
		//request.getSession().setAttribute("db", db);
		Statement stmt;
		List<String> list = new ArrayList<String>();
		Map<String,String> map = new HashMap<String,String>();
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(url, name, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					String t = rs.getString(i);
					System.out.println(t);
					map.put(t, "lx");
				}
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(String key : map.keySet()){
			list.add(key);
		}
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		String str = gson.toJson(list);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(str);
	}

	@RequestMapping("/getTableName")
	public void getTableName(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String driver = (String) request.getSession().getAttribute("driver");
		String url = (String) request.getSession().getAttribute("url");
		String name = (String) request.getSession().getAttribute("name");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String module = request.getParameter("module");
		String sql = "";
		String db = "";
		//if(driver.equals("mysql")){
		db = url.substring(url.lastIndexOf("/")+1);
		sql = "select `TABLE`,`NAME` from TABLE_TYPE where MODULE like '%"+module+"%' and NAME is not NULL";
		System.out.println("getTableName:"+sql);
		Driver = "com.mysql.jdbc.Driver";
		Map<String,String> map = new HashMap<String,String>();
		Statement stmt;
		List<String> list = new ArrayList<String>();

		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(url, name, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String table = rs.getString(1);
				String table_c = rs.getString(2);
				System.out.println(table+":"+table_c);
				list.add(table_c);
				map.put(table_c, table);
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("map_table_chinese", map);
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		String str = gson.toJson(list);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(str);
	}

	@RequestMapping("/getColumnName")
	public void db1(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String table = (String) session.getAttribute("table");
		List<String> list = new LinkedList<String>();
		Driver = "com.mysql.jdbc.Driver";
		Map<String,String> map = new HashMap<String,String>();
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(request.getSession().getAttribute("url").toString(),
					request.getSession().getAttribute("name").toString(), request.getSession().getAttribute("pwd").toString());
			Statement stmt = conn.createStatement();
			String sql;
			String sql_map;
			sql = "select `ATTR_NAME` from DICT_A where DB_NAME='"+table+"' and ALIAS is not null";
			sql_map = "select `ATTR_NAME`,`ALIAS` from DICT_A where DB_NAME = '"+table+"' and ALIAS is not null";
			ResultSet res = stmt.executeQuery(sql);
			int col = res.getMetaData().getColumnCount();
			while(res.next()){
				for (int m = 1; m <= col; m++) {
					System.out.print(res.getString(m) + "\t");
					list.add(res.getString(m));
				}
			}
			ResultSet res_map = stmt.executeQuery(sql_map);
			System.out.println(sql_map);

			while(res_map.next()){
				System.out.println(res_map.getString(2));
				map.put(res_map.getString(1),res_map.getString(2));
			}
			session.setAttribute("column", list);
			session.setAttribute("map", map);
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		String str = gson.toJson(list);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(str);
	}

	@RequestMapping("/getHash")
	public void getHash(HttpServletRequest request, HttpServletResponse response) {
		String table_chinese = request.getParameter("db");
		String table = "";
		HttpSession session = request.getSession();
		Map map_table_chinese = (Map) session.getAttribute("map_table_chinese");
		table = (String) map_table_chinese.get(table_chinese);
		session.setAttribute("table", table);
		List<String> list = new LinkedList<String>();
		if(request.getSession().getAttribute("driver").toString().equals("mysql")){
			Driver = "com.mysql.jdbc.Driver";
		}else{
			Driver = "oracle.jdbc.driver.OracleDriver";
		}
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(request.getSession().getAttribute("url").toString(),
					request.getSession().getAttribute("name").toString(), request.getSession().getAttribute("pwd").toString());
			Statement stmt = conn.createStatement();
			String sql;
			if(request.getSession().getAttribute("driver").toString().equals("mysql")){
				sql = "";
			}else{
				sql = "select `ATTR_NAME`,`ALIAS`,`ATTR_TYPE` from DICT_A where DB_NAME = '"+table+"' and ALIAS is not null";
			}
			ResultSet res = stmt.executeQuery(sql);
			//int col = res.getMetaData().getColumnCount();
			while(res.next()){
				for (int m = 1; m <= 2; m++){
					list.add(res.getString(m));
				}

				testBean user=new testBean();
				user.setTable(table);
				user.setAttr_name(res.getString(1));
				user.setAlias(res.getString(2));
				user.setType(res.getString(3));
				System.out.println("111"+user.getAttr_name()+user.getAlias());
				arraylistUsers.add(user);

			}

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		String str = gson.toJson(list);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(str);
	}
	//add
	@RequestMapping("/getType")
	public void getType(HttpServletRequest request, HttpServletResponse response) {
		String table = request.getParameter("table");
		String attr_1 =  request.getParameter("at");
		String count="0";
		System.out.println(table+attr_1+"0");
		System.out.println(arraylistUsers.size());
		for (int j = 0; j < arraylistUsers.size(); j++){
			testBean temp=arraylistUsers.get(j);
			System.out.println(temp.getAlias());
			System.out.println(temp.getTable());
			String alias=temp.getAlias();
			String tb=temp.getTable();
			if(alias.equals(attr_1) && tb.equals(table))
			{
				if(temp.getType().equals("NUMBER"))
					count="1";
			}
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		out.write(count);
	}

	@RequestMapping("/query")
	@ResponseBody
	public ModelAndView query(HttpServletRequest request, ModelAndView m){
		System.out.println("--------------------------------------------------------------");
		HttpSession session = request.getSession();
		String table = (String) session.getAttribute("table");
		List columns = (List)session.getAttribute("column");
		String prop = "";
		for(int i=0;i<columns.size();i++){
			if(i==columns.size()-1){
				prop += "a."+columns.get(i);
			}else {
				prop += "a."+columns.get(i)+",";
			}
		}
		System.out.println("属性："+prop);
		session.setAttribute("prop_str", prop);
		String condition ="";
		Map map = (Map) session.getAttribute("map");
		String cond = "";
		for(int i=0;i<columns.size();i++){
			String column = request.getParameter((String) columns.get(i));
			session.setAttribute((String)columns.get(i), column);
			//判断是否为最后一个，不需要加and
			if(i<columns.size()-1){
				//判断是否为空
				if(column==null || "".equals(column)||"max-".equals(column)||"equ-".equals(column)||"min-".equals(column)){
					cond += " 1=1 and ";
				}else{
					//判断是否为数字
					if(column.contains("-"))
					{
						String[] sourceStrArray = column.split("-");
						condition=sourceStrArray[0];
						column=sourceStrArray[1];
						System.out.println("column"+column);
						if( condition.equals("max"))
						{
							condition=">";
						}
						else if(condition.equals("min"))
						{
							condition="<";
						}
						else
							condition="=";
						cond += (String) columns.get(i)+condition+column+" and ";
					}
					else
						cond += (String) columns.get(i)+" like '%"+column+"%' and ";
				}
			}else{
				if(column==null || "".equals(column)||"max-".equals(column)||"equ-".equals(column)||"min-".equals(column)){
					cond += "1=1";
				}else{
					if(column.contains("-"))
					{
						System.out.println(column);
						String[] sourceStrArray = column.split("-");
						condition=sourceStrArray[0];
						column=sourceStrArray[1];
						if( condition.equals("max"))
						{
							condition=">";
						}
						else if(condition.equals("min"))
						{
							condition="<";
						}
						else
							condition="=";
						cond += (String) columns.get(i)+condition+column;
					}
					else
						cond += (String) columns.get(i)+" like '%"+column+"%' ";
				}
			}
		}
		session.setAttribute("cond", cond);
		List<List<String>> total_list = new LinkedList<List<String>>();
		Driver = "com.mysql.jdbc.Driver";
		Page page = null;
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(request.getSession().getAttribute("url").toString(),
					request.getSession().getAttribute("name").toString(), request.getSession().getAttribute("pwd").toString());
			Statement stmt = conn.createStatement();
			String sql;
			String sql_count;
			sql_count = "SELECT count(*) from "+table+" where "+cond;
			System.out.println(cond);
			ResultSet res_count = stmt.executeQuery(sql_count);
			int totalCount = 0;

			while(res_count.next()){
				totalCount = res_count.getInt(1);
			}
			String pageNow = request.getParameter("pageNow");
			if (pageNow != null) {
				page = new Page(totalCount, Integer.parseInt(pageNow));
			} else {
				page = new Page(totalCount, 1);
			}
			int start = page.getStartPos();
			int end = page.getPageSize();
			sql = "SELECT * from "+table+" where "+cond+" limit "+start+","+end;
			System.out.println(sql);
			ResultSet res = stmt.executeQuery(sql);
			int col = res.getMetaData().getColumnCount();
			while(res.next()){
				List<String> list = new LinkedList<String>();
				for (int j = 1; j < col; j++) {
					System.out.print(res.getString(j) + "\t");
					list.add(res.getString(j));
				}
				total_list.add(list);
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> columns_seq = new LinkedList<String>();
		for(int i=0;i<columns.size();i++){
			String str = (String) columns.get(i);
			columns_seq.add((String) map.get(str));
		}
		session.setAttribute("columns", columns_seq);
		m.addObject("columns",columns_seq);
		m.addObject("total_list",total_list);
		m.addObject("page", page);
		m.setViewName("Struct/list");
		return m;
	}
	@RequestMapping("/searchByPage")
	@ResponseBody
	public ModelAndView searchByPage(HttpServletRequest request, ModelAndView m){
		HttpSession session = request.getSession();
		String table = (String) session.getAttribute("table");
		List columns = (List)session.getAttribute("column");
		String prop = (String) session.getAttribute("prop_str");
		String condition="";
		Map map = (Map) session.getAttribute("map");
		String cond = "";
		for(int i=0;i<columns.size();i++){
			String column = (String) session.getAttribute((String) columns.get(i));
			//判断是否为最后一个，不需要加and
			if(i<columns.size()-1){
				//判断是否为空
				if(column==null || "".equals(column) ||"max-".equals(column)||"equ-".equals(column)||"min-".equals(column)){
					cond += " 1=1 and ";
				}else{
					//判断是否为数字
					if(column.contains("-"))
					{
						String[] sourceStrArray = column.split("-");
						condition=sourceStrArray[0];
						column=sourceStrArray[1];
						System.out.println("column1"+column);
						if( condition.equals("max"))
						{
							condition=">";
						}
						else if(condition.equals("min"))
						{
							condition="<";
						}
						else
							condition="=";
						cond += (String) columns.get(i)+condition+column+" and ";
					}
					else
						cond += (String) columns.get(i)+" like '%"+column+"%' and ";
				}
			}else{
				if(column==null || "".equals(column) ||"max-".equals(column)||"equ-".equals(column)||"min-".equals(column)){
					cond += "1=1";
				}else{
					if(column.contains("-"))
					{
						String[] sourceStrArray = column.split("-");
						condition=sourceStrArray[0];
						column=sourceStrArray[1];
						if( condition.equals("max"))
						{
							condition=">";
						}
						else if(condition.equals("min"))
						{
							condition="<";
						}
						else
							condition="=";
						cond += (String) columns.get(i)+condition+column;
					}
					else
						cond += (String) columns.get(i)+" like '%"+column+"%'  ";
				}
			}
		}
		List<List<String>> total_list = new LinkedList<List<String>>();
		Driver = "com.mysql.jdbc.Driver";
		Page page = null;
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(request.getSession().getAttribute("url").toString(),
					request.getSession().getAttribute("name").toString(), request.getSession().getAttribute("pwd").toString());
			Statement stmt = conn.createStatement();
			String sql;
			String sql_count;
			sql_count = "SELECT count(*) from "+table+" where "+cond;
			ResultSet res_count = stmt.executeQuery(sql_count);
			int totalCount = 0;
			while(res_count.next()){
				totalCount = res_count.getInt(1);
			}
			String pageNow = request.getParameter("pageNow");
			if (pageNow != null) {
				page = new Page(totalCount, Integer.parseInt(pageNow));
			} else {
				page = new Page(totalCount, 1);
			}
			int start = page.getStartPos();
			int end = page.getPageSize();
			sql = "SELECT * from "+table+" where "+cond+" limit "+start+","+end;
			System.out.println(sql);
			ResultSet res = stmt.executeQuery(sql);
			int col = res.getMetaData().getColumnCount();
			while(res.next()){
				List<String> list = new LinkedList<String>();
				for (int j = 1; j < col; j++) {
					System.out.print(res.getString(j) + "\t");
					list.add(res.getString(j));
				}
				total_list.add(list);
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> columns_seq = new LinkedList<String>();
		for(int i=0;i<columns.size();i++){
			String str = (String) columns.get(i);
			columns_seq.add((String) map.get(str));
		}
		m.addObject("columns",columns_seq);
		m.addObject("total_list",total_list);
		m.addObject("page", page);
		m.setViewName("Struct/list");
		return m;
	}
	@RequestMapping("/poi")
	public void excel(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		List columns = (List) session.getAttribute("columns");
		String cond = (String) session.getAttribute("cond");
		String prop = (String) session.getAttribute("prop_str");
		String table = (String) session.getAttribute("table");
		Driver = "com.mysql.jdbc.Driver";
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(request.getSession().getAttribute("url").toString(),
					request.getSession().getAttribute("name").toString(), request.getSession().getAttribute("pwd").toString());
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT "+prop+" from "+table+" a where "+cond;
			System.out.println("导出表格sql："+sql);
			ResultSet res = stmt.executeQuery(sql);
			int col = res.getMetaData().getColumnCount();
			while(res.next()){
				List<String> row = new ArrayList<String>();
				for(int j = 1; j <= col; j++){
					row.add(res.getString(j));
				}
				list.add(row);
			}
			for(int i=0;i<list.get(0).size();i++){
				System.out.println(list.get(0).get(i));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("table");  //创建table工作薄
		HSSFRow row;
		HSSFCell cell;
		row = sheet.createRow(0);//创建表格行
		for(int j = 0; j < columns.size(); j++) {
			cell = row.createCell(j);//根据表格行创建单元格
			cell.setCellValue(String.valueOf(columns.get(j)));
		}
		//}
		for(int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i+1);//创建表格行
			for(int j = 0; j < list.get(i).size(); j++) {
				cell = row.createCell(j);//根据表格行创建单元格
				cell.setCellValue(list.get(i).get(j));
			}
		}
		try {
			System.out.println(request.getSession().getServletContext().getRealPath("down"));
			wb.write(new FileOutputStream(request.getSession().getServletContext().getRealPath("down")+"\\table.xls"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		//String str = "成功";
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(request.getSession().getServletContext().getRealPath("down")+"\\table.xls");
	}
	@RequestMapping("/down")
	public ResponseEntity<byte[]> download(HttpSession session,HttpServletRequest request) throws IOException{
		String path = request.getSession().getServletContext().getRealPath("down")+"\\table.xls";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		String fileName=new String("table.xls".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
