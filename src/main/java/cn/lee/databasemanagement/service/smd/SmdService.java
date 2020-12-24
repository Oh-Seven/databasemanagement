package cn.lee.databasemanagement.service.smd;

import javax.servlet.http.HttpServletResponse;

/**
 *  SmdService
 * @description smd export
 * @author lilei
 * @date 2020年12月24日 17:02:00
 * @version 1.0
 */
public interface SmdService {

    /**
     * @description 导出excel
     * @author lilei
     * @date 2020/12/24 17:03
     * @version 1.0
     */
    void exportExcel(HttpServletResponse response);
}
