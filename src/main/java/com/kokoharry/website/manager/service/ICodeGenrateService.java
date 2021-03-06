package com.kokoharry.website.manager.service;

import com.kokoharry.website.manager.bean.Class;
import com.kokoharry.website.manager.bean.User;

import java.util.List;

/**
 * Created by luyb on 2017/9/6.
 */
public interface ICodeGenrateService {

   String createTableBySqlUpload(String sql);

   int dropTempTable(String tableName);

   List<Class> getTablesAndColumns(String tableName);

   List<String> getTablesByJDBC(String jdbcUrl, String userName, String password);

   List<Class> getTablesAndColumnsByJDBC(String jdbcUrl, String userName, String password,String tableName);

}
