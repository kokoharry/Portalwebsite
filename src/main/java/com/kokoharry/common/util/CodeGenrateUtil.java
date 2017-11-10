package com.kokoharry.common.util;

import com.kokoharry.website.manager.bean.Class;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luyb on 2017/10/18.
 */
public class CodeGenrateUtil {

    private static Logger logger = LogManager.getLogger(CodeGenrateUtil.class);

    private final static String BEAN_TEMPLATE_NAME="BeanTemplate.ftl";
    private final static String ISERVICE_TEMPLATE_NAME="IServiceTemplate.ftl";
    private final static String MAPPER_TEMPLATE_NAME="MapperTemplate.ftl";

    private final static String TEMPLATE_PATH="freemarkerTemplates";

    private final static String TEM_FILES_PATH="tempFiles/";

    @Resource
    private static Configuration cfg;
    /**
     * 初始化工作
     */
    private static void init(String path) throws Exception {
        // 负责管理的实例创建+设置模板文件所在的目录
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(path+"/"+TEMPLATE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public static List<File> process(String scope, List<Class> list, String tableName,String path) throws Exception {
        if(cfg == null){
            init(path);
        }
        List<File> files = new ArrayList<>();
        for(Class classObj : list){
            Map<String, Object> root = new HashMap<>();
            root.put("class",classObj);
            files.addAll(write(root,scope,tableName,classObj.getClassname(),path));
        }
        return files;

    }

    /*
     * 将模版进行指定文件的输出
     */
    public static List<File> write(Map<String, Object> root,String scope,String tableName,String fileName,String path) throws
            IOException, TemplateException{
        List<File> files = new ArrayList<>();
        String tempFilePath = path + TEM_FILES_PATH + tableName;
        logger.debug("临时文件生成目录为"+tempFilePath);
        File f = new File(tempFilePath);
        if(!f.exists()){
            try {
                f.mkdirs();
            } catch (Exception e) {
                logger.error("生成临时文件目录错误",e);
            }
        }
        if(scope.contains("BEAN")){
            Template template = cfg.getTemplate(BEAN_TEMPLATE_NAME);
            File fileResult = new File(tempFilePath, fileName+".java");
            OutputStream fos = new  FileOutputStream(fileResult); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            template.process(root,out);
            fos.flush();
            fos.close();
            files.add(fileResult);
        }
        if(scope.contains("ISERVICE")){
            Template template = cfg.getTemplate(ISERVICE_TEMPLATE_NAME);
            File fileResult = new File(tempFilePath, "I"+fileName+"Service.java");
            OutputStream fos = new  FileOutputStream(fileResult); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            template.process(root,out);
            fos.flush();
            fos.close();
            files.add(fileResult);
        }
        if(scope.contains("MAPPER")){
            Template template = cfg.getTemplate(MAPPER_TEMPLATE_NAME);
            File fileResult = new File(tempFilePath, fileName+"Mapper.java");
            OutputStream fos = new  FileOutputStream(fileResult); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            template.process(root,out);
            fos.flush();
            fos.close();
            files.add(fileResult);
        }
        return files;
    }
}
