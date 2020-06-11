package com.jozz.alex.mapper;

import com.jozz.alex.entity.TConvertUrl;
import com.jozz.alex.entity.TConvertUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConvertUrlMapper {
    long countByExample(TConvertUrlExample example);

    int deleteByExample(TConvertUrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TConvertUrl record);

    int insertSelective(TConvertUrl record);

    List<TConvertUrl> selectByExample(TConvertUrlExample example);

    TConvertUrl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TConvertUrl record, @Param("example") TConvertUrlExample example);

    int updateByExample(@Param("record") TConvertUrl record, @Param("example") TConvertUrlExample example);

    int updateByPrimaryKeySelective(TConvertUrl record);

    int updateByPrimaryKey(TConvertUrl record);
}