package com.kokoharry.common.util;

/**
 * Created by luyb on 2017/9/27.
 */

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * 自定义一个ShiroTagFreeMarkerConfigurer继承Spring本身提供的FreeMarkerConfigurer,目的是在FreeMarker的Configuration中添加shiro的配置
 * @author q
 *
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
}