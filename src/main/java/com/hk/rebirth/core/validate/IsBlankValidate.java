package com.hk.rebirth.core.validate;

//import com.huifu.DclmsService.biz.domain.Record.BaseRecord;
//import com.huifu.DclmsService.biz.exception.BizException;
//import com.huifu.DclmsService.util.constant.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author:dongfei.xu
 * @Description: 通用非空校验类
 * @Date: 2018/8/14 11:15
 */
@Service
public class IsBlankValidate {

    @Autowired
    private static FormatValidate formatDataValidate;

    public static void  isBlack(Map<String, String> map){
        for(String key:map.keySet()){
            if(map.get(key).equals("null") ||  map.get(key).trim().isEmpty()){
//                    throw new BizException(ResponseCode.PARAM_ERROR, "必须参数"+ key +"不能为空");
            }
        }
    };
//
//    public static void commonIsBlack(BaseRecord record){
//        if(StringUtils.isBlank(record.getUserId())){
////            throw new BizException(ResponseCode.PARAM_ERROR, "必须参数userId不能为空");
//        }else {
////            formatDataValidate.lengthValidate(FormatValidate.getLengthVoInstance("userId", record.getUserId(), 32));
////            formatDataValidate.formatValidate(FormatValidate.getFormatVoInstance("userId", record.getUserId()));
//        }
//
//        if(StringUtils.isBlank(record.getUserType())){
////            throw new BizException(ResponseCode.PARAM_ERROR, "必须参数userType不能为空");
//        }else;
////            formatDataValidate.lengthValidate(FormatValidate.getLengthVoInstance("userType", record.getUserType(), 2));
//    }
}
