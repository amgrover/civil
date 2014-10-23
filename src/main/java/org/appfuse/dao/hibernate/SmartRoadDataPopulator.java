package org.appfuse.dao.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.appfuse.dao.ISmartRoadDao;
import org.appfuse.dao.ISmartRoadDataPopulator;
import org.appfuse.dao.ITestDao;
import org.appfuse.dao.ITestPressureSpeed;
import org.appfuse.model.SmartRoad;
import org.appfuse.model.TestSpeedPressure;
import org.appfuse.model.Tests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartRoadDataPopulator implements ISmartRoadDataPopulator {

	@Autowired
	private ITestDao iTestDao;
	@Autowired
	private ITestPressureSpeed iTestPressureSpeed;
	@Autowired
	private ISmartRoadDao iSmartRoadDataPopulator;

	public void populateTests(String file) throws IOException {

		FileInputStream fileInputStream = null;
		HSSFWorkbook hssfWorkbook = null;

		fileInputStream = new FileInputStream(new File(file));
		hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(1);
		Iterator<Row> iterator = hssfSheet.iterator();
		while (iterator.hasNext()) {
			Row row = iterator.next();

			Iterator<Cell> cellIterator = row.iterator();
			Tests ohioReading = new Tests();
			int k = 0;
			while (cellIterator.hasNext()) {
				switch (k) {
				case 0:
					Double string = cellIterator.next().getNumericCellValue();
					ohioReading.setTestSeqNo(string.toString());
					k++;
					break;
				case 1:
					Double string2 = cellIterator.next().getNumericCellValue();
					ohioReading.setTestId(string2.toString());
					k++;
					break;
				case 2:
					Date double1 = cellIterator.next().getDateCellValue();

					ohioReading.setStartDate(double1.toString());

					k++;
					break;
				case 3:
					Date double2 = cellIterator.next().getDateCellValue();

					ohioReading.setEndDate(double2.toString());

					k++;
					break;
				default:
					break;
				}

			}
			iTestDao.save(ohioReading);
		}
	}

	public void populateTestSpeedPressure(String file) throws IOException {

		FileInputStream fileInputStream = null;
		HSSFWorkbook hssfWorkbook = null;

		fileInputStream = new FileInputStream(new File(file));
		hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
		Iterator<Row> iterator = hssfSheet.iterator();
		while (iterator.hasNext()) {
			Row row = iterator.next();

			Iterator<Cell> cellIterator = row.iterator();
			TestSpeedPressure ohioReading = new TestSpeedPressure();
			int k = 0;
			while (cellIterator.hasNext()) {
				switch (k) {
				case 0:
					String string = cellIterator.next().getStringCellValue()
							.replace("Test", "").trim();
					ohioReading.setTestId(string);
					k++;
					break;
				case 1:
					String string2 = cellIterator.next().getStringCellValue();
					ohioReading.setLoadNew(string2);
					k++;
					break;
				case 2:
					Double string3 = cellIterator.next().getNumericCellValue();
					ohioReading.setPressure(string3.toString());
					k++;
					break;
				case 3:
					Double string4 = cellIterator.next().getNumericCellValue();
					ohioReading.setSpeed(string4.toString());
					k++;
					break;
				default:
					break;
				}

			}
			iTestPressureSpeed.save(ohioReading);
		}
	}

	public void process(String directory, String test) throws IOException {

		File file = new File(directory);
		if (file.isFile() && file.getName().contains(".xls")) {
			populateSmartRoad(file.getAbsolutePath());

		}
		if (file.isFile()) {
			return;
		}

		File[] files = file.listFiles();
		for (File f : files) {

			process(f.getAbsolutePath(), test);
		}

	}

	public void populateSmartRoad(String file) throws IOException {

		FileInputStream fileInputStream;
		HSSFWorkbook hssfWorkbook = null;

		fileInputStream = new FileInputStream(file);
		hssfWorkbook = new HSSFWorkbook(fileInputStream);
		int total = hssfWorkbook.getNumberOfSheets();
		for (int j = 0; j < total; j++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(j);
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
						header.add(s);
						intital = true;
					}
				} else {
					SmartRoad ohioReading = new SmartRoad();
					String year = "";
					ohioReading.setSection(String.valueOf(j));

					int k = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						Class<?> c = ohioReading.getClass();
						Field field;
						try {
							field = c.getDeclaredField(header.get(k));
							field.setAccessible(true);
							if (k == 3) {
								Date date = cell.getDateCellValue();
								Calendar calendar = Calendar.getInstance();
								calendar.setTime(date);
								year = String.valueOf(calendar
										.get(Calendar.YEAR));
								field.set(ohioReading, cell.getDateCellValue()
										.toString());
								k++;
								continue;
							}
							if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
								field.set(ohioReading, Double.toString(cell
										.getNumericCellValue()));
								k++;
								continue;
							}
							if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
								field.set(ohioReading, Boolean.toString(cell
										.getBooleanCellValue()));
								k++;
								continue;
							}

							field.set(ohioReading, cell.toString());
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

					}
					ohioReading.setYear(year);
					iSmartRoadDataPopulator.save(ohioReading);
					ohioReading = null;
				}
			}

		}

	}
}
