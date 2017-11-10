package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.service.ICodeGenrateService;
import com.kokoharry.website.manager.service.IMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by luyb on 2017/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:spring-mybatis.xml" })
public class CodeGenrateServiceImplTest {

    @Resource
    public ICodeGenrateService codeGenrateService;

    @Test
    public void createTableBySqlUpload() throws Exception {
        String sql = "CREATE TABLE `amass_event`  (" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 自增主键'," +
                "  `device_type` bigint(20) DEFAULT NULL COMMENT '设备类型'," +
                "  `log_original` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日志原文'," +
                "  `log_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日志等级'," +
                "  `number` int(11) DEFAULT NULL COMMENT '数量缺省1 全局'," +
                "  `module` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '模块'," +
                "  `log_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日志类型'," +
                "  `protocol` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '协议 全局'," +
                "  `src_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '源IP'," +
                "  `dest_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目的IP'," +
                "  `event` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '事件'," +
                "  `event_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '事件摘要'," +
                "  `src_port` int(11) DEFAULT NULL COMMENT '源端口'," +
                "  `dest_port` int(11) DEFAULT NULL COMMENT '目的端口'," +
                "  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称'," +
                "  `attribute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '属性'," +
                "  PRIMARY KEY (`id`) USING BTREE" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收集事件' ROW_FORMAT = Compact;";
        String i  = codeGenrateService.createTableBySqlUpload(sql);
    }

    @Test
    public void dropTempTable()  throws Exception {
        String tableName = "tempTable_testd803a5a1-3d73-4662-b815-247fe1734d8a";
        int i  = codeGenrateService.dropTempTable(tableName);

    }
    @Test
    public void test(){
        String path = "E:\\MyWork\\Portalwebsite\\target\\Portalwebsite\\tempFiles\\tempTable_amass_event_c3cccf9f" +
                "-025b-414b-85c3-420a82cb8966\\com\\kokoharry\\bean";
        File f = new File(path);
        if(!f.exists()){
            try {
                f.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}