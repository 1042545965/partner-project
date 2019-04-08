package com.ruoyi.common.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author <a href='mailto:bovenjoy@163.com'>周志豪</a>
 * @version createTime:2017/8/10 15:08 kernel
 */
public class CheckUtil {

    private final static String MOBILE_PATTERN = "^1[3-9]\\d{9}$";

    private final static String USERNAME_PATTERN = "^[a-zA-Z]\\w{3,15}$";

    private final static String PASSWORD_PATTERN = "^\\d+$";

    private final static String Biz_PASSWORD_PATTERN = "^\\d{6}$";

    private final static String Email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean checkMobile(String mobile) {
        return Pattern.compile(MOBILE_PATTERN).matcher(mobile).find();
    }
    public static void main2(String[] args) {
    	System.out.println(checkMobile("13027383692"));
	}

    public static boolean checkUsername(String username) {
        return Pattern.compile(USERNAME_PATTERN).matcher(username).find();
    }

    public static boolean checkPassword(String password) {
        return StringUtils.isNotEmpty(password) && password.length() >= 6 && password.length() <= 20 && !Pattern.compile(PASSWORD_PATTERN).matcher(password).find();
    }

    public static boolean checkName(String name) {
        return StringUtils.isNotEmpty(name) && name.length() > 1;
    }


    public static boolean checkEmail(String email) {
        return Pattern.compile(Email).matcher(email).find();
    }

    /**
     * 校验银行卡卡号是否合法
     * @Title: checkBankCard
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param bankCard
     * @param @return    设定文件
     * @return boolean    返回类型
     * @throws
     */
    public static boolean checkBankCard(String bankCard) {
        if(bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
        if(bit == 'N'){
            return false;
        }
        return bankCard.charAt(bankCard.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     * @Title: getBankCardCheckCode
     * @Description: TODO(从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位)
     * @param nonCheckCodeBankCard
     * @return char    返回类型
     */
    public static char getBankCardCheckCode(String nonCheckCodeBankCard){
        if(nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }

    /**
     * 校验微信账号
     * 微信账号分手机号
     * qq号
     * 邮箱号
     * @param wxCode
     * @return
     */
    public static boolean checkThrid(String wxCode){

        boolean flag = false;
        if(!StringUtils.isNotEmpty(wxCode)){

            if(!StringUtils.isNotEmpty(wxCode)){
                if(wxCode.contains("@")){  //验证邮箱号
                    String check = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?.)+[a-zA-Z]{2,}$";
                    Pattern regex = Pattern.compile(check);
                    Matcher matcher = regex.matcher(wxCode);
                    flag = matcher.matches();
                }else {
                    String reg1 = "[1-9]\\d{5,19}";  //qq号 6 - 20
                    String reg2 = "1[3-9]\\d{9}";  //qq号或者手机号 11
                    String reg3 = "[a-zA-Z][-_a-zA-Z0-9]{5,19}"; //微信号带字母的 6-20
                    flag = wxCode.matches(reg1) || wxCode.matches(reg2) || wxCode.matches(reg3);
                }
            }

        }
        return flag;

    }

    /** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    } 
    
    
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean isHKPhoneLegal(String str)throws PatternSyntaxException {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    } 
    public static boolean checkBizPassword(String BizPwd) {
        return Pattern.compile(Biz_PASSWORD_PATTERN).matcher(BizPwd).find();
    }
    
    /** 
     * 大陆号码或香港号码均可 
     */  
    public static boolean isPhoneLegal(String str)throws PatternSyntaxException {  
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);  
    }  

    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPhoneLegal("15233333333"));
    }
    
    
}
