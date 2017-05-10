package com.xiaowo.common.generateno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 主键生成器配置类
 * @author ghy
 * */
@Configuration
public class GenerateNoConfig implements EnvironmentAware {

	private static final Logger logger = LoggerFactory.getLogger(GenerateNoConfig.class);

	@Value("${generateNo.enable:false}")
	private String generateNoEnable;

	private static final String KEY_GENERATENO_GENERATEKEYINFO = "generateNoInfo[%d]";

	private static final int DEFAULT_LENGTH = 10;

	private static final int DEFAULT_INCREMENT = 1;

	private RelaxedPropertyResolver propResolver;
	
	@Autowired
	IGenerateMaxNoService iGenerateMaxNoService;

	/**
	 * 配置代码生成规则
	 */
	@Bean
	public String startGenerateNo() {
		if (generateNoEnable == null || "".equals(generateNoEnable)) {
			generateNoEnable = "false";
		}
		if (Boolean.valueOf(generateNoEnable)) {// 主键-生成器 是否有效
			this.configGenerateNo();
			logger.debug("开启主键生成器-成功-已创建表GenerateKey和GenerateKeyMaxNo");
		}
		return null;
	}

	private void configGenerateNo() {
		List<GenerateNoDto> generateNoDtoList = this.analyzeGenerateNoDto();
		iGenerateMaxNoService.insertGenerateTableKey(generateNoDtoList);
	}
	

	@Override
	public void setEnvironment(Environment environment) {
		this.propResolver = new RelaxedPropertyResolver(environment, "generateNo.");
	}

	private List<GenerateNoDto> analyzeGenerateNoDto() {
		List<GenerateNoDto> generateNoDtoList = new ArrayList<GenerateNoDto>();
		int i = 0;
		while (true) {
			// 读取配置
			if (this.propResolver.getSubProperties(String.format(KEY_GENERATENO_GENERATEKEYINFO,Integer.valueOf(i))).isEmpty()) {
				break;
			}
			String key = "";
			try {
				
				GenerateNoConfig.GenerateNoDto generateNoDto = new GenerateNoConfig.GenerateNoDto();
				key = this.propResolver.getProperty(String.format(KEY_GENERATENO_GENERATEKEYINFO + ".key",Integer.valueOf(i))).trim();
				generateNoDto.setKey(this.propResolver.getProperty(String.format(KEY_GENERATENO_GENERATEKEYINFO + ".key",Integer.valueOf(i))).trim());
				try {
					int increment = Integer.valueOf(this.propResolver.getProperty(String.format(KEY_GENERATENO_GENERATEKEYINFO + ".increment", Integer.valueOf(i))));
					generateNoDto.setIncrement(increment);
				} catch (Exception e) {
					generateNoDto.setIncrement(DEFAULT_INCREMENT);
				}

				try {
					int length = Integer.valueOf(this.propResolver.getProperty(String.format(KEY_GENERATENO_GENERATEKEYINFO + ".length",Integer.valueOf(i))));
					generateNoDto.setLength(length);
				} catch (Exception e) {
					generateNoDto.setLength(DEFAULT_LENGTH);
				}

				try {
					String prefix = this.propResolver.getProperty(String.format(KEY_GENERATENO_GENERATEKEYINFO + ".prefix", Integer.valueOf(i)));
					generateNoDto.setPrefix(prefix);
				} catch (Exception e) {
					generateNoDto.setPrefix("");
				}
				generateNoDtoList.add(generateNoDto);

				logger.debug("读取配置文件获得表生成主键的配置信息，添加 " + key + "成功；");
			} catch (Exception e) {
				logger.error("读取配置文件获得表生成主键的配置信息--失败", e);
			}
			i++;
		}
		return generateNoDtoList;
	}

	/**
	 * 解析对象内部类
	 */
	public class GenerateNoDto implements Serializable {

		private static final long serialVersionUID = 3750784417994560549L;
		/**
		 * 指针长度
		 */
		private String key;

		/**
		 * 前缀
		 */
		private String prefix;
		/**
		 * 最大长度
		 */
		private Integer length;

		/**
		 * 递增长度
		 */
		private Integer increment;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

		public Integer getIncrement() {
			return increment;
		}

		public void setIncrement(Integer increment) {
			this.increment = increment;
		}

		@Override
		public String toString() {
			return "GenerateNoDto [key=" + key + ", prefix=" + prefix
					+ ", length=" + length + ", increment=" + increment + "]";
		}
	}
}
