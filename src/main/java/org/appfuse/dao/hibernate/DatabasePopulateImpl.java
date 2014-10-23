package org.appfuse.dao.hibernate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.appfuse.dao.IDatabsePopulator;
import org.appfuse.dao.ILoadDao;
import org.appfuse.dao.IOhioSummary;
import org.appfuse.dao.IPressureDao;
import org.appfuse.dao.IReadingDao;
import org.appfuse.dao.IRepetitionDao;
import org.appfuse.dao.ISectionDao;
import org.appfuse.dao.ISensorReadingDao;
import org.appfuse.dao.IStateEntityDao;
import org.appfuse.dao.ITireTypeDao;
import org.appfuse.dao.StateDao;
import org.appfuse.model.Load;
import org.appfuse.model.OhioReading;
import org.appfuse.model.OhioSummary;
import org.appfuse.model.Reading;
import org.appfuse.model.Section;
import org.appfuse.model.State;
import org.appfuse.model.StateEntity;
import org.appfuse.model.TireType;
import org.appfuse.util.ListFilesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.com.bytecode.opencsv.CSVReader;

@Repository
public class DatabasePopulateImpl implements IDatabsePopulator {

	@Autowired
	private StateDao dao;
	@Autowired
	private ISectionDao sectionDao;
	@Autowired
	private IReadingDao readingDaoImpl;
	@Autowired
	private ISensorReadingDao sensorReadingDaoImpl;
	@Autowired
	private ITireTypeDao tireTypeDaoImpl;
	@Autowired
	private ILoadDao loadDaoImpl;
	@Autowired
	private IPressureDao pressureSpeedDaoImpl;
	@Autowired
	private IRepetitionDao repetitionDaoImpl;
	@Autowired
	private IStateEntityDao stateEntityDao;

	@Autowired
	private IOhioSummary iOhioSummary;

	private StateEntity stateEntity;
	private Reading reading;
	private String section;
	private String load;
	private String tire;
	private Integer repetition;
	private String pressure;
	private String speed;
	Set<String> filesProcessed = new HashSet<String>();

	Writer output;

