package com.meorient.appserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.meorient.appserver.pojo.CallLog;

@Mapper
public interface CallLogMapper {
	
	@Insert("replace into app_calllog values ( #{userId} , #{number} , #{name} , #{type} ,#{time}, #{date}})")
	public int addCallLog(CallLog cl);
}
