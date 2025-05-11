package psn.austus.maple.tree.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("log_record")
public class LogRecord {

    Long id;

    String clazz;

    String method;

    String args;

    String result;

    String exception;

    Long executeTime;

    Date createTime;
}
