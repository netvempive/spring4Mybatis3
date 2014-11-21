package com.viathink.sys.web.controller.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/sys/excel")
public class ViewController extends MultiActionController {

	@RequestMapping(value = "/pdf.pdf", method = RequestMethod.GET)
	public ModelAndView viewPDF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = new ArrayList();
		Map model = new HashMap();
		list.add("test1");
		list.add("test2");
		model.put("list", list);
		ViewPDF viewPDF = new ViewPDF();
		return new ModelAndView(viewPDF, model);
	}

	@RequestMapping(value = "/xls.xls", method = RequestMethod.GET)
	public ModelAndView viewExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = new ArrayList();
		Map model = new HashMap();
		list.add("test1");
		list.add("test2");
		model.put("list", list);
		ViewExcel viewExcel = new ViewExcel();
		return new ModelAndView(viewExcel, model);
	}
}