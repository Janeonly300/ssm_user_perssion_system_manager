package com.atjianyi.service;

import com.atjianyi.pojo.SystemLog;

import java.util.List;

/**
 * @author 简一
 * @className SystemLogService
 * @Date 2021/3/5 15:47
 **/
public interface SystemLogService {
    /**
     * 存储日志数据
     * @param systemLog
     */
    void insertSystemLog(SystemLog systemLog);

    /**
     * 查询所有日志
     * @return
     */
    List<SystemLog> findAllLog();
}
