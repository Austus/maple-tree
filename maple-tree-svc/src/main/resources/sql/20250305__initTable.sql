CREATE TABLE IF NOT EXISTS  talk_log(
                         ID BIGINT(20)  NOT NULL  COMMENT '主键' ,
                         question VARCHAR(20)  NOT NULL   COMMENT '问题' ,
                         response VARCHAR(200)  NOT NULL  COMMENT '回应' ,
                         `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `idx_question`(`question`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '谈话记录表' ROW_FORMAT = DYNAMIC;



CREATE TABLE IF NOT EXISTS  log_record(
                         ID BIGINT(20)  NOT NULL  COMMENT '主键' ,
                         clazz VARCHAR(200)  NOT NULL  COMMENT '执行的类型' ,
                         method VARCHAR(200)  NOT NULL  COMMENT '执行的方法' ,
                         args VARCHAR(2000)  NOT NULL   COMMENT '请求参数' ,
                         result VARCHAR(2000)  NOT NULL  COMMENT '返回参数' ,
                         exception VARCHAR(2000)  NOT NULL  COMMENT '异常信息' ,
                         `execute_time` bigint(20) NULL DEFAULT NULL COMMENT '执行时间',
                         `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '执行方法记录表' ROW_FORMAT = DYNAMIC;



