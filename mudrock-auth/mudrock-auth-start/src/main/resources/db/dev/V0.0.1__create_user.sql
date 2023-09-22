CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `username` varchar(255) NOT NULL COMMENT '用户名',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
    `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `modifier` varchar(255) DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;