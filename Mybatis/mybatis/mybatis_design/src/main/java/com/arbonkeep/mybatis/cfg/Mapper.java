package com.arbonkeep.mybatis.cfg;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 12:54
 * 用于封装执行的SQL语句以及结果类型的全限定类名
 *
 */
public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
