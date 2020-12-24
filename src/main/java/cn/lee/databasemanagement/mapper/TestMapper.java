package cn.lee.databasemanagement.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * TestMapper
 * @author lilei
 * @version 1.0
 * @description TODO
 * @date 2020年12月23日 14:02:00
 */
public interface TestMapper {
    @Select("select c_ah from t_daxx where c_bh = #{cbh}")
    @Results({@Result(property = "cah",column = "c_ah")})
    String getCAh(String cbh);
}
