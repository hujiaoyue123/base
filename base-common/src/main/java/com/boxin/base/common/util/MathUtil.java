package com.boxin.base.common.util;

/**
 * Created by zy on 2015/5/27.
 */
public class MathUtil {


    /**
     * 生成随机的length位数字串
     * @param length
     * @return
     */
    public static String getSpecifyLengthDigit(int length){
        try{
            String code="";
            for(int i=0;i<length;i++){
                int intValue=(int)(Math.random()*10+48);
                code=code+(char)intValue;
            }
            return code;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
