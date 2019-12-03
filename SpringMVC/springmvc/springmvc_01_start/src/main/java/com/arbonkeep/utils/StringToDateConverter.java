package com.arbonkeep.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author arbonkeep
 * @date 2019/12/3 - 12:45
 *将字符串转换为日期类型
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * 转换的方法
     * @param source 需要转换的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if(source == null) {
            throw new RuntimeException("数据为null");
        }
        //获取格式化对象
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        try {
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("类型转换出错");
        }
    }
}
