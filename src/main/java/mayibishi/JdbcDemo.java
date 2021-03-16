package mayibishi;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {

    }

    /**
     * 删除数据
     */
    public void deleteData() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        String jdbc = "jdbc:mysql://127.0.0.1:3306/mydb?characterEncoding=GBK";
        //链接到数据库
        Connection conn = DriverManager.getConnection(jdbc, "root", "");

        //容器
        Statement state = conn.createStatement();
        //SQL语句
        String sql = "delete from xs where xuehao='1108'";
        //将sql语句上传至数据库执行
        state.executeUpdate(sql);

        //关闭通道
        conn.close();

    }

    /**
     * 添加数据
     */
    public void addData() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        String jdbc = "jdbc:mysql://127.0.0.1:3306/mydb?characterEncoding=GBK";
        //链接到数据库
        Connection conn = DriverManager.getConnection(jdbc, "root", "");

        //容器
        Statement state = conn.createStatement();
        //SQL语句
        String sql = "insert into xs values('1108','张伟','汉企')";
        //将sql语句上传至数据库执行
        state.executeUpdate(sql);
        //关闭通道
        conn.close();
    }

    /**
     * 查询数据
     */
    public void selectData() throws ClassNotFoundException, SQLException {
        //导入驱动包
        Class.forName("com.mysql.jdbc.Driver");
        //链接至数据库
        String jdbc = "jdbc:mysql://127.0.0.1:3306/mydb";
        Connection conn = DriverManager.getConnection(jdbc, "root", "");

        //容器
        Statement state = conn.createStatement();
        //sql语句
        String sql = "select * from xs";
        //将sql语句传至数据库，返回的值为一个字符集用一个变量接收
        ResultSet rs = state.executeQuery(sql);

        //next（）获取里面的内容
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            //getString（n）获取第n列的内容
            //数据库中的列数是从1开始的
        }

        //关闭通道
        conn.close();
    }
}
