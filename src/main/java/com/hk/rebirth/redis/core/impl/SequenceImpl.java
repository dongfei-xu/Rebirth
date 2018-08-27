package com.hk.rebirth.redis.core.impl;

import com.hk.rebirth.redis.core.ISequence;
import com.hk.rebirth.util.core.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author:dongfei.xu
 * @Description:
 * @Date: 2018/6/15 14:13
 */
@Service
@Slf4j
public class SequenceImpl implements ISequence{

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String redisPrefix = "Rebirth_";


    @Override
    public String universalSequence() {
        return getSequence("universal_Sequence");
    }


    private Long increase(String key){
        return increase(key, 1L, 0);
    };

    private Long increase(String key, Long d, int i){
        try {
            Long result = redisTemplate.opsForValue().increment(key, d);
            return result;
        } catch (Exception ex) {
            if (i == 3) {
                throw new RuntimeException(ex);
            }
            i++;
            return this.increase(key, d, i);
        }
    };

    private String getSequence(String seqName){
        String upperSeqName = seqName.toUpperCase();
        try {
            //如果16位字段长度,每秒100万,从1970年1月1日零时起共可使用317年左右
            long dateTmp = System.currentTimeMillis()/1000;
            return dateTmp
                    + StringUtils
                    .leftPad(Long.toString(this.increase(redisPrefix.toUpperCase() + upperSeqName)), 6, "0");
        } catch (Exception e) {
            log.error("Get sequence error，sequence name: {"+upperSeqName+"}", e);
            throw new NullPointerException();
        }
    }

    private String getSequence(String seqName, String args){
        String upperSeqName = seqName.toUpperCase();
        try {
            //如果16位字段长度,每秒100万,从1970年1月1日零时起共可使用317年左右
            String dateTmp = DateUtils.formatDateTime(new Date(), "yyyyMMdd");
            return dateTmp
                    + StringUtils
                    .leftPad(Long.toString(this.increase(redisPrefix.toUpperCase() + upperSeqName)), 8, "0");
        } catch (Exception e) {
            log.error("Get sequence error，sequence name: {"+upperSeqName+"}", e);
            throw new NullPointerException();
        }
    }
}
