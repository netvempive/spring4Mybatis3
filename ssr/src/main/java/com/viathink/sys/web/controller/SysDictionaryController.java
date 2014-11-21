package com.viathink.sys.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viathink.frame.core.dao.BaseService;
import com.viathink.frame.core.web.controller.BaseControllerImpl;
import com.viathink.sys.domain.SysDictionary;
import com.viathink.sys.domain.query.SysDictionaryQuery;
import com.viathink.sys.service.SysDictionaryService;

/**
 * 字典信息的基本操作
 * @author LiuJunGuang
 * @date 2014年3月5日上午10:30:16
 */
@Controller
@RequestMapping("/sys/dictionary")
public class SysDictionaryController extends BaseControllerImpl<SysDictionary, SysDictionaryQuery> {
	@Autowired
	private SysDictionaryService sysDictionaryService;

	@Override
	protected BaseService<SysDictionary> getBaseService() {
		return sysDictionaryService;
	}

}
