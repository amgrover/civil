package com.uiuc.webapp.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.ISmartRoadDao;
import org.appfuse.dao.ITestDao;
import org.appfuse.dao.ITestPressureSpeed;
import org.appfuse.model.SmartRoad;
import org.appfuse.service.impl.PropertyLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/smartRoad")
public class SmartRoadController {

	@Autowired
	private ITestPressureSpeed iTestPressureSpeed;
	@Autowired
	private ITestDao iTestDao;
	@Autowired
	private ISmartRoadDao iSmartRoadDao;
	@Autowired
	private PropertyLoaderService loaderService;

	@RequestMapping(method = RequestMethod.GET)
	public void displayCharts() {

	}

	@ModelAttribute("address")
	public String getAddress() {
		String server = (String) loaderService.properties
				.get("file.hosting.server");
		String port = (String) loaderService.properties
				.get("file.hosting.port");
		return server + ":" + port;
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getLoad() {
		return iTestPressureSpeed.getLoad();
	}

	@RequestMapping(value = "/speed/{load}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getSpeed(@PathVariable String load) {
		return iTestPressureSpeed.getSpeed(load);
	}

	@RequestMapping(value = "/pressure/{load}/{speed}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getPressure(@PathVariable String load,
			@PathVariable String speed) {
		return iTestPressureSpeed.getPressure(load, speed);
	}

	@RequestMapping(value = "/testId/{load}/{speed}/{pressure}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getTestIds(@PathVariable String load,
			@PathVariable String speed, @PathVariable String pressure) {
		return iTestPressureSpeed.getTestId(load, speed, pressure);
	}

	@RequestMapping(value = "/date/{testId}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getDates(@PathVariable String testId) {
		return iTestDao.getDates(testId + ".0");
	}

	@RequestMapping(value = "/section/{date}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getSection(@PathVariable String date) {
		String[] strings = date.split(" ");
		StringBuilder builder = new StringBuilder();
		builder.append(strings[0] + " ");
		builder.append(strings[1] + " ");
		builder.append(strings[2]);
		builder.append(" % ");
		builder.append(strings[5]);

		List<String> list = iSmartRoadDao.getSections(builder.toString());
		List<String> list2 = new ArrayList<String>();
		for (String string : list) {
			list2.add(converSection(string));
		}
		return list2;
	}

	@RequestMapping(value = "/download/{section}/{date}/{testId}/{load}/{pressure}/{speed}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getOhioSummary(
			@PathVariable String section, @PathVariable String date,
			@PathVariable String testId, @PathVariable String load,
			@PathVariable String pressure, @PathVariable String speed,
			@RequestParam("sensors") String sensors) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] sen = sensors.split(",");
		List<String> seq = iTestDao.getSeq(testId + ".0", date);
		String[] strings = date.split(" ");
		StringBuilder builder = new StringBuilder();
		builder.append(strings[0] + " ");
		builder.append(strings[1] + " ");
		builder.append(strings[2]);
		builder.append(" % ");
		builder.append(strings[5]);

		map.put("seq", seq.get(0));
		map.put("section", convertToInt(section));
		map.put("date", builder.toString());

		Map<String, Object> map2 = null;
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<SmartRoad> list = iSmartRoadDao.findByNamedQuery("findSmartRoad",
				map);

		for (SmartRoad ohioSummary : list) {
			map2 = new LinkedHashMap<String, Object>();
			map2.put("Section", ohioSummary.getSection());
			map2.put("Load", load);
			map2.put("Speed", speed);
			map2.put("Pressure", pressure);
			map2.put("Inst_ID", ohioSummary.getInst_ID());
			map2.put("Run_numbr", ohioSummary.getRun_nbr());
			map2.put("Resp_trig_time", ohioSummary.getResp_trig_time());

			for (String string : sen) {
				Field field;
				try {
					field = ohioSummary.getClass().getDeclaredField(string);
					field.setAccessible(true);
					String double1 = (String) field.get(ohioSummary);
					if (double1 == null) {
						continue;
					}
					map2.put(string, double1);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			list2.add(map2);
		}

		return list2;

	}

	private String converSection(String section) {
		int a = Integer.parseInt(section);
		int newValue = 65 + a;
		char sec = (char) newValue;
		return ((Character) sec).toString();

	}

	private String convertToInt(String seString) {

		Integer newValue = (int) seString.charAt(0) - 65;
		return newValue.toString();
	}
}
