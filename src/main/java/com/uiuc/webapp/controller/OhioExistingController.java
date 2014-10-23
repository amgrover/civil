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

import org.appfuse.dao.IOhioOld;
import org.appfuse.dao.IOhioOld2;
import org.appfuse.model.FloridaSPReadingTestTrack;
import org.appfuse.model.FloridaSPTestTrack;
import org.appfuse.model.OhioOldData;
import org.appfuse.model.OhioOldData2;
import org.appfuse.model.OhioReading;
import org.appfuse.service.impl.PropertyLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ohioExisting")
public class OhioExistingController {
	@Autowired
	IOhioOld2 iOhioOld2;
	@Autowired
	IOhioOld iOhioOld;
	@Autowired
	private PropertyPlaceholderConfigurer propertyConfigurer;

	@Autowired
	private PropertyLoaderService loaderService;

	public OhioExistingController() {
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

	@RequestMapping(value = "/sensors", method = RequestMethod.GET)
	@ResponseBody
	private TreeSet<String> getModelProperties() {

		TreeSet<String> properties = null;

		properties = new TreeSet<String>();
		for (Method method : OhioOldData.class.getDeclaredMethods()) {
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				String name = methodName.substring(3);
				if (name.equalsIgnoreCase("Time")
						|| name.equalsIgnoreCase("id"))
					continue;
				properties.add(name);
			}
		}
		for (Method method : OhioOldData2.class.getDeclaredMethods()) {
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				String name = methodName.substring(3);
				if (name.equalsIgnoreCase("Time")
						|| name.equalsIgnoreCase("id"))
					continue;
				properties.add(name);
			}
		}

		return properties;
	}

	@RequestMapping(value = "/sensor/{filter1}/{filter2}/{sensorName}", method = RequestMethod.GET)
	@ResponseBody
	public Map<List<Double>, List<Double>> sensorValues(
			@PathVariable String filter1, @PathVariable String filter2,
			@PathVariable String sensorName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filter1", filter1);
		map.put("filter2", filter2);

		if (sensorName.startsWith("WFA") || sensorName.startsWith("WFB")) {
			List<OhioOldData2> stateEntityList = iOhioOld2.findByNamedQuery(
					"findOhioOld2", map);

			Set<OhioOldData2> ohioReadings2 = new TreeSet<OhioOldData2>();
			for (OhioOldData2 ohioReading : stateEntityList) {
				ohioReadings2.add(ohioReading);
			}
			Map map2 = new LinkedHashMap();
			try {
				List<Double> key = new ArrayList<Double>();
				List<Double> value = new ArrayList<Double>();
				for (OhioOldData2 ohioReading : ohioReadings2) {

					key.add(Double.parseDouble(ohioReading.getTime()));
					Field field;
					try {
						field = ohioReading.getClass().getDeclaredField(
								sensorName);
						field.setAccessible(true);
						String string = (String) field.get(ohioReading);
						if (string == null) {
							continue;
						}
						Double double1 = Double.parseDouble(string);
						// ROUND OFF double values
						if (double1 == null) {
							continue;
						}
						DecimalFormat decimalFormat = new DecimalFormat(
								"#.####");

						value.add(Double.parseDouble(decimalFormat
								.format(double1)));
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
		} else {
			List<OhioOldData> stateEntityList = iOhioOld.findByNamedQuery(
					"findOhioOld", map);

			Set<OhioOldData> ohioReadings2 = new TreeSet<OhioOldData>();
			for (OhioOldData ohioReading : stateEntityList) {
				ohioReadings2.add(ohioReading);
			}
			Map map2 = new LinkedHashMap();
			try {
				List<Double> key = new ArrayList<Double>();
				List<Double> value = new ArrayList<Double>();
				for (OhioOldData ohioReading : ohioReadings2) {

					key.add(Double.parseDouble(ohioReading.getTime()));

					Field field;
					try {
						field = ohioReading.getClass().getDeclaredField(
								sensorName);
						field.setAccessible(true);
						String string = (String) field.get(ohioReading);
						if (string == null) {
							continue;
						}
						Double double1 = Double.parseDouble(string);
						// ROUND OFF double values
						if (double1 == null) {
							continue;
						}
						DecimalFormat decimalFormat = new DecimalFormat(
								"#.####");

						value.add(Double.parseDouble(decimalFormat
								.format(double1)));
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

	}
}
