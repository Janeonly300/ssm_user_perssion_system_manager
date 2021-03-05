package com.atjianyi.dao;

import com.atjianyi.pojo.SystemLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemLogMapper {
    /**
     * 插入数据
     */
    void insertIntoSystemLog(SystemLog systemLog);

    /**
     * 查询所有日志信息
     * @return
     */
    List<SystemLog> selectAllLogs();
}
