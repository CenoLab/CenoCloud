package com.iot.nero.utils.math;

import com.iot.nero.utils.math.CONSTANT.CONSTANT;
import com.iot.nero.utils.math.exceptions.NoMathMethodException;
import com.mchange.v1.util.ArrayUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/31
 * Time   下午6:58
 */
public class MathCompute {
    private Map<String,String> methodStatisticsMap;
    private Map<String,String> methodConversionMap;
    private Class statisticsCls;
    private Class conversionCls;

    public MathCompute() throws ClassNotFoundException {
        this.methodStatisticsMap = new HashMap<String, String>();
        this.methodConversionMap = new HashMap<String, String>();
        initMethod();
    }

    private void initMethod() throws ClassNotFoundException {
        statisticsCls = Class.forName("com.iot.nero.utils.math.DataStatisticsUtils");
        conversionCls = Class.forName("com.iot.nero.utils.math.DataConversionUtils");

        methodStatisticsMap.put("getMax","getMax");
        methodStatisticsMap.put("getMin","getMin");
        methodStatisticsMap.put("getSum","getSum");
        methodStatisticsMap.put("getMean","getMean");
        methodStatisticsMap.put("getMode","getMode");
        methodStatisticsMap.put("getMedian","getMedian");
        methodStatisticsMap.put("getMidrange","getMidrange");
        methodStatisticsMap.put("getQuartiles","getQuartiles");
        methodStatisticsMap.put("getRange","getRange");
        methodStatisticsMap.put("getQuartilesRange","getQuartilesRange");
        methodStatisticsMap.put("getVariance","getVariance");
        methodStatisticsMap.put("getAbsoluteAverageDeviation","getAbsoluteAverageDeviation");
        methodStatisticsMap.put("getMedianAbsoluteDeviation","getMedianAbsoluteDeviation");
        methodStatisticsMap.put("getStandardDevition","getStandardDevition");

        methodConversionMap.put("minMaxNormalize","minMaxNormalize");
        methodConversionMap.put("zScoreNormalize","zScoreNormalize");
        methodConversionMap.put("decimalsNormalize","decimalsNormalize");
    }

    public Double[] executeMathCompute(String method, List<Double> dataPointList) throws NoMathMethodException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(methodStatisticsMap.containsKey(method)){
            return executeMathStaticsCompute(methodStatisticsMap.get(method),dataPointList);
        }else if(methodConversionMap.containsKey(method)){
            return executeConversionCompute(methodConversionMap.get(method),dataPointList);
        }else{
            throw new NoMathMethodException(CONSTANT.NO_MATH_METHOD);
        }
    }

    public Double[] executeMathStaticsCompute(String method, List<Double> dataPointList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = statisticsCls.getDeclaredMethod(method,double[].class);
        Double[] arr = dataPointList.toArray(new Double[dataPointList.size()]);
        double[] target = new double[dataPointList.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = dataPointList.get(i);
        }
        return new Double[]{(Double)m.invoke(statisticsCls, target)};
    }
    public Double[] executeConversionCompute(String method, List<Double> dataPointList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = conversionCls.getDeclaredMethod(method,double[].class);
        Double[] arr = dataPointList.toArray(new Double[dataPointList.size()]);
        double[] target = new double[dataPointList.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = dataPointList.get(i);
        }
        double[] result = (double[]) m.invoke(conversionCls,target);

        Double[] doubles = new Double[result.length];
        for(int i = 0;i<result.length;i++){
            doubles[i] = result[i];
        }
        return doubles;
    }

//    public static void main(String[] args){
//        try {
//            MathCompute mathCompute = new MathCompute();
//            List<Double> doubles = new ArrayList<Double>();
//            doubles.add(1.0);
//            doubles.add(2.0);
//            doubles.add(3.0);
//            doubles.add(4.0);
//            doubles.add(8.0);
//            doubles.add(4.0);
//            for(Map.Entry e : mathCompute.methodStatisticsMap.entrySet()) {
//                Double[] doubles1 = mathCompute.executeMathCompute(e.getValue().toString(), doubles);
//                for(Double d:doubles1){
//                    System.out.println(d);
//                }
//            }
//            for(Map.Entry e : mathCompute.methodConversionMap.entrySet()) {
//                Double[] doubles1 = mathCompute.executeMathCompute(e.getValue().toString(), doubles);
//                for(Double d:doubles1){
//                    System.out.println(d);
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (NoMathMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }
}
