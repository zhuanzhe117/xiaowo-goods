package com.xiaowo.common.generateno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("generateNoUtil")
@Component
public class GenerateNoUtil implements Serializable {

	private static final long serialVersionUID = -4082736551060788865L;
	@Autowired
	private IGenerateMaxNoService iGenerateMaxNoService;
	
	/**
	 * @Title: generateMaxNo  
	 * @Description: 生成最大业务单号 
	 * @param prefix          主键前缀组名
	 * @param tableKeyName   生成的业务表名主键
	 * @author zhao.liang  
	 * @CreateDate: 2016年5月23日 下午13:56:17 
	 */
	public synchronized String generateMaxNo(String prefix,String tableKeyName){
		synchronized(iGenerateMaxNoService){
			return iGenerateMaxNoService.generateMaxNo(prefix, tableKeyName);
		}
	}

	public synchronized String generateMaxNo(String tableKeyName){
		synchronized(iGenerateMaxNoService){
			return iGenerateMaxNoService.generateMaxNo(tableKeyName);
		}
	}

	public synchronized String generateMaxNoDesignatSize(String tableKeyName,Integer size){
		synchronized(iGenerateMaxNoService){
			return iGenerateMaxNoService.generateMaxNo(tableKeyName);
		}
	}
}
