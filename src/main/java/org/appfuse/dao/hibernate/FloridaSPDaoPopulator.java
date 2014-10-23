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
import org.appfuse.dao.IFloridaSPDao;
import org.appfuse.dao.IFloridaSPDaoPopulator;
import org.appfuse.dao.IFloridaSummaryDao;
import org.appfuse.model.FloridaSP;
import org.appfuse.model.FloridaSPSummary;
import org.appfuse.model.OhioReading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FloridaSPDaoPopulator implements IFloridaSPDaoPopulator {
	Set<String> filesProcessed = new HashSet<String>();

	Writer output;
	@Autowired
	private IFloridaSummaryDao floridaSPDao;

	private void populateAlreadyProcessed() {
		File yourFile = new File("processedFloridaSPSummary.txt");
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
		if (file.isFile() && file.getName().contains(".xls")) {
			XLSReader(file, test);
			try {
				output.append(file.getAbsolutePath());
				// output.append(System.lineSeparator());
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
			String name = fileName.getName();
			List<String> header = new ArrayList<String>();
			int i = 0;
			boolean intital = false;
			while (iterator.hasNext()) {
				Row row = iterator.next();

				Iterator<Cell> cellIterator = row.iterator();
				if (!intital) {
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String s = cell.toString().replace("(psi)", "")
								.replace("(kip)", "").replace("(C)", "");
						if (s.equalsIgnoreCase("load"))
							s = "loadKip";
						header.add(i++, s);
						intital = true;
					}
				} else {
					FloridaSPSummary floridaSP = new FloridaSPSummary();
					floridaSP.setResponseType(name);
					floridaSP.setTestType(test);
					// String name = fileName.getName();
					// String[] strings = name.split("_");
					// String type = strings[0];
					// String load = strings[1];
					// String pressure = strings[2];
					// String cycle = strings[3];
					// String repetition = strings[5].replaceAll(".xls", "");
					// floridaSP.setTireType(type);
					// floridaSP.setLoad(load);
					// floridaSP.setPressure(pressure);
					// floridaSP.setCycle(cycle);
					// floridaSP.setRepetition(repetition);
					// floridaSP.setTestType(test);
					int k = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						Class<?> c = floridaSP.getClass();
						Field field;
						try {
							field = c.getDeclaredField(header.get(k));
							field.setAccessible(true);
							if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
								field.set(floridaSP, Double.toString(cell
										.getNumericCellValue()));
								k++;
								continue;
							}
							if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
								field.set(floridaSP, Boolean.toString(cell
										.getBooleanCellValue()));
								k++;
								continue;
							}

							field.set(floridaSP, cell.getStringCellValue());
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
					// floridaSPDao.save(floridaSP);
					floridaSPDao.save(floridaSP);
					floridaSP = null;

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
