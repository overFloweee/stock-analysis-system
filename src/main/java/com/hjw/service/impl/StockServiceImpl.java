package com.hjw.service.impl;

import com.hjw.POJO.Stock;
import com.hjw.mapper.StockMapper;
import com.hjw.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService
{
    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<Stock> selectByPage(Integer page)
    {
        Integer index = (page - 1) * 20;
        List<Stock> list = stockMapper.selectByPage(index, 20);
        return list;
    }

    @Override
    public String selectId(String name)
    {
        String stockId = stockMapper.selectId(name);
        return stockId;
    }
}
