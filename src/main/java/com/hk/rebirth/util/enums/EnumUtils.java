package com.hk.rebirth.util.enums;

import lombok.val;
import org.apache.commons.lang3.StringUtils;

public class EnumUtils {

    /**
     *
     * @param code
     * @return
     */
    public static Boolean isContains(String code){
        RebirthStatusEnum[] values = RebirthStatusEnum.values();
        for(RebirthStatusEnum value :values){
            if(StringUtils.equals(code, value.getCode())){
                return true;
            }
        }
        return false;
    }

}
