package com.kunyuesoft.common.utils;

public class IDCardUtil {
	  /**
     * 通过身份证号获取生日和性别
     * @param identifyNumber
     * 
     * @return
     */
    public static String[] getBirthAndSexByIdNo(String identifyNumber){
        
        String dateOfBirth = null;
        
        String gender = null;
        
        //通过身份证获取性别和生日
        if(identifyNumber!=null&&!"".equals(identifyNumber)){
            
            if(identifyNumber.length()==15){
                
                dateOfBirth  = "19"+identifyNumber.substring(6, 8)+"-"+identifyNumber.substring(8, 10)+"-"+identifyNumber.substring(10, 12);
                
                gender = identifyNumber.substring(14, 15);
                
                /*基数为男 偶数为女*/
                if(Integer.parseInt(gender)%2 == 0){
                    gender = "2";
                }else{
                    gender = "1";
                }
            }else if (identifyNumber.length()==18){
                dateOfBirth = identifyNumber.substring(6, 10)+"-"+identifyNumber.substring(10, 12)+"-"+identifyNumber.substring(12, 14);
                
                gender = identifyNumber.substring(16, 17);
                
                /*基数为男 偶数为女*/
                if(Integer.parseInt(gender)%2 == 0){
                    gender = "2";
                }else{
                    gender = "1";
                }
            }
        }
        
        String[] strings = new String[]{dateOfBirth,gender};
        
        return strings;
    }
    
    public static void main(String[] args) {
		
    	String s = "412423293451216231X";
    	
    	String[] birthAndSexByIdNo = getBirthAndSexByIdNo(s);
    	for (String string : birthAndSexByIdNo) {
			System.out.println(string);
		}
	}

}
