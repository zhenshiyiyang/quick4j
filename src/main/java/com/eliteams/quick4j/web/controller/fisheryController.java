package com.eliteams.quick4j.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

@Controller
@RequestMapping("/fishery")
public class fisheryController {
    private String url = "jdbc:hive2://master:10000/default";
    @RequestMapping("/trajectory")
    public void trajectory(HttpServletRequest request, Model model) throws SQLException {
        //String url = "jdbc:hive2://master:10000/default";
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM t4";
        System.out.println("Running"+sql);
        ResultSet res = stmt.executeQuery(sql);
        while(res.next()){
            System.out.println("id: "+res.getInt(1));
        }
    }
    @RequestMapping("/overbound")
    public void overbound(HttpServletRequest request, Model model) throws SQLException {
        //String url = "jdbc:hive2://master:10000/default";
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM t4";
        System.out.println("Running"+sql);
        ResultSet res = stmt.executeQuery(sql);
        while(res.next()){
            System.out.println("id: "+res.getInt(1));
        }
    }
}
