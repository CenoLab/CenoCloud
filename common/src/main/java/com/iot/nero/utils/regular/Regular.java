package com.iot.nero.utils.regular;

import java.util.regex.Pattern;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/19
 * Time   下午7:49
 */
public class Regular {
    /**
     * 验证手机号码
     *
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellPhone(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        return Pattern.matches(regex,cellphone);
    }
    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return Pattern.matches(regex,email);
    }
}
