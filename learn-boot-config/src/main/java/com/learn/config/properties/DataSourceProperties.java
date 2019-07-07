package com.learn.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hexinquan on 2018/12/13.
 */
//@Component
//@ConfigurationProperties(prefix = "hexinquan.datasource") 配置类的其中之一方法
public class DataSourceProperties {

    private String diverClassName;
    private String url;
    private String userName;
    private String password;

    public String getDiverClassName() {
        return diverClassName;
    }

    public void setDiverClassName(String diverClassName) {
        this.diverClassName = diverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataSourceConfig{");
        sb.append("diverClassName='").append(diverClassName).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
