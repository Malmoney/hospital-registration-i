package com.liurq.server.dao;

import com.liurq.server.model.Tag;
import com.liurq.server.model.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int countByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int deleteByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int deleteByPrimaryKey(String tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    Tag selectByPrimaryKey(String tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_tag
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    int updateByPrimaryKey(Tag record);
}