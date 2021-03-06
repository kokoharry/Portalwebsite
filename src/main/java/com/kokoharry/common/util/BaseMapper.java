package com.kokoharry.common.util;

import com.kokoharry.website.manager.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BaseMapper<T> {

    /**
     * @param id
     * @return
     */
    T selectByPrimaryKey(long id);

    /**
     * @param code
     * @return
     */
    T selectOneByCode(String code);

    /**
     * @param condition
     * @return
     */
    List<T> selectByConditions(T condition);

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id")Long id);

    /**
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * @param record
     * @return
     */
    int updateByConditions(T record);

    /**
     *
     * @param condition
     * @param firstNum
     * @param limitNum
     * @return
     */
    List<T> getListForPage(T condition,@Param("firstNum")int firstNum,@Param("limitNum")int limitNum);

    int selectTotalCount();

}