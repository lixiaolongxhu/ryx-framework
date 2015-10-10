package com.framework.ext.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类
 * 
 * @author lixiaolong
 * @date 2014-03-01
 */
public class ToolHelper {

	/**
	 * 时间类型数据转换为 字符串 lxl
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	@Deprecated
	public static String dateToString(Date date, int type) {
		try {

			if (date == null) {
				return null;
			}

			if (type == 0) {

				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				return sdf.format(date);
			}
			if (type == 1) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(date);
			}
			if (type == 2) {

				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss E");
				return sdf.format(date);
			}

			if (type == 3) {

				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss.SSS");
				return sdf.format(date);
			}
			if (type == 4) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				return sdf.format(date);
			}
			if (type == 5) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				return sdf.format(date);
			}

		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return "";
	}

	/**
	 * 判断 字符串 是否为空， 非空返回true lxl
	 * 
	 * @param str
	 * @return
	 */

	public static boolean isNotEmpty(String str) {
		if (str == null || str.trim().toString().equals("")
				|| str.trim().equals("null")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().toString().equals("")
				|| str.trim().equals("null")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为空 或者为零
	 * 
	 * @param str
	 * @return
	 */

	public static boolean isNotEmpty(Integer str) {
		if (str == null || str == 0) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean isEmpty(Integer str) {
		if (str == null || str == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断list 是否有记录
	 * 
	 * @param list
	 * @return
	 */

	public static boolean isNotEmpty(List<?> list) {
		if (list == null || list.size() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean isEmpty(List<?> list) {
		if (list == null || list.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断object 是否有记录
	 * 
	 * @param object
	 * @return
	 */

	public static boolean isNotEmpty(Object object) {
		if (object == null ) {
			return false;
		}else if(object.toString().trim().equals("")){
			return false;
		}else  {
			return true;
		}
	}
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}else if(object.toString().trim().equals("")){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 获得 uuid
	 * 
	 * @return lxl
	 */

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 字符串 相同
	 * 
	 * @param targetBean
	 * @param srcBean
	 * @return
	 */

	public static boolean equalsString(String source, String target) {
		String sourceStr=source;
		String targetStr=target;
		if (sourceStr == null && targetStr == null) {
			return true;
		} else if (sourceStr == null && targetStr != null) {
			return false;
		} else if (sourceStr != null && targetStr == null) {
			return false;
		} else {
			return sourceStr.trim().toString().equals(targetStr.trim().toString());
		}
	}

	/**
	 * 隐藏身份证号的显示
	 */

	public static String hideIdcard(String idcard) {
		if (idcard == null || idcard.length() < 10) {
			return idcard;
		} else {
			String hidenidcard = idcard.substring(0, 4) + "****"
					+ idcard.substring(idcard.length() - 4, idcard.length());
			return hidenidcard;
		}
	}

	
	/**
	 * 判断传入的字符串是否是手机号
	 * @param str
	 * @return
	 */
	public static boolean isMobilePhoneNum(String str){
		  if(!ToolHelper.isNotEmpty(str)){
			  return false;
		  }
		  String pattern = "^(13[0-9]|15[01]|153|15[6-9]|180|18[123]|18[5-9]|1[0-9][0-9])\\d{8}$";
//		  String pattern="^((13[0-9])|(15[^4,\\D])|(18[0,1-9]))\\d{8}$" ;
		  return str.matches (pattern); 
	}
	
	/**
	 * 校验登录名 ，登录名，只能是数字，或者字母，下划线
	 * @param userName
	 * @return
	 */
	public static boolean checkUserName(String userName) {
		  String regex = "[A-Za-z0-9_]+";
		  Pattern p = Pattern.compile(regex);
		  Matcher m = p.matcher(userName);
		  return m.matches();
	}
	
	/**
	 * 生成随机数字和字母,  
	 * @param length  生成的随机字符串的长度
	 * @return
	 */
    public static String getRandomString(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  
    
    /**
     * 获取随机数字
     * @param n
     * @return
     */
    public static String getRandomNumber(int n) {
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException("cannot random " + n + " bit number");
        }
        Random ran = new Random();
        if (n == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        int bitField = 0;
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            while(true) {
                int k = ran.nextInt(10);
                if( (bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    chs[i] = (char)(k + '0');
                    break;
                }
            }
        }
        return new String(chs);
    }
    
    /**
     * 获取指定位数的随机大写字母串
     * @param n
     * @return
     */
    public static String getRandomCapitalChars(int  n){
    	if (n < 1 || n > 10) {
            throw new IllegalArgumentException("cannot random " + n + " bit number");
        }
    	StringBuilder str=new StringBuilder("");
    	for(int i=0;i<n;i++){
    		 String chars="ABCDEFGHJKMNPQRSTUVWXYZ";
        	 str.append(chars.charAt((int)(Math.random() * 23)));
    	}
    	return str.toString();
    }
    
    /**
     * 获取交易的订单号
     * @return
     */
    public static String  getOrderNum(){
		String timestamp = ToolHelper.dateToString(new Date(), 5);
		String random = String.valueOf(getRandomNumber(5));
		return timestamp+random;
    }
    
     
    /**
     * 获取随机文件名
     */
    public static String getFileNameRandom(){
    	String timestamp = ToolHelper.dateToString(new Date(), 5);
		String random = String.valueOf(getRandomNumber(5));
		return timestamp+random;
    }
    
    /*** 
     * 判断 String 是否int 
     *  
     * @param input 
     * @return 
     */  
    public static boolean isNotInteger(String input){  
    	if(isEmpty(input)){
    		return true;
    	}
        Matcher mer = Pattern.compile("^\\d*[1-9]\\d*$").matcher(input);  
        return  !mer.find();  
    }  
    
     
    
    
    
    public static void main(String[] args){
    	
//    	System.out.println(getRandomString(4));
//    	
//    	System.out.println(getRandomNumber(4));
//    
//    	System.out.println(isMobilePhoneNum("17742512547"));
//    	
//    	System.out.println(getOrderNum().length());
//    	System.out.println(getOrderNum());
//    	

//    	
//    	System.out.println("获取文件名 ： " +getFileNameRandom());
//    	System.out.println("获取文件名长度 ： " +getFileNameRandom().length());
//    	
//    	for(int i=0;i<1000;i++){
//    		System.out.println(ToolHelper.getRandomCapitalChars(3));
//    	}
    	
//    	System.out.println(isNotInteger("2"));
//    	System.out.println(isNotInteger("20"));
//    	System.out.println(isNotInteger("20.0"));
//    	System.out.println(isNotInteger("00.0"));
//    	System.out.println(isNotInteger("00.1"));
    }
}
