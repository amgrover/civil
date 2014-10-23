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

import org.appfuse.dao.IDatabsePopulator;
import org.appfuse.dao.IOhioSummary;
import org.appfuse.dao.IStateEntityDao;
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

/**
 * 
 * @author Aman's Alien
 * 
 */
@Controller
@RequestMapping("/charts")
public class ChartController {
	@Autowired
	IDatabsePopulator databsePopulator;
	@Autowired
	IStateEntityDao entityDao;
	@Autowired
	IOhioSummary ohioSummaryDao;

	@Autowired
	private PropertyLoaderService loaderService;
	public static Map<String, String> section_change = new HashMap<String, String>();
	public static Map<String, String> sensor_map = new LinkedHashMap<String, String>();
	public static Map<String, String> tireType = new HashMap<String, String>();
	static {
		section_change.put("39D168", "Mainline Section, Driving");
		section_change.put("39P168", "Mainline Section, Passing");
		section_change.put("39BS803", "Ramp Section, South Bound");
		sensor_map.put("PM", "Strain Gauge Type PM");
		sensor_map.put("KM", "Strain Gauge Type KM");
		sensor_map.put("WFLM", "Rosette Strain Gauge");
		sensor_map.put("LC", "Pressure Cell Type LC");
		sensor_map.put("PC", "Pressure Cell Type PC");
		sensor_map.put("LV", "MDD");
		tireType.put("SD", "Dual");
		tireType.put("TD", "Tandem Dual");
		tireType.put("SW", "Single WideBase");
		tireType.put("TW", "Tandem Widebase");
	}

	public ChartController() {

	}

	@RequestMapping(method = RequestMethod.GET)
	public void displayCharts() {

	}

	@ModelAttribute("sections")
	public List<String> getSections() {
		List<String> sections = entityDao.getDistinctSectionName("Ohio");
		List<String> strings = new ArrayList<String>();
		for (String string : sections) {
			strings.add(section_change.get(string));
		}
		return strings;
	}

	@RequestMapping(value = "/{section}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getTireType(@PathVariable String section) {

		List<String> tiList = entityDao.getDistinctTireType(mapSensor(section),
				"Ohio");
		List<String> strings = new ArrayList<String>();
		for (String string : tiList) {
			strings.add(tireType.get(string));
		}
		return strings;

	}

	@RequestMapping(value = "/{section}/{tire}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getLoad(@PathVariable String section,
			@PathVariable String tire) {

		List<String> tiList = entityDao.getDistinctLoad(mapSensor(section),
				mapTire(tire), "Ohio");
		return tiList;

	}

	@RequestMapping(value = "/{section}/{tire}/{load}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getspeed(@PathVariable String section,
			@PathVariable String tire, @PathVariable String load) {

		List<String> tiList = entityDao.getDistinctSpeed(mapSensor(section),
				load, mapTire(tire), "Ohio");
		return tiList;

	}

	@RequestMapping(value = "/pressure/{section}/{tire}/{load}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getpressure(@PathVariable String section,
			@PathVariable String tire, @PathVariable String load) {

		List<String> tiList = entityDao.getDistinctPressure(mapSensor(section),
				load, mapTire(tire), "Ohio");
		return tiList;

	}

	@RequestMapping(value = "/{section}/{tire}/{load}/{speed}/{pressure}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getrepetition(@PathVariable String section,
			@PathVariable String tire, @PathVariable String load,
			@PathVariable String speed, @PathVariable String pressure) {

		List<String> tiList = entityDao.getDistinctRepetition(
				mapSensor(section), load, mapTire(tire), "Ohio", pressure,
				speed);
		return tiList;

	}

	@RequestMapping(value = "season/{section}/{tire}/{load}/{speed}/{pressure}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getSeasons(@PathVariable String section,
			@PathVariable String tire, @PathVariable String load,
			@PathVariable String speed, @PathVariable String pressure) {
		load = load.replaceFirst("^0+(?!$)", "");
		load = load.replaceAll("kip", "");
		String speed2 = speed.replaceFirst("^0+(?!$)", "");
		List<String> tiList = ohioSummaryDao.getDistinctSeasons(
				mapSensor(section), load, mapTire(tire), "Ohio", pressure,
				speed);
		if (tiList.size() <= 0) {
			tiList = ohioSummaryDao.getDistinctSeasons(section, load, tire,
					"Ohio", pressure, speed2);
		}
		return tiList;

	}

	@RequestMapping(value = "/sensors/{sensorType}", method = RequestMethod.GET)
	@ResponseBody
	private List<String> getModelProperties(@PathVariable String sensorType) {
		String key = null;
		List<String> properties = null;
		if (sensorType != null) {
			for (Map.Entry<String, String> entry : sensor_map.entrySet()) {
				if (entry.getValue().equals(sensorType)) {
					key = entry.getKey();
				}
			}
			properties = new ArrayList<String>();
			for (Method method : OhioReading.class.getDeclaredMethods()) {
				String methodName = method.getName();
				if (methodName.startsWith("set")) {
					String name = methodName.substring(3);
					if (name.equalsIgnoreCase("Time")
							|| name.equalsIgnoreCase("id")
							|| !name.contains(key))
						continue;
					properties.add(name);
				}
			}
		}

		return properties;
	}

	@RequestMapping(value = "/sensorType", method = RequestMethod.GET)
	@ResponseBody
	private List<String> getSensor() {
		List<String> properties = new ArrayList<String>();
		for (Map.Entry<String, String> entry : sensor_map.entrySet()) {
			properties.add(entry.getValue());
		}
		return properties;
	}

