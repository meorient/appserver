package com.meorient.appserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.appserver.mapper.CallLogMapper;
import com.meorient.appserver.pojo.CallLog;

@RestController
public class CallLogController {
	
	@Autowired 
	CallLogMapper calllogMapper;
	
    @RequestMapping("/calllogs")
    public int addCallLogs(List<CallLog> callLogs){
       for(CallLog cl : callLogs) {
    	   calllogMapper.addCallLog(cl);
       }
       return callLogs.size();
    }
    
    @RequestMapping("/calllogs")
    public void addCallLogs(CallLog callLog){
	   calllogMapper.addCallLog(callLog);
    }
}
