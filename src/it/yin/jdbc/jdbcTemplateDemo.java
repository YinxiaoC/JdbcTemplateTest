package it.yin.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class jdbcTemplateDemo {
    //1 添加操作
    @Test
    public void add(){
       //配置连接池之前原始创建的样子
         //ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //1 设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_yin");
        dataSource.setUsername("root");
        dataSource.setPassword("136248");

        //创建jdbc模板对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //需要在数据库自己手动创建表
            //创建sql语句
            String sql = "insert into SpringTest_01 values(?,?)";
        int rows = jdbcTemplate.update(sql, "lucy", "250");
        System.out.println(rows);

    }

}