	public void populateDatabase() {

		File yourFile = new File("processed.txt");
		if (!yourFile.exists()) {
			try {
				yourFile.createNewFile();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Scanner scanner = new Scanner(yourFile);
				while (scanner.hasNextLine()) {
					String string = (String) scanner.nextLine();
					filesProcessed.add(string);

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			output = new BufferedWriter(new FileWriter(yourFile, true));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListFilesUtil filesUtil = new ListFilesUtil();
		List<String> list = new ArrayList<String>();

		String directoryWindows = "C:\\work\\civil_enginering\\Ohio\\Test Data for Section 39BS803";

		// list.add("C:\\work\\civil_enginering\\Ohio\\Test Data for Section 39D168");
		list.add("C:\\work\\civil_enginering\\Ohio\\Test Data for Section 39P168");
		// list.add(directoryWindows);
		for (String string : list) {
			try {
				listFilesAndFolders(string, 0);
			} catch (Exception e) {
				try {
					output.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(-1);
			}
		}
	}

	public void listFilesAndFolders(String directoryName, int level) {

		if (directoryName == null) {
			return;
		}

		File directory = new File(directoryName);
		if (directory.isFile()) {
			return;
		}
		// get all the files from a directory
		File[] fList = directory.listFiles();
		Integer count = 1;
		for (File file : fList) {
			if (file.getName().equalsIgnoreCase("plots")
					|| file.getName().contains("matlab database"))
				continue;
			System.out.println(file.getName() + " : " + level);
			switch (level) {
			case 0:

				String[] s = directoryName.split(" ");
				section = s[s.length - 1];
				break;
			case 1:

				tire = file.getName();

				break;
			case 2:
				load = file.getName();
				break;
			case 3:
				repetition = 0;
				String[] pressureSpeed = file.getName().split("_");
				System.out.println(file.getName());
				pressure = pressureSpeed[0].replaceAll("psi", "");
				speed = pressureSpeed[1].replaceAll("mph", "");

				break;
			case 5:
				if (!filesProcessed.contains(file.getAbsolutePath())) {

					stateEntity = new StateEntity();
					stateEntity.setName("Ohio");
					stateEntity.setLoadNew(load);
					stateEntity.setTireType(tire);
					stateEntity.setSection(section);
					stateEntity.setRepetition(Integer.toString(++repetition));
					stateEntity.setPressure(pressure);
					stateEntity.setSpeed(speed);
					// csvReader(file.getAbsolutePath());
					XLSReader(file.getAbsolutePath());
					stateEntityDao.save(stateEntity);
					stateEntity = null;
					try {
						output.append(file.getAbsolutePath());
						//output.append(System.lineSeparator());

						output.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			default:
				break;
			}

			listFilesAndFolders(file.getAbsolutePath(), level + 1);
			count = 1;
		}

	}

	public void XLSReader(String fileName) {
		FileInputStream fileInputStream;
		HSSFWorkbook hssfWorkbook = null;
		try {
			fileInputStream = new FileInputStream(new File(fileName));
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			Iterator<Row> iterator = hssfSheet.iterator();

			List<String> header = new ArrayList<String>();
			int i = 0;
			boolean intital = false;
			while (iterator.hasNext()) {
				Row row = iterator.next();

				Iterator<Cell> cellIterator = row.iterator();
				if (!intital) {
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String s = cell.toString();
						header.add(i++, s.replaceAll("-", "_"));
						intital = true;
					}
				} else {
					OhioReading ohioReading = new OhioReading();
					int k = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						Class<?> c = ohioReading.getClass();
						Field field;
						try {
							field = c.getDeclaredField(header.get(k));
							field.setAccessible(true);
							field.set(ohioReading, cell.getNumericCellValue());
							k++;
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						stateEntity.addSection(ohioReading);

					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			hssfWorkbook = null;
		}

	}

	public void csvReader(String fileString) {
		try {
			CSVReader csvReader = new CSVReader(new FileReader(fileString));
			List<String[]> strings = csvReader.readAll();
			int len = strings.get(0).length;
			String[] header = strings.get(0);
			for (int z = 0; z < header.length; z++) {
				header[z] = header[z].replaceAll("-", "_");
			}
			for (int j = 2; j < strings.size(); j++) {
				String[] temp = strings.get(j);
				OhioReading ohioReading = new OhioReading();
				for (int k = 0; k < temp.length; k++) {

					Class<?> c = ohioReading.getClass();
					Field field;
					try {
						field = c.getDeclaredField(header[k]);
						field.setAccessible(true);
						field.set(ohioReading, Double.parseDouble(temp[k]));
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					stateEntity.addSection(ohioReading);

				}
				// String sensor = null;
				// String metric = null;
				// for (int j = 1; j < len; j++) {
				// for (int k = 0; k < strings.size(); k++) {
				//
				// String[] temp = strings.get(k);
				// if (k == 0)
				// sensor = temp[j];
				// else if (k == 1)
				// metric = temp[j];
				// else {
				// reading = new Reading();
				// reading.setSensor(sensor);
				// reading.setMetric(metric);
				// reading.setTime(Double.parseDouble(temp[0]));
				// reading.setValue(Double.parseDouble(temp[j]));
				// stateEntity.addSection(reading);
				// }
				// }

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getState() {
		State state = dao.getAll().get(0);
		System.out.println(state.getName());
		Section section = state.getSections().iterator().next();
		System.out.println(section.getName());
		TireType tireType = section.getTireTypes().iterator().next();
		System.out.println(tireType.getName());
		Load load = tireType.getLoads().iterator().next();
		System.out.println(load.getName());
	}

	public void populateOhio(String directory) {
		File file = new File(directory);
		File[] filePaths = file.listFiles();

		for (File string : filePaths) {

			CSVReader csvReader;
			try {
				csvReader = new CSVReader(new FileReader(string));
				List<String[]> strings = csvReader.readAll();
				String[] header = strings.get(0);
				for (int i = 1; i < strings.size(); i++) {
					OhioSummary ohioSummary = new OhioSummary();
					ohioSummary.setType("max_avg");
					ohioSummary.setName("Ohio");
					String[] row = strings.get(i);
					for (int j = 0; j < row.length; j++) {
						Class<?> c = ohioSummary.getClass();
						String headerString = header[j];
						if (!headerString.contains("-"))
							headerString = headerString.toLowerCase();
						headerString = headerString.replaceAll("-", "_");
						headerString = headerString.replaceAll("\\(.*?\\)", "");
						if (headerString.equalsIgnoreCase("tire")) {
							headerString = "tireType";
						}
						if (headerString.equalsIgnoreCase("load")) {
							headerString = "loadnew";
						}

						Field field;
						field = c.getDeclaredField(headerString);
						field.setAccessible(true);
						if (headerString.contains("_")
								|| headerString.equalsIgnoreCase("time")) {
							String temp = row[j];
							if (!temp.isEmpty())
								field.set(ohioSummary,
										Double.parseDouble(row[j]));
							continue;
						}
						field.set(ohioSummary, row[j]);
					}
					iOhioSummary.save(ohioSummary);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
