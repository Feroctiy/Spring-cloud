package com.lpg.user.jedis;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lPG
 * @version 1.0
 * @Description redis频道枚举
 * @date 2020-06-11 17:15
 */
@AllArgsConstructor
public enum RedisChannelEnum {
    USER("lpg-user","用户频道"),
    OTHER("lpg-other","其他");
    private String channel;
    private String comment;

    public String getChannel() {
        return channel;
    }

    public String getComment() {
        return comment;
    }
}
