package com.kokoharry.website.manager.dao;

import com.kokoharry.common.util.BaseMapper;
import com.kokoharry.website.manager.bean.Class;
import com.kokoharry.website.manager.bean.Property;
import com.kokoharry.website.manager.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("codeGenrateMapper")
public interface CodeGenrateMapper extends BaseMapper<Object> {

    int doSql(String value);

    int doDropTable(String value);

    List<Property> selectColumns(String tableName);

    List<Class> selectTables(String tableName);

}