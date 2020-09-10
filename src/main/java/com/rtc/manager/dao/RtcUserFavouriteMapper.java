package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcUserFavourite;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RtcUserFavouriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcUserFavourite record);

    int insertSelective(RtcUserFavourite record);

    RtcUserFavourite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcUserFavourite record);

    int updateByPrimaryKey(RtcUserFavourite record);

    List<Object> selectFavourite(@Param("uuid")String uuid, @Param("sort") String sort);

    int deleteFavourites(Integer[] pidArray);
}