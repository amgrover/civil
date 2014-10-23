package com.uiuc.webapp.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.xml.resolver.apps.resolver;
import org.appfuse.dao.IFloridaSPDao;
import org.appfuse.dao.IFloridaSummaryDao;
import org.appfuse.model.FloridaSPReadingTestTrack;
import org.appfuse.model.FloridaSPSummary;
import org.appfuse.model.FloridaSPTestTrack;
import org.appfuse.model.OhioReading;
import org.appfuse.model.OhioSummary;
import org.appfuse.model.StateEntity;
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
@RequestMapping("/florida")
public class FloridaController {
	@Autowired
	private IFloridaSPDao floridaSPDao;
	@Autowired
	private IFloridaSummaryDao floridaSummaryDao;
	@Autowired
	private PropertyLoaderService loaderService;

	public FloridaController() {
		// TODO Auto-generated constructor stub

	}

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

	@RequestMapping(value = "/sensors/", method = RequestMethod.GET)
	@ResponseBody
	private List<String> getModelProperties() {

		List<String> properties = new ArrayList<String>();
		for (Method method : FloridaSPReadingTestTrack.class
				.getDeclaredMethods()) {
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				String name = methodName.substring(3);
				if (name.equalsIgnoreCase("Time")
						|| name.equalsIgnoreCase("id")
						|| name.equalsIgnoreCase("SecondsElapsed")
						|| name.equalsIgnoreCase("uid"))
					continue;
				properties.add(name);
			}
		}

