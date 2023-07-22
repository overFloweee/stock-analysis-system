package com.hjw.Controller;

import com.hjw.POJO.Result;
import com.hjw.POJO.Stock;
import com.hjw.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class stockController
{
    @Autowired
    private StockService stockService;

    @GetMapping("/winners-list")
    public Result winnersList(Integer page)
    {
        log.info("龙虎榜第{}页查询 ", page);
        List<Stock> list = stockService.selectByPage(page);

        return Result.success(list);
    }

    @GetMapping("/searchId")
    public Result searchId(String name)
    {
        log.info("该只股票的信息：{}", name);
        String stockId = stockService.selectId(name);
        return Result.success(stockId);
    }

    @GetMapping("/info")
    public Result forward(String stockInfo)
    {
        log.info("{}", stockInfo);

        String url = "http://stockpage.10jqka.com.cn/" + stockInfo;
        //         请求客户端
        RestTemplate client = new RestTemplate();
        //      发起请求
        String body = client.getForEntity(url, String.class).getBody();
        System.out.println("******** Get请求 *********");
        assert body != null;

        return Result.success(body);

    }
}
