package com.atjianyi.service.impl;

import com.atjianyi.dao.SystemLogMapper;
import com.atjianyi.pojo.SystemLog;
import com.atjianyi.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简一
 * @className SystemLogService
 * @Date 2021/3/5 15:48
 **/
@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogMapper systemLogMapper;
    @Override
    public void insertSystemLog(SystemLog systemLog) {
        systemLogMapper.insertIntoSystemLog(systemLog);
    }

    /**
     * 查询所有日志
     * @return
     */
    @Override
    public List<SystemLog> findAllLog() {
        return systemLogMapper.selectAllLogs();
    }
}
