package cn.maiaimei.example.service;

import cn.maiaimei.example.model.dto.BaseQueryParam;
import cn.maiaimei.example.model.dto.BaseQueryResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.springframework.beans.BeanUtils;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends
    ServiceImpl<M, T> {

  public <R> void pageList(BaseQueryResult<R> result, BaseQueryParam param,
      LambdaQueryWrapper<T> wrapper, Supplier<R> recordSupplier) {
    pageList(result, param, wrapper, recordSupplier, null);
  }

  public <R> void pageList(BaseQueryResult<R> result, BaseQueryParam param,
      LambdaQueryWrapper<T> wrapper, Supplier<R> recordSupplier, Consumer<R> recordConsumer) {
    IPage<T> page = new Page<>();
    page.setCurrent(param.getCurrent());
    page.setSize(param.getSize());
    List<T> list = list(page, wrapper);
    result.setTotal(page.getTotal());
    result.setSize(page.getSize());
    result.setCurrent(page.getCurrent());
    result.setRecords(new ArrayList<>());
    for (T item : list) {
      final R record = recordSupplier.get();
      BeanUtils.copyProperties(item, record);
      recordConsumer.accept(record);
      result.getRecords().add(record);
    }
  }
}
