package com.xiaowo.common.generateno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.xiaowo.common.generateno.GenerateNoConfig.GenerateNoDto;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service("generateMaxNoService")
@Component
public class GenerateMaxNoService implements IGenerateMaxNoService{
	
	private static final Logger logger = LoggerFactory.getLogger(GenerateMaxNoService.class);
	
	private static final String GENERATE_KEY = "GenerateKey";
	
	private static final String GENERATE_KEY_MAX_NO = "GenerateKeyMaxNo";
	
	@Resource
	private MongoTemplate mongoTemplate;
	
	/**
	 * @Description: 生成最大业务单号
	 * @param prefix         主键前缀组名
	 * @param tableKeyName   生成的业务表名主键
	 */
	@Override
	public String generateMaxNo(String prefix, String tableKeyName) {
        String generateNO = "";
        //定义时间戳 取时间
        String time = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        Query query = new Query();
        query.addCriteria(Criteria.where("tableKeyName").is(tableKeyName));
        GenerateKeyPojo generateKeyPojo = mongoTemplate.findOne(query, GenerateKeyPojo.class,GENERATE_KEY);

        Update update = new Update();
        update.inc("maxNoValue",generateKeyPojo.getIncrement());
        update.set("createtime",createtime);
        GenerateKeyMaxNoPojo generateKeyMaxNoPojo = mongoTemplate.findAndModify(query,update,GenerateKeyMaxNoPojo.class,GENERATE_KEY_MAX_NO);

        if(!(generateKeyMaxNoPojo.getCreatetime().subSequence(0, 10)).equals(createtime.substring(0,10))){
        	generateNO = generateBusinessNo(prefix, time, 0, generateKeyPojo);
            //同步增长最大号
            Update update1 = new Update();
            update1.set("maxNoValue",1);
            update1.set("createtime", createtime);
            update1.set("xiaowoKeyValue", generateNO);
            mongoTemplate.updateFirst(query,update1,GENERATE_KEY_MAX_NO);
            return generateNO;
        }else{
			if(prefix == null){
				generateNO = generateBusinessNo(generateKeyPojo.getPrefix(), time, generateKeyMaxNoPojo.getMaxNoValue(), generateKeyPojo);
			}else{
				generateNO = generateBusinessNo(prefix, time, generateKeyMaxNoPojo.getMaxNoValue(), generateKeyPojo);
			}
			//更新最大号表
			if (generateKeyMaxNoPojo!=null){//数据初始化，不用校验空异常
				Update update1 = new Update();
				update1.set("maxNoValue",generateKeyMaxNoPojo.getMaxNoValue() + generateKeyPojo.getIncrement());
				update1.set("createtime", createtime);
				update1.set("primaryKeyValue", generateNO);
				mongoTemplate.updateFirst(query,update1,GENERATE_KEY_MAX_NO);
			}
			return generateNO;
		}
	}
	
	private String generateBusinessNo(String prefix,String time,int maxNoValue,GenerateKeyPojo generateKeyPojo){
		 if(prefix == null){
        	return generateKeyPojo.getPrefix() + time + getTableNameCodeNo(maxNoValue,generateKeyPojo);
         }else{
        	 return prefix + time + getTableNameCodeNo(maxNoValue,generateKeyPojo);
         }
	}
	
	@Override
	public String generateMaxNo(String tableKeyName) {
		return this.generateMaxNo(null,tableKeyName);
	}
	
	@Override
	public Integer insertGenerateTableKey(GenerateNoDto generateNoDto) {
		Query query = new Query();
        query.addCriteria(Criteria.where("tableKeyName").is(generateNoDto.getKey()));
		if(mongoTemplate.collectionExists(GENERATE_KEY) && mongoTemplate.count(query, GENERATE_KEY) > 0){
			logger.debug(" tableKeyName 已存在:" + generateNoDto.getKey());
			return 0;
		}else {
			//保存某表要生成主键的基本元素
			String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			GenerateKeyPojo enerateKeyPojo = new GenerateKeyPojo();
			enerateKeyPojo.setLength(generateNoDto.getLength());
			enerateKeyPojo.setTableKeyName(generateNoDto.getKey());
			enerateKeyPojo.setIncrement(generateNoDto.getIncrement());
			enerateKeyPojo.setPrefix(generateNoDto.getPrefix());
			enerateKeyPojo.setCreatetime(createtime);
			mongoTemplate.save(enerateKeyPojo, GENERATE_KEY);

			//保存某表的当前最大主键号
			GenerateKeyMaxNoPojo generateKeyMaxNoPojo = new GenerateKeyMaxNoPojo();
			generateKeyMaxNoPojo.setTableKeyName(generateNoDto.getKey());
			generateKeyMaxNoPojo.setCreatetime(createtime);
			generateKeyMaxNoPojo.setMaxNoValue(0);
			generateKeyMaxNoPojo.setPrimaryKeyValue(getTableNameCodeNo(-1,enerateKeyPojo));
			mongoTemplate.save(generateKeyMaxNoPojo,GENERATE_KEY_MAX_NO);
			return 1;
		}
	}
	
	@Override
	public Integer insertGenerateTableKey(List<GenerateNoDto> generateNoDtoList) {
		int count = 0;
		for(GenerateNoDto generateNoDto:generateNoDtoList){
			count = this.insertGenerateTableKey(generateNoDto);
		}
		return count;
	}

	/**
     * 获取业务代码最大数
     */
    private  String getTableNameCodeNo(Integer maxLengthValue,GenerateKeyPojo generateKeyPojo){
        String tableNameCodeMax = "";
        int maxCode = maxLengthValue + generateKeyPojo.getIncrement();
        tableNameCodeMax = String.valueOf(maxCode);
        int i = generateKeyPojo.getLength() - tableNameCodeMax.length();
        //补充0，每个业务代码最大值
        for (int j = 0; j < i; j++){
            tableNameCodeMax = "0" + tableNameCodeMax;
        }
        return tableNameCodeMax;
    }

}
