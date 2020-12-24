package cn.lee.databasemanagement.bean;

/**
 *  TableInfo
 * @description TODO
 * @author lilei
 * @date 2020年12月23日 15:06:00
 * @version 1.0
 */
public class TableInfo {
    private String table;
    private String column;
    private String type;
    private String size;
    private String nullable;
    private String remarks;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
