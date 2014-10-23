package org.appfuse.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.appfuse.model.Load;
import org.appfuse.model.PressureSpeed;
import org.appfuse.model.Reading;
import org.appfuse.model.Repetition;
import org.appfuse.model.Section;
import org.appfuse.model.SensorReading;
import org.appfuse.model.State;
import org.appfuse.model.StateEntity;
import org.appfuse.model.TireType;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Contains some methods to list files and folders from a directory
 * 
 * @author Loiane Groner http://loiane.com (Portuguese) http://loianegroner.com
 *         (English)
 */
public class ListFilesUtil {

	/**
	 * List all the files and folders from a directory
	 * 
	 * @param directoryName
	 *            to be listed
	 */
	public State state;
	private Section section;
	private TireType tireType;
	private Load load;
	private PressureSpeed pressureSpeed;
	private List<State> states = new ArrayList<State>();
	private SensorReading sensorReading;
	private Repetition repetition;
	public StateEntity stateEntity;

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

		for (File file : fList) {
			System.out.println(file.getName() + " : " + level);
			switch (level) {
			case 0:
				state = new State();
				state.setName("ohio");
				states.add(state);
				section = new Section();
				String[] s = directoryName.split(" ");
				section.setName(s[s.length - 1]);
				state.addSection(section);
				break;
			case 1:
				tireType = new TireType();
				tireType.setName(file.getName());
				section.addTireType(tireType);
				break;
			case 2:
				load = new Load();
				load.setName(file.getName());
				tireType.addLoad(load);
				break;
			case 3:
				pressureSpeed = new PressureSpeed();

				String preSt = file.getName();
				preSt.replaceAll("psi_", "");
				preSt.replaceAll("mph", "");
				pressureSpeed.setName(preSt);
				// pressureSpeed.setPressure(pressure)
				load.addPressureSpeed(pressureSpeed);
				break;
			case 4:
				repetition = new Repetition();
				repetition.setName(file.getName());
				csvReader(file.getAbsolutePath());
				pressureSpeed.addRepetition(repetition);

			default:
				break;
			}
			listFilesAndFolders(file.getAbsolutePath(), level + 1);
		}
	}

	public void csvReader(String fileString) {
		try {
			CSVReader csvReader = new CSVReader(new FileReader(fileString));
			List<String[]> strings = csvReader.readAll();
			int len = strings.get(0).length;
			int i = 1;
			for (int j = 1; j < len; j++) {
				sensorReading = new SensorReading();
				int count = 0;
				for (String[] strings2 : strings) {
					if (count == 0) {
						sensorReading.setName(strings2[j]);
					} else if (count == 1) {
						sensorReading.setMetric(strings2[j]);
					} else {
						Reading reading = new Reading();
						reading.setTime(Double.parseDouble(strings2[0]));
						reading.setValue(Double.parseDouble(strings2[j]));
						sensorReading.addTimeReading(reading);
					}
					count++;

				}
				repetition.addReadings(sensorReading);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printStates() {
		for (State state : states) {
			System.out.println(state.getName());
			for (Section section : state.getSections()) {
				System.out.println(section.getName());
				for (TireType tireType : section.getTireTypes()) {
					System.out.println(tireType.getName());
					for (Load load : tireType.getLoads()) {
						System.out.println(load.getName());
						for (PressureSpeed pressureSpeed : load
								.getPressureSpeeds()) {
							System.out.println(pressureSpeed.getName());
						}
					}
				}
			}
		}
	}

	/**
	 * List all the files under a directory
	 * 
	 * @param directoryName
	 *            to be listed
	 */
	public void listFiles(String directoryName) {

		File directory = new File(directoryName);

		// get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	/**
	 * List all the folder under a directory
	 * 
	 * @param directoryName
	 *            to be listed
	 */
	public void listFolders(String directoryName) {

		File directory = new File(directoryName);

		// get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isDirectory()) {
				System.out.println(file.getName());
			}
		}
	}

	/**
	 * List all files from a directory and its subdirectories
	 * 
	 * @param directoryName
	 *            to be listed
	 */
	public void listFilesAndFilesSubDirectories(String directoryName) {

		File directory = new File(directoryName);

		// get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isFile()) {
				System.out.println(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				listFilesAndFilesSubDirectories(file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {

		ListFilesUtil listFilesUtil = new ListFilesUtil();

		final String directoryLinuxMac = "/Users/loiane/test";

		// Windows directory example
		final String directoryWindows = "C://Test Data for Section 39BS803";

		listFilesUtil.listFilesAndFolders(directoryWindows, 0);
		listFilesUtil.printStates();
	}
}