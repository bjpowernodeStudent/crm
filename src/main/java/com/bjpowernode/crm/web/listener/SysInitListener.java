package com.bjpowernode.crm.web.listener;

import com.bjpowernode.crm.settings.domain.DicType;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.service.DicService;
import com.bjpowernode.crm.settings.service.impl.DicServiceImpl;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SysInitListener implements ServletContextListener {


    /*

        该方法是用来监听上下文域对象创建的方法
            当上下文域对象创建完毕后，马上执行该方法
            如果该方法执行了，同时也说明了上下文域对象创建了

         参数event：通过该参数可以取得监听的域对象
            例如我们现在监听的是上下文域对象，那么我们就可以通过event参数get到上下文域对象

     */
    public void contextInitialized(ServletContextEvent event) {

        System.out.println("服务器处理数据字典缓存开始");
        //取得上下文域对象
        ServletContext application = event.getServletContext();

        //使用数据字典模块的业务层对象
        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());


        Map<String, List<DicValue>> map = ds.getAll();

        //将map的key和value拆解，保存成为application域对象存值的键值对关系
        Set<String> set = map.keySet();
        for(String key:set){

            application.setAttribute(key,map.get(key));

        }
        System.out.println("服务器处理数据字典缓存结束");

    }
}











































