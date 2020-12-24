package cn.lee.databasemanagement.controller;

import cn.lee.databasemanagement.service.smd.SmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * TestController
 * @param
 * @author lilei
 * @description TODO
 * @return
 * @date 2019/10/31 17:08
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    SmdService smdService;

    @GetMapping(value = "getcAh")
    public void getCah(HttpServletResponse response){
        smdService.exportExcel(response);
    }
}
