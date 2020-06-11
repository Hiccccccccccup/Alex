package com.jozz.alex.service;

import com.jozz.alex.Constant;
import com.jozz.alex.entity.TConvertUrl;
import com.jozz.alex.mapper.TConvertUrlMapper;
import com.jozz.alex.util.ConvertUtil;
import com.jozz.alex.util.RedisUtil;
import javafx.scene.shape.TriangleMesh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ConvertService {
    @Autowired
    private TConvertUrlMapper convertUrlMapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 将源URL转换为短URL
     * @param srcUrl
     * @return
     */
    public String converFromSrcUrl(String srcUrl){
        String surfix = null;
        //查询缓存
        Object exist = redisUtil.get(srcUrl);
        if (exist != null) {
            surfix = (String) exist;
        }else {
            //缓存不存在,从DB插入
            TConvertUrl tc = new TConvertUrl();
            tc.setUrl(srcUrl);
            tc.setCreateDt(new Date());
            convertUrlMapper.insertSelective(tc);
            Integer id = tc.getId();
            surfix = ConvertUtil.convertTo(id, 64);
            //放入缓存,失效时间1小时
            redisUtil.set(srcUrl,surfix,3600);
        }
        return Constant.prefix.concat(surfix);
    }

    /**
     * 将短URL还原为源URL
     * @param surfix
     * @return
     */
    public String converToSrcUrl(String surfix){
        long decode = ConvertUtil.decode(surfix);
        //需要用缓存防止穿透
        if (redisUtil.hasKey(surfix)) {
            throw new RuntimeException("该url记录不存在");
        } else {
            TConvertUrl record = convertUrlMapper.selectByPrimaryKey((int) decode);
            if (record == null) {
                //需要缓存空值防止穿透,设置过期时间5分钟(此处需要配合新生成的短url五分钟后生效)
                redisUtil.set(surfix,"null",300);
                throw new RuntimeException("该url记录不存在");
            }
            return record.getUrl();
        }
    }
}
