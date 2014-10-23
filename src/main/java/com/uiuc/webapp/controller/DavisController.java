package com.uiuc.webapp.controller;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.IDavisSummaryDao;
import org.appfuse.dao.IUCDavisDao;
import org.appfuse.model.DavisSummary;
import org.appfuse.service.impl.PropertyLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/davis")
public class DavisController {
	@Autowired
	private IUCDavisDao davisDao;
	@Autowired
	private IDavisSummaryDao davisSummaryDao;

	@Autowired
	private PropertyPlaceholderConfigurer propertyConfigurer;
	private static String PATH = "";
	@Autowired
	private PropertyLoaderService loaderService;

	public DavisController() {
		String p = loaderService.properties.getProperty("davis.path");
		PATH = p;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void displayCharts() {

	}

	@RequestMapping(value = "/sensorTypes", method = RequestMethod.GET)
	@ResponseBody
	List<String> getSensorType() {
		List<String> davis = davisDao.getSensorType();
		return davis;
	}

	@RequestMapping(value = "/sensorNames/{sensorType}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getSensorNames(@PathVariable String sensorType) {
		List<String> davis = davisSummaryDao.getSensorNames(sensorType);
		return davis;
	}

	@RequestMapping(value = "/pressureSummary/{sensorType}/{sensorName}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getPressureSummary(@PathVariable String sensorType,
			@PathVariable String sensorName) {
		List<String> s = davisSummaryDao
				.getTirePressure(sensorName, sensorType);
		Collections.sort(s);
		return s;
	}

	@RequestMapping(value = "/loadSummary/{sensorType}/{sensorName}/{pressure}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getLoadSummary(@PathVariable String sensorType,
			@PathVariable String sensorName, @PathVariable String pressure) {
		return davisSummaryDao.getLoad(sensorType, sensorName, pressure);
	}

	@RequestMapping(value = "/numOfWheelsSummary/{sensorType}/{sensorName}/{pressure}/{load}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getNumOfWhweels(@PathVariable String sensorType,
			@PathVariable String sensorName, @PathVariable String pressure,
			@PathVariable String load) {
		return davisSummaryDao
				.getWheels(sensorType, sensorName, pressure, load);
	}

	@RequestMapping(value = "/offset/{sensorType}/{sensorName}/{pressure}/{load}/{num}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getWheelOffset(@PathVariable String sensorType,
			@PathVariable String sensorName, @PathVariable String pressure,
			@PathVariable String load, @PathVariable String num) {
		return davisSummaryDao.getWheelsOffset(sensorType, sensorName,
				pressure, load, num);
	}

	@RequestMapping(value = "/summary/{sensorType}/{sensorName}/{pressure}/{load}/{num}/{offset}", method = RequestMethod.GET)
	@ResponseBody
	List<DavisSummary> getSummary(@PathVariable String sensorType,
			@PathVariable String sensorName, @PathVariable String pressure,
			@PathVariable String load, @PathVariable String num,
			@PathVariable String offset) {
		// r.Name =:name and r.Type =:type and r.TirePressure=:pressure and
		// r.LoadKips=:load and r.NumWheels=:num and r.WheelOffset=:offset
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", sensorName);
		map.put("type", sensorType);
		map.put("pressure", pressure);
		map.put("load", load);
		map.put("num", num);
		map.put("offset", offset);
		List<DavisSummary> list = davisSummaryDao.findByNamedQuery(
				"findDavisSummary", map);

		return list;
	}

	@RequestMapping(value = "/sum/{sensorType}", method = RequestMethod.GET)
	@ResponseBody
	List<DavisSummary> getSum(@PathVariable String sensorType) {
		// r.Name =:name and r.Type =:type and r.TirePressure=:pressure and
		// r.LoadKips=:load and r.NumWheels=:num and r.WheelOffset=:offset
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("type", sensorType);

		List<DavisSummary> list = davisSummaryDao.findByNamedQuery(
				"findDavisSummaryAll", map);

		return list;
	}

	@RequestMapping(value = "/testIds", method = RequestMethod.GET)
	@ResponseBody
	List<String> getTestIds() {
		return davisDao.getTestIds();
	}

	@RequestMapping(value = "/date", method = RequestMethod.GET)
	@ResponseBody
	List<String> getDate() {
		return davisDao.getDate();
	}

	@RequestMapping(value = "/load/{testId}/{sensor}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getLoad(@PathVariable String testId,
			@PathVariable String sensor) {
		return davisDao.getLoad(testId, sensor);
	}

	@RequestMapping(value = "/pressure/{testId}/{sensor}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getPressure(@PathVariable String testId,
			@PathVariable String sensor) {

		return davisDao.getTirePressure(testId, sensor);
	}

	@RequestMapping(value = "/wheelType/{testId}/{sensor}/{pressure}/{load}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getWheelType(@PathVariable String testId,
			@PathVariable String sensor, @PathVariable String pressure,
			@PathVariable String load) {
		return davisDao.getWheelType(sensor, testId, pressure, load);
	}

	@RequestMapping(value = "/trafficking/{testId}/{sensor}/{pressure}/{load}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getTrafficking(@PathVariable String testId,
			@PathVariable String sensor, @PathVariable String pressure,
			@PathVariable String load) {
		return davisDao.getTrafficking(sensor, testId, pressure, load);
	}

	@RequestMapping(value = "/cycles/{testId}/{sensor}/{pressure}/{load}/{wheelType}/{trafficking}", method = RequestMethod.GET)
	@ResponseBody
	List<String> getRepetition(@PathVariable String testId,
			@PathVariable String sensor, @PathVariable String pressure,
			@PathVariable String load, @PathVariable String wheelType,
			@PathVariable String trafficking) {
		return davisDao.getRepetition(sensor, testId, pressure, load,
				wheelType, trafficking);
	}

	@RequestMapping(value = "/download/{testId}/{sensor}/{pressure}/{load}/{wheelType}/{trafficking}/{cycle}/{date}", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource download(@PathVariable String testId,
			@PathVariable String sensor, @PathVariable String pressure,
			@PathVariable String load, @PathVariable String wheelType,
			@PathVariable String trafficking, @PathVariable String cycle,
			@PathVariable String date) {
		List<String> list = null;
		if (sensor.equalsIgnoreCase("TEMP")) {
			list = davisDao.getTemp(date);
		} else {
			list = davisDao.getFileName(sensor, testId, pressure, load,
					wheelType, trafficking, cycle);
		}
		String path = PATH + list.get(0);
		return new FileSystemResource(new File(path));
	}

	@ModelAttribute("address")
	public String getAddress() {
		String server = (String) loaderService.properties
				.get("file.hosting.server");
		String port = (String) loaderService.properties
				.get("file.hosting.port");
		return server + ":" + port;
	}

}