		return properties;
	}

	@RequestMapping(value = "/sensor/{test}/{tireType}/{load}/{pressure}/{cycle}/{repetition}/{sensorType}/{sensorName}", method = RequestMethod.GET)
	@ResponseBody
	public Map<List<Double>, List<Double>> sensorValues(
			@PathVariable String test, @PathVariable String tireType,
			@PathVariable String load, @PathVariable String pressure,
			@PathVariable String cycle, @PathVariable String repetition,
			@PathVariable String sensorType, @PathVariable String sensorName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testType", test);
		map.put("tireType", tireType);

		map.put("loadKip", load);
		map.put("cycle", cycle);
		map.put("pressure", pressure);
		map.put("repetition", repetition);
		map.put("sensorType", convertSensorType(sensorType));
		List<FloridaSPTestTrack> stateEntityList = floridaSPDao
				.findByNamedQuery("findFloridaTestTrack", map);
		FloridaSPTestTrack stateEntity = stateEntityList.get(0);

		Set<FloridaSPReadingTestTrack> ohioReadings = stateEntity
				.getFloridaSPReadingTestTracks();
		Set<FloridaSPReadingTestTrack> ohioReadings2 = new TreeSet<FloridaSPReadingTestTrack>();
		for (FloridaSPReadingTestTrack ohioReading : ohioReadings) {
			ohioReadings2.add(ohioReading);
		}
		Map map2 = new LinkedHashMap();
		try {
			List<Double> key = new ArrayList<Double>();
			List<Double> value = new ArrayList<Double>();
			for (FloridaSPReadingTestTrack ohioReading : ohioReadings2) {
				key.add(Double.parseDouble(ohioReading.getSecondsElapsed()));
				Field field;
				try {
					field = ohioReading.getClass().getDeclaredField(sensorName);
					field.setAccessible(true);
					Double double1 = Double.parseDouble((String) field
							.get(ohioReading));
					// ROUND OFF double values
					DecimalFormat decimalFormat = new DecimalFormat("#.###");

					value.add(Double.parseDouble(decimalFormat.format(double1)));
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

			map2.put(key, value);
			return map2;
		} finally {
			map2 = null;
		}

	}

	@RequestMapping(value = "/tire/{test}/{sensorType}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getTireType(@PathVariable String test,
			@PathVariable String sensorType) {
		return floridaSPDao.getTireType(test, convertSensorType(sensorType));

	}

	@RequestMapping(value = "/load/{test}/{sensorType}/{tireType}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getLoad(@PathVariable String test,
			@PathVariable String sensorType, @PathVariable String tireType) {
		return floridaSPDao.getLoad(test, tireType,
				convertSensorType(sensorType));

	}

	@RequestMapping(value = "/pressure/{test}/{sensorType}/{tireType}/{load}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getPressure(@PathVariable String test,
			@PathVariable String sensorType, @PathVariable String tireType,
			@PathVariable String load) {
		return floridaSPDao.getPressure(test, tireType, load,
				convertSensorType(sensorType));

	}

	@RequestMapping(value = "/cycle/{test}/{sensorType}/{tireType}/{load}/{pressure}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getCycle(@PathVariable String test,
			@PathVariable String sensorType, @PathVariable String tireType,
			@PathVariable String load, @PathVariable String pressure) {
		return floridaSPDao.getCycle(test, tireType, load, pressure,
				convertSensorType(sensorType));

	}

	@RequestMapping(value = "/repetition/{test}/{sensorType}/{tireType}/{load}/{pressure}/{cycle}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getRepetition(@PathVariable String test,
			@PathVariable String sensorType, @PathVariable String tireType,
			@PathVariable String load, @PathVariable String pressure,
			@PathVariable String cycle) {
		return floridaSPDao.getRepetition(test, tireType, load, pressure,
				cycle, convertSensorType(sensorType));

	}

	@RequestMapping(value = "/summary/repetition/{test}/{sensorType}/{tireType}/{load}/{pressure}/{cycle}/{responseType}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getSummaryRepetition(@PathVariable String test,
			@PathVariable String sensorType, @PathVariable String tireType,
			@PathVariable String load, @PathVariable String pressure,
			@PathVariable String cycle, @PathVariable String responseType) {
		return floridaSummaryDao.getRepetition(test, tireType, load, pressure,
				cycle, convertSensorType(sensorType), responseType);

	}

	@RequestMapping(value = "/summary/data/{test}/{sensorType}/{tireType}/{load}/{pressure}/{responseType}/{temp}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getOhioSummary(@PathVariable String test,
			@PathVariable String sensorType, @PathVariable String tireType,
			@PathVariable String load, @PathVariable String pressure,
			@PathVariable String responseType, @PathVariable String temp,
			@RequestParam("sensors") String sensors) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] sen = sensors.split(",");
		load = load.replaceFirst("^0+(?!$)", "");
		load = load.replaceAll("kip", "");
		load = load + ".0";
		if (!pressure.contains("-"))
			pressure = pressure + ".0";
		temp = temp + ".0";
		responseType = responseType + convertSensorType(sensorType) + ".xls";
		map.put("testType", test);
		map.put("tireType", tireType);
		map.put("loadKip", load);
		map.put("sensorType", convertSensorType(sensorType));
		map.put("pressure", pressure);
		map.put("responseType", responseType);
		map.put("temp", temp);
		Map<String, Object> map2 = null;
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<FloridaSPSummary> list = floridaSummaryDao.findByNamedQuery(
				"findFloridaSummary", map);

		for (FloridaSPSummary ohioSummary : list) {
			map2 = new LinkedHashMap<String, Object>();
			map2.put("Section", ohioSummary.getSection());
			map2.put("Tire", ohioSummary.getTire());
			map2.put("Temp", ohioSummary.getTemp());
			map2.put("Pressure", ohioSummary.getPressure());
			map2.put("Load", ohioSummary.getLoadKip());
			map2.put("SensorType", ohioSummary.getSensorType());
			if (!responseType.contains("all"))
				map2.put("Rep", ohioSummary.getRep());

			for (String string : sen) {
				Field field;
				try {
					field = ohioSummary.getClass().getDeclaredField(string);
					if (field == null) {
						System.out.println(string);
					}
					field.setAccessible(true);
					String s = (String) field.get(ohioSummary);
					if (s == null || s.isEmpty()) {
						continue;
					}
					Double double1 = Double.parseDouble((String) field
							.get(ohioSummary));
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

	@RequestMapping(value = "/sum/data/{sensorType}/{responseType}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getOhioSum(
			@PathVariable String sensorType, @PathVariable String responseType,
			@RequestParam("sensors") String sensors) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] sen = sensors.split(",");

		responseType = responseType + sensorType + ".xls";

		map.put("sensorType", convertSensorType(sensorType));

		map.put("responseType", responseType);

		Map<String, Object> map2 = null;
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<FloridaSPSummary> list = floridaSummaryDao.findByNamedQuery(
				"findFloridaSummaryAll", map);

		for (FloridaSPSummary ohioSummary : list) {
			map2 = new LinkedHashMap<String, Object>();
			map2.put("Section", ohioSummary.getSection());
			map2.put("Tire", ohioSummary.getTire());
			map2.put("Temp", ohioSummary.getTemp());
			map2.put("Pressure", ohioSummary.getPressure());
			map2.put("Load", ohioSummary.getLoadKip());
			map2.put("SensorType", ohioSummary.getSensorType());
			if (!responseType.contains("all"))
				map2.put("Rep", ohioSummary.getRep());

			for (String string : sen) {
				Field field;
				try {
					if (string.isEmpty()) {
						continue;
					}
					field = ohioSummary.getClass().getDeclaredField(string);
					if (field == null) {
						System.out.println(string);
					}
					field.setAccessible(true);
					String s = (String) field.get(ohioSummary);
					if (s == null || s.isEmpty()) {
						continue;
					}
					Double double1 = Double.parseDouble((String) field
							.get(ohioSummary));
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

	private String convertSensorType(String sensorType) {
		if (sensorType.equalsIgnoreCase("PC")) {
			return "SP";
		}
		return sensorType;
	}
}
