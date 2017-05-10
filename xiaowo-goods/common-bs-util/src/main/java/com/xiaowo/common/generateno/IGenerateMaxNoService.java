package com.xiaowo.common.generateno;

import java.util.List;

public interface IGenerateMaxNoService {
	
	/**
	 * @Description: 生成最大业务单号
	 * @param prefix          主键前缀组名
	 * @param tableKeyName    生成的业务表名主键
	 */
    String generateMaxNo(String prefix, String tableKeyName);
    
    /**
	 * @Description: 生成最大业务单号
	 * @param tableKeyName   生成的业务表名主键
	 */
    String generateMaxNo(String tableKeyName);

	Integer insertGenerateTableKey(GenerateNoConfig.GenerateNoDto generateNoDto);

	Integer insertGenerateTableKey(List<GenerateNoConfig.GenerateNoDto> generateNoDtoList);
}
