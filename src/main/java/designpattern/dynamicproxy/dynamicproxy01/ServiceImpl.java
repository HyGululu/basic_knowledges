package designpattern.dynamicproxy.dynamicproxy01;

import java.sql.SQLException;

public class ServiceImpl implements IService{
    @Override
    public void foo() throws SQLException {
        throw new SQLException("I test throw an checked Exception");
    }
}
