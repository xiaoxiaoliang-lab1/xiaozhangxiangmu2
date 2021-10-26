package untity;

import java.util.Map;

import excption.BeanConverteExcpetion;
import org.apache.commons.beanutils.BeanUtils;



public class BeanUtil {
	
	public static <T> T mapToBean(T t,Map<String,? extends Object> map){
		try {
			BeanUtils.populate(t, map);
			return t;
		} catch(Exception e){
//			throw new BeanConverteExcpetion(t.getClass()+"转换出现异常",e);
		}
		return  t;

	} 

}
