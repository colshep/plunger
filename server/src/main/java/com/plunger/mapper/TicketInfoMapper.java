package com.plunger.mapper;

import com.plunger.bean.TicketInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TicketInfoMapper {

    @Insert("insert into consult_log(unid, type, date, code, mult, cost, reward)" +
            "values(#{unid}, #{type}, #{date}, #{code}, #{mult}, #{cost}, #{reward}")
    int insert(TicketInfo ticketInfo);

    @Select("select * from ticket_info where unid = #{unid}")
    TicketInfo findByUnid(String unid);

}
