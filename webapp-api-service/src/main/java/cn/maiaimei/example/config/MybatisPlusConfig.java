package cn.maiaimei.example.config;

import cn.maiaimei.example.mybatisplus.AutoFillMetaObjectHandler;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan("cn.maiaimei.example.mapper")
@Configuration
public class MybatisPlusConfig {

  /**
   * 自动填充功能
   *
   * @return MetaObjectHandler
   */
  @Bean
  public AutoFillMetaObjectHandler autoFillMetaObjectHandler() {
    return new AutoFillMetaObjectHandler();
  }

  /**
   * 配置插件
   *
   * @return MybatisPlusInterceptor
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 配置乐观锁插件
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    // 防全表更新与删除插件
    interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
    // 如果配置多个插件，切记分页最后添加。如果有多数据源可以不配具体类型，否则都建议配上具体的DbType
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
  }
}
