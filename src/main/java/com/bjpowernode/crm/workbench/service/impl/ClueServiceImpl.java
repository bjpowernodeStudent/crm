package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.utils.ServiceFactory;
import com.bjpowernode.crm.utils.SqlSessionUtil;
import com.bjpowernode.crm.workbench.dao.ClueDao;
import com.bjpowernode.crm.workbench.domain.Clue;
import com.bjpowernode.crm.workbench.service.ClueService;

public class ClueServiceImpl implements ClueService {
    private ClueDao clueDao=SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);

    public boolean save(Clue c) {
        boolean flag=true;
        int count=clueDao.save(c);
        if (count!=1){
            return flag=false;
        }
        return flag;
    }
}
