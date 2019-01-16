package com.iot.nero.utils.math;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/2
 * Time   下午1:45
 */
public class Condition {

    /**
     * >
     * @param left
     * @param rightValue
     * @return
     */
    public static Boolean isGreaterThan(Object left,String rightValue){
        if(left instanceof Integer){
            return (Integer) left > Integer.valueOf(rightValue);
        }else if(left instanceof Double){
            return (Double) left > Double.valueOf(rightValue);
        }else {
            return true;
        }
    }

    /**
     * <
     * @param left
     * @param rightValue
     * @return
     */
    public static Boolean isLessThan(Object left,String rightValue){
        if(left instanceof Integer){
            return (Integer) left < Integer.valueOf(rightValue);
        }else if(left instanceof Double){
            return (Double) left < Double.valueOf(rightValue);
        }else {
            return true;
        }
    }

    /**
     * >=
     * @param left
     * @param rightValue
     * @return
     */
    public static Boolean isNotMoreThan(Object left,String rightValue){
        if(left instanceof Integer){
            return (Integer) left >= Integer.valueOf(rightValue);
        }else if(left instanceof Double){
            return (Double) left >= Double.valueOf(rightValue);
        }else {
            return true;
        }
    }

    /**
     * <=
     * @param left
     * @param rightValue
     * @return
     */
    public static Boolean isNotLessThan(Object left,String rightValue){
        if(left instanceof Integer){
            return (Integer) left <= Integer.valueOf(rightValue);
        }else if(left instanceof Double){
            return (Double) left <= Double.valueOf(rightValue);
        }else {
            return true;
        }
    }

    /**
     * =
     * @param left
     * @param rightValue
     * @return
     */
    public static Boolean isEqualTo(Object left,String rightValue){
        if(left instanceof Integer){
            return (Integer) left == Integer.valueOf(rightValue);
        }else if(left instanceof Double){
            return (Double) left == Double.valueOf(rightValue);
        }else if(left instanceof Boolean){
            return (Boolean) left == Boolean.valueOf(rightValue);
        }else{
            return true;
        }
    }

    /**
     * !=
     * @param left
     * @param rightValue
     * @return
     */
    public static Boolean isNotEqualTo(Object left,String rightValue){
        if(left instanceof Integer){
            return (Integer) left != Integer.valueOf(rightValue);
        }else if(left instanceof Double){
            return (Double) left != Double.valueOf(rightValue);
        }else if(left instanceof Boolean){
            return (Boolean) left != Boolean.valueOf(rightValue);
        }else{
            return true;
        }
    }
}
