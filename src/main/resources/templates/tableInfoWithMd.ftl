<#list list as list0>
    <#if (list?size>0)>
<table>
    <tr>
        <th colspan="6" align="center">${list0[0].table}</th>
    </tr >
    <tr >
        <td width="400">表名</td>
        <td width="400">字段名</td>
        <td width="400">字段类型</td>
        <td width="400">字段大小</td>
        <td width="400">Nullable</td>
        <td width="400">字段中文名</td>
    </tr>
        <#list list0 as list1>
            <#if (list1?size>0)>
    <tr >
        <td>${list1.table}</td>
        <td>${list1.column}</td>
        <td>${list1.type}</td>
        <td>${list1.size}</td>
        <td>${list1.nullable}</td>
        <td>${list1.remarks!'暂无'}</td>
    </tr>
            </#if>
        </#list>
</table>
    </#if>
</#list>

