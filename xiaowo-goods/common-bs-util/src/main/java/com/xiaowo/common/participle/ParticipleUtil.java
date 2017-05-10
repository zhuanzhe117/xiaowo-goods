package com.xiaowo.common.participle;
import org.apache.lucene.analysis.Analyzer;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 分词工具
 * Created by 谷海燕 on 2017/3/18.
 */
public class ParticipleUtil {

    private static Logger logger = LoggerFactory.getLogger(ParticipleUtil.class);
    /**
     * 对字符串进行分词
     * @param content
     * @return
     */
    public static List<String> participleStr(String content){
        List<String> result = new ArrayList<>();
        if(null == content || "".equals(content)){
            return result;
        }
        StringReader reader = null;
        try {

            Analyzer TextIKAnalyzer=new IKAnalyzer(true);
            reader=new StringReader(content);
            TokenStream stream = TextIKAnalyzer.tokenStream("", reader);
            CharTermAttribute term=stream.getAttribute(CharTermAttribute.class);
            while(stream.incrementToken()){
                result.add(term.toString());
            }
            logger.info("对字符串[ " + content + " ]进行分词结果是:" + result);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("对字符串[" + content + "]进行分词发生异常!", e);
        } finally {
            reader.close();
        }
        return result;
    }
}
