package cn.maiaimei.example.mapper;

import cn.maiaimei.example.model.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPO> {

}
