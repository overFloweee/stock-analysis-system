package com.hjw.mapper;

import com.hjw.POJO.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StockMapper
{
    @Select("select * from stock limit #{index},#{num}")
    List<Stock> selectByPage(Integer index, int num);

    @Select("select stock_id from stock where name = #{name}")
    String selectId(String name);
}
