package cn.lee.databasemanagement.service.smd;

import cn.lee.databasemanagement.bean.TableInfo;
import cn.lee.databasemanagement.utils.ExportUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SmdServiceImpl
 * @author lilei
 * @version 1.0
 * @description smd export impl
 * @date 2020年12月24日 17:02:00
 */
@Service
public class SmdServiceImpl implements SmdService {

    @Autowired
    DataSource dataSource;

    /**
     * @description 导出excel
     * @author lilei
     * @date 2020/12/24 17:03
     * @version 1.0
     */
    @Override
    public void exportExcel(HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            //获取所有表信息
            ResultSet aPublic = metaData.getTables(null, null, null, new String[]{"TABLE"});
            //数据存储
            List<List> list = new ArrayList<>();
            while (aPublic.next()) {
                String table = aPublic.getString(3);//获取表名
                //获取表结构
                ResultSet colRet = metaData.getColumns(null, "%", table, "%");
                List<TableInfo> columnList = new ArrayList<>();
                while (colRet.next()) {
                    TableInfo tableInfo = new TableInfo();
                    tableInfo.setTable(table);
                    tableInfo.setColumn(colRet.getString("COLUMN_NAME"));
                    tableInfo.setType(colRet.getString("TYPE_NAME"));
                    tableInfo.setSize(colRet.getString("COLUMN_SIZE"));
                    tableInfo.setNullable(colRet.getString("NULLABLE"));
                    tableInfo.setRemarks(colRet.getString("REMARKS"));
                    columnList.add(tableInfo);
                }
                list.add(columnList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            ExportUtils.exportExcelWithfreemarker("tableInfoWithMd.ftl", map, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
