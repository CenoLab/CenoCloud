package com.iot.nero.utils.math;

import com.iot.nero.utils.math.exceptions.NoExpressException;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.iot.nero.utils.math.CONSTANT.CONSTANT.NO_EXPRESS;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/2
 * Time   下午1:44
 */
public class ConditionDo {

    Map<String,String> conditionMap;
    Map<Class<?>,List<String>> classListMap;
    private Class conditionClass;

    public ConditionDo() throws ClassNotFoundException {
        conditionMap = new HashMap<String, String>();
        classListMap = new HashMap<Class<?>, List<String>>();
        initConditionMap();
    }

    private void  initConditionMap() throws ClassNotFoundException {
        List<String> expressBool = new ArrayList<String>();
        List<String> express = new ArrayList<String>();
        expressBool.add("=");
        expressBool.add("!=");
        classListMap.put(java.lang.Boolean.class,expressBool);
        express.add("=");
        express.add("!=");
        express.add(">");
        express.add("<");
        express.add(">=");
        express.add("<=");
        classListMap.put(java.lang.Integer.class,express);
        classListMap.put(java.lang.Double.class,express);

        conditionMap.put(">","isGreaterThan");
        conditionMap.put("<","isLessThan");
        conditionMap.put(">=","isNotMoreThan");
        conditionMap.put("<=","isNotLessThan");
        conditionMap.put("=","isEqualTo");
        conditionMap.put("!=","isNotEqualTo");

        conditionClass = Class.forName("com.iot.nero.utils.math.Condition");
    }
    public Boolean doCondition(Object dataPointValue, String express, String rightValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoExpressException {
        if(!classListMap.containsKey(dataPointValue.getClass())){
            throw new NoExpressException(NO_EXPRESS);
        }
        List<String> cond = classListMap.get(dataPointValue.getClass());
        if(cond==null || cond.isEmpty()){
            throw new NoExpressException(NO_EXPRESS);
        }
        Boolean canCompare = false;
        for(String s: cond){
            if(s.equals(express)){
                canCompare = true;
                break;
            }
        }
        if(canCompare==true){
            Method m = conditionClass.getDeclaredMethod(conditionMap.get(express),Object.class,String.class);
            return (Boolean) m.invoke(conditionClass,dataPointValue,rightValue);
        }else{
            throw new NoExpressException(NO_EXPRESS);
        }
    }

    public static void main(String[] args){
        try {
            //Class cls = Class.forName("com.iot.nero.utils.math.Condition");
            //Method methods = cls.getDeclaredMethod("isEqualTo");
            //System.out.println(methods.invoke(cls,true,"false"));
            ConditionDo conditionDo = new ConditionDo();
            System.out.println(conditionDo.doCondition(false,"=","false"));
            System.out.println(conditionDo.doCondition(1.11,">=","1.0"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoExpressException e) {
            e.printStackTrace();
        }
    }

}
