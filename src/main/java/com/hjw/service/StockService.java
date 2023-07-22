package com.hjw.service;

import com.hjw.POJO.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService
{
    List<Stock> selectByPage(Integer page);

    String selectId(String name);
}
