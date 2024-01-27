package cn.maiaimei.example.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;

public class AutoFillMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "version", LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, "gmtCreate", LocalDateTime.class, LocalDateTime.now());
    this.strictUpdateFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
    // TODO: auto fill gmtCreateUserId and gmtModifiedUserId, get user id from ThreadLocal
    // this.strictInsertFill(metaObject, "gmtCreateUserId", BigDecimal.class, BigDecimal.ONE);
    // this.strictUpdateFill(metaObject, "gmtModifiedUserId", BigDecimal.class, BigDecimal.ONE);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "version", LocalDateTime.class, LocalDateTime.now());
    this.strictUpdateFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
  }
}
