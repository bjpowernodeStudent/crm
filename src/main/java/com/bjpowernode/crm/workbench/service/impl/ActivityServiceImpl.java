package com.bjpowernode.crm.workbench.service.impl;



import com.bjpowernode.crm.utils.SqlSessionUtil;

import com.bjpowernode.crm.vo.PaginationVo;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.dao.ActivityRemarkDao;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;

import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {
   private ActivityDao activityDao= SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class );
   private ActivityRemarkDao activityRemark=SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);

   public Boolean save(Activity activity) {
      Boolean flag=true;
      int count=activityDao.save(activity);
      if (count!=1){
         flag=false;
      }
      return flag;
   }

   public PaginationVo<Activity> pageList(Map<String, Object> map) {
      //取total
      int total = activityDao.getTotalByCondition(map);

      //取dataList
      List<Activity> dataList = activityDao.getActivityListByCondition(map);

      //创建一个PaginationVo对象
      PaginationVo<Activity> vo = new PaginationVo<Activity>();
      //将total和dataList封装到vo对象中
      vo.setTotal(total);
      vo.setDataList(dataList);


      //将vo返回到控制器
      return vo;
   }

}
