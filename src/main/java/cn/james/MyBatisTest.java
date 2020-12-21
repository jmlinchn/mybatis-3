package cn.james;

import cn.james.dao.IUserDao;
import cn.james.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * MyBatis测试类
 *
 * @author James Lin
 * @date 2020/12/21
 */
public class MyBatisTest {

  public static void main(String[] args) throws IOException {
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    // 重点关注 org.apache.ibatis.builder.xml.XMLConfigBuilder#parseConfiguration
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));

    // 配置 sqlSession的事务管理和executor执行器
    SqlSession sqlSession = sqlSessionFactory.openSession();
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);

    // 重点关注mapper执行方法： org.apache.ibatis.binding.MapperMethod.execute
    List<User> users = userDao.selectAll();

    for (User user : users) {
      System.out.println(user);

    }
  }
}
