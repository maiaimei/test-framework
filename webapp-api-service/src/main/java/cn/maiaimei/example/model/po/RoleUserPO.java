package cn.maiaimei.example.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("sys_role_user")
public class RoleUserPO {

  @TableId
  private Long id;
  @TableField("role_id")
  private Long roleId;
  @TableField("user_id")
  private Long userId;
  @TableField(value = "gmt_create", fill = FieldFill.INSERT)
  private LocalDateTime gmtCreate;
  @TableField(value = "gmt_create_user_id", fill = FieldFill.INSERT)
  private Long gmtCreateUserId;
  @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime gmtModified;
  @TableField(value = "gmt_modified_user_id", fill = FieldFill.INSERT_UPDATE)
  private Long gmtModifiedUserId;
}
