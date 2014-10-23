package org.appfuse.dao.hibernate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.appfuse.dao.IFloridaSPTestTrackDao;
import org.appfuse.dao.IFloridaSPTestTrackPopulator;
import org.appfuse.model.FloridaSPReadingTestTrack;
import org.appfuse.model.FloridaSPTestTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FloridaSPTestTrackPopulator implements
		IFloridaSPTestTrackPopulator {
	Set<String> filesProcessed = new HashSet<String>();

	Writer output;
	@Autowired
	private IFloridaSPTestTrackDao floridaSPDao;
	private FloridaSPTestTrack floridaSPTestTrack;

	private void populateAlreadyProcessed() {
		File yourFile = new File("processedFloridaSPTestTrack.txt");
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

	}

	public void save(String directory, String test) {
		populateAlreadyProcessed();
		process(directory, test);

	}

	private void process(String directory, String test) {

		File file = new File(directory);
		String na = null;
		if (file.getName().contains("EG"))
			na = "EG";
		else
			na = "SP";
		if (file.isFile()
				&& file.getName().contains(".xls")
				&& (file.getName().contains("EG") || file.getName().contains(
						"EG"))) {
			floridaSPTestTrack = new FloridaSPTestTrack();
			String name = file.getName();
			String[] strings = name.split("_");
			String type = strings[0];
			String load = strings[1];
			String pressure = strings[2];
			String cycle = strings[3];
			String repetition = strings[5].replaceAll(".xls", "");
			floridaSPTestTrack.setTireType(type);
			floridaSPTestTrack.setLoadKip(load);
			floridaSPTestTrack.setPressure(pressure);
			floridaSPTestTrack.setCycle(cycle);
			floridaSPTestTrack.setRepetition(repetition);
			floridaSPTestTrack.setTestType(test);
			floridaSPTestTrack.setSensorType(na);
			XLSReader(file, test);
			floridaSPDao.save(floridaSPTestTrack);
			floridaSPTestTrack = null;
			try {
				output.append(file.getAbsolutePath());
				//output.append(System.lineSeparator());
				output.flush();
				System.out.println("saving file" + file.getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (file.isFile()) {
			return;
		}

		File[] files = file.listFiles();
		for (File f : files) {
			String s = f.getAbsolutePath();
			if (!filesProcessed.contains(s))
				process(f.getAbsolutePath(), test);
		}

	}

	public void XLSReader(File fileName, String test) {
		FileInputStream fileInputStream;
		HSSFWorkbook hssfWorkbook = null;
		try {
			fileInputStream = new FileInputStream(fileName);
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
						header.add(i++, s);
						intital = true;
					}
				} else {
					FloridaSPReadingTestTrack floridaSPReadingTestTrack = new FloridaSPReadingTestTrack();
					int k = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						Class<?> c = floridaSPReadingTestTrack.getClass();
						Field field;
						try {
							field = c.getDeclaredField(header.get(k));
							field.setAccessible(true);
							if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
								field.set(floridaSPReadingTestTrack, Double
										.toString(cell.getNumericCellValue()));
								k++;
								continue;
							}
							if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
								field.set(floridaSPReadingTestTrack, Boolean
										.toString(cell.getBooleanCellValue()));
								k++;
								continue;
							}

							field.set(floridaSPReadingTestTrack,
									cell.getStringCellValue());
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
					floridaSPTestTrack.addReading(floridaSPReadingTestTrack);

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

}
