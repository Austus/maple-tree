package psn.austus.maple.tree.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("talk_log")
public class TalkLog {

    Long id;

    String question;

    String response;

    Date createTime;
}
