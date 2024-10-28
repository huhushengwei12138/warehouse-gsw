package net.wanho.task;
import net.wanho.po.Product;
import net.wanho.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WarningTask {
    @Resource
    private WebSocketServer webSocketServer;
    @Autowired
    private ProductService productService;
    @Scheduled(cron = "0 0 * * * ? ") // 每小时执行一次
    public void task1() {

        List<Product> warningList = productService.list().stream().filter(item -> item.getProductInvent() < item.getThreshold()).collect(Collectors.toList());
        System.out.println(warningList);
        webSocketServer.sendToAllClient(warningList.stream().toString());
        System.out.println("定时任务1执行了！");
    }
}
