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
import org.appfuse.dao.IDavisSummaryDao;
import org.appfuse.dao.IDavisSummaryDataPopulator;
import org.appfuse.model.DavisSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lowagie.tools.concat_pdf;

@Repository
public class DavisSummaryDataPopulator implements IDavisSummaryDataPopulator {
	@Autowired
	private IDavisSummaryDao davisSummaryDao;
	Set<String> filesProcessed = new HashSet<String>();

	Writer output;

	public void saveData(String filePath) {
		populateAlreadyProcessed();
		File file = new File(filePath);
		File[] files = file.listFiles();
		for (File f : files) {
			if (filesProcessed.contains(f.getAbsolutePath())) {
				continue;
			}
			process(f);
			try {
				output.append(f.getAbsolutePath());
				//output.append(System.lineSeparator());
				output.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void process(File fileName) {
		FileInputStream fileInputStream;
		HSSFWorkbook hssfWorkbook = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(2);
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
						if (s.equalsIgnoreCase("repeat"))
							s = "Repeated";
						if (s.equalsIgnoreCase("mysuspect"))
							continue;
						header.add(s);
						intital = true;
					}
				} else {
					DavisSummary ohioReading = new DavisSummary();
					int k = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						Class<?> c = ohioReading.getClass();
						Field field;
						try {
							if (k >= 29) {
								continue;
							}
							field = c.getDeclaredField(header.get(k));
							field.setAccessible(true);
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

							field.set(ohioReading, cell.getStringCellValue());
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
					davisSummaryDao.save(ohioReading);
					ohioReading = null;
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

	private void populateAlreadyProcessed() {
		File yourFile = new File("processedUCDavisSummary.txt");
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

}