	@RequestMapping(value = "/{section}/{tire}/{load}/{speed}/{pressure}/{repetition}/{sensor}", method = RequestMethod.GET)
	@ResponseBody
	public Map<List<Double>, List<Double>> getData(
			@PathVariable String section, @PathVariable String tire,
			@PathVariable String load, @PathVariable String speed,
			@PathVariable String pressure, @PathVariable String repetition,
			@PathVariable String sensor) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Ohio");
		map.put("section", mapSensor(section));
		map.put("tireType", mapTire(tire));
		map.put("loadNew", load);
		map.put("speed", speed);
		map.put("pressure", pressure);
		map.put("repetition", repetition);
		List<StateEntity> stateEntityList = entityDao.findByNamedQuery(
				"findStateEntity", map);
		StateEntity stateEntity = stateEntityList.get(0);
		System.out.println(stateEntity.getLoadNew());

		Set<OhioReading> ohioReadings = stateEntity.getReadings();
		Set<OhioReading> ohioReadings2 = new TreeSet<OhioReading>();
		for (OhioReading ohioReading : ohioReadings) {
			ohioReadings2.add(ohioReading);
		}
		Map map2 = new LinkedHashMap();
		try {
			List<Double> key = new ArrayList<Double>();
			List<Double> value = new ArrayList<Double>();
			for (OhioReading ohioReading : ohioReadings2) {
				DecimalFormat decimalFor = new DecimalFormat("#.###");
				key.add(Double.parseDouble(decimalFor.format(ohioReading
						.getTime())));
				Field field;
				try {
					field = ohioReading.getClass().getDeclaredField(sensor);
					field.setAccessible(true);
					Double double1 = (Double) field.get(ohioReading);
					// ROUND OFF double values
					if (double1 == null) {
						continue;
					}
					DecimalFormat decimalFormat = new DecimalFormat("#.####");

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

	public Set<OhioReading> ohioReadings() {
		StateEntity stateEntity = entityDao.get((long) 1);
		System.out.println(stateEntity.getLoadNew());

		Set<OhioReading> ohioReadings = stateEntity.getReadings();
		Set<OhioReading> ohioReadings2 = new TreeSet<OhioReading>();
		for (OhioReading ohioReading : ohioReadings) {
			ohioReadings2.add(ohioReading);
		}

		return ohioReadings2;
	}

	@RequestMapping(value = "summary/{section}/{tire}/{load}/{speed}/{pressure}/{responseType}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getOhioSummary(
			@PathVariable String section, @PathVariable String tire,
			@PathVariable String load, @PathVariable String speed,
			@PathVariable String pressure, @PathVariable String responseType,
			@RequestParam("sensors") String sensors,
			@RequestParam("type") String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] sen = sensors.split(",");
		load = load.replaceFirst("^0+(?!$)", "");
		load = load.replaceAll("kip", "");
		String speed2 = speed.replaceFirst("^0+(?!$)", "");
		map.put("name", "Ohio");
		map.put("section", mapSensor(section));
		map.put("tireType", mapTire(tire));
		map.put("loadnew", load);
		map.put("speed", speed);
		// map.put("speed2", speed2);
		map.put("pressure", pressure);
		map.put("type", type);
		Map<String, Object> map2 = null;
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<OhioSummary> list = ohioSummaryDao.findByNamedQuery(
				"findOhioSummary", map);
		if (list.size() <= 0) {
			map.put("speed", speed2);
			list = ohioSummaryDao.findByNamedQuery("findOhioSummary", map);
		}
		for (OhioSummary ohioSummary : list) {
			map2 = new LinkedHashMap<String, Object>();
			map2.put("Section", ohioSummary.getSection());
			map2.put("Load", ohioSummary.getLoadnew());
			map2.put("Speed", ohioSummary.getSpeed());
			map2.put("Tire Type", ohioSummary.getTireType());
			if (ohioSummary.getRepetition() != null)
				map2.put("Repetition", ohioSummary.getRepetition());
			map2.put("Season", ohioSummary.getSeason());
			for (String string : sen) {
				Field field;
				try {
					field = ohioSummary.getClass().getDeclaredField(string);
					field.setAccessible(true);
					Double double1 = (Double) field.get(ohioSummary);
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

	@RequestMapping(value = "sum", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getOhio(
			@RequestParam("sensors") String sensors,
			@RequestParam("type") String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] sen = sensors.split(",");

		map.put("name", "Ohio");

		map.put("type", type);
		Map<String, Object> map2 = null;
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<OhioSummary> list = ohioSummaryDao.findByNamedQuery(
				"findOhioSummaryAll", map);

		for (OhioSummary ohioSummary : list) {
			map2 = new LinkedHashMap<String, Object>();
			map2.put("Section", ohioSummary.getSection());
			map2.put("Load", ohioSummary.getLoadnew());
			map2.put("Speed", ohioSummary.getSpeed());
			map2.put("Tire Type", ohioSummary.getTireType());
			if (ohioSummary.getRepetition() != null)
				map2.put("Repetition", ohioSummary.getRepetition());
			map2.put("Season", ohioSummary.getSeason());
			for (String string : sen) {
				Field field;
				try {
					field = ohioSummary.getClass().getDeclaredField(string);
					field.setAccessible(true);
					Double double1 = (Double) field.get(ohioSummary);
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

	public static String mapSensor(String string) {
		for (Map.Entry<String, String> entry : section_change.entrySet()) {
			if (entry.getValue().equals(string)) {
				return entry.getKey();
			}

		}
		return null;
	}

	public static String mapTire(String string) {
		for (Map.Entry<String, String> entry : tireType.entrySet()) {
			if (entry.getValue().equals(string)) {
				return entry.getKey();
			}

		}
		return null;
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
