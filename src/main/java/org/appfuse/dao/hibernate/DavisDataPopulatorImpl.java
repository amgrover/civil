package org.appfuse.dao.hibernate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.appfuse.dao.IUCDavisDao;
import org.appfuse.dao.IUCDavisDataPopulator;
import org.appfuse.model.UCDavis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.com.bytecode.opencsv.CSVReader;

@Repository
public class DavisDataPopulatorImpl implements IUCDavisDataPopulator {
	Set<String> filesProcessed = new HashSet<String>();

	Writer output;
	private UCDavis davis;
	@Autowired
	private IUCDavisDao davisDao;

	public void populateUCDavis(String directory) {
		populateAlreadyProcessed();
		File file = new File(directory);
		File[] files = file.listFiles();
		for (File f : files) {
			if (filesProcessed.contains(f.getAbsolutePath())) {
				continue;
			}
			if (f.getName().contains("PRF")) {
				continue;
			}
			davis = new UCDavis();
			String[] split = f.getName().split("-");

			davis.setTestId(split[0]);
			davis.setSensorType(split[2]);
			if (f.getName().contains("TEMP")) {
				String date = split[split.length - 3] + "-"
						+ split[split.length - 2] + "-"
						+ split[split.length - 1].replace(".csv", "");
				davis.setDateTime(date);
				davis.setSensor("TEMP");

			} else {
				String cycles = split[3];
				cycles = cycles.replace(".csv", "");
				Integer integer = Integer.parseInt(cycles) + 19;
				davis.setCycles(cycles + "-" + integer.toString());
				CSVReader csvReader;
				List<String[]> strings = null;
				try {
					csvReader = new CSVReader(new FileReader(f));
					strings = csvReader.readAll();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}

				if (split[2].contains("MDD")) {
					davis.setSensor("MDD");
					populateMDD(davis, strings);

				} else if (split[2].contains("PRESSURE")) {
					davis.setSensor("PRESSURE");
					populatePresssure(davis, strings);

				} else if (split[2].contains("RSD")) {
					davis.setSensor("RSD");
					populateRSD(davis, strings);

				} else if (split[2].contains("STRAIN")) {
					davis.setSensor("STRAIN");
					populateStrain(davis, strings);

				}
			}
			davis.setFilePath(f.getName());
			davisDao.save(davis);
			davis = null;
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

	private void populateStrain(UCDavis davis2, List<String[]> strings) {
		String load = strings.get(8)[4];
		String pressure = strings.get(10)[1];
		String trafficking = strings.get(10)[7];
		String wheelType = strings.get(10)[8];
		davis2.setLoadKip(load);
		davis2.setTirePressure(pressure);
		davis2.setWheelType(wheelType);
		davis2.setTrafficking(trafficking);

	}

	private void populateRSD(UCDavis davis2, List<String[]> strings) {
		String load = strings.get(6)[4];
		String pressure = strings.get(8)[1];
		String trafficking = strings.get(8)[7];
		String wheelType = strings.get(8)[8];
		davis2.setLoadKip(load);
		davis2.setTirePressure(pressure);
		davis2.setWheelType(wheelType);
		davis2.setTrafficking(trafficking);

	}

	private void populatePresssure(UCDavis davis2, List<String[]> strings) {
		String load = strings.get(8)[4];
		String pressure = strings.get(10)[1];
		String trafficking = strings.get(10)[7];
		String wheelType = strings.get(10)[8];
		davis2.setLoadKip(load);
		davis2.setTirePressure(pressure);
		davis2.setWheelType(wheelType);
		davis2.setTrafficking(trafficking);

	}

	private void populateMDD(UCDavis davis2, List<String[]> strings) {
		String load = strings.get(7)[4];
		String pressure = strings.get(9)[1];
		String trafficking = strings.get(9)[7];
		String wheelType = strings.get(9)[8];
		davis2.setLoadKip(load);
		davis2.setTirePressure(pressure);
		davis2.setWheelType(wheelType);
		davis2.setTrafficking(trafficking);

	}

	private void populateAlreadyProcessed() {
		File yourFile = new File("processedUCDavis.txt");
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
