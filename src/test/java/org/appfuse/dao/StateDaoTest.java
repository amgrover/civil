package org.appfuse.dao;

import org.appfuse.model.Load;
import org.appfuse.model.PressureSpeed;
import org.appfuse.model.Reading;
import org.appfuse.model.Repetition;
import org.appfuse.model.Section;
import org.appfuse.model.SensorReading;
import org.appfuse.model.State;
import org.appfuse.model.TireType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StateDaoTest extends BaseDaoTestCase {
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

	@Test
	public void addState() {
		State state = new State();
		state.setName("ohio");
		Section section = new Section();
		section.setName("section");
		Reading reading = new Reading();
		reading.setTime(1212.00);
		reading.setValue(239.00);
		SensorReading sensorReading = new SensorReading();
		sensorReading.setName("KM");
		TireType tireType = new TireType();
		tireType.setName("SW");
		Load load = new Load();
		load.setName("14");
		PressureSpeed pressureSpeed = new PressureSpeed();
		pressureSpeed.setName("pressureSpeed");
		Repetition repetition = new Repetition();
		repetition.setName("One");
		state.addSection(section);
		section.addTireType(tireType);
		tireType.addLoad(load);
		load.addPressureSpeed(pressureSpeed);
		pressureSpeed.addRepetition(repetition);
		repetition.addReadings(sensorReading);
		sensorReading.addTimeReading(reading);
		readingDaoImpl.save(reading);
		flush();
		sensorReadingDaoImpl.save(sensorReading);
		repetitionDaoImpl.save(repetition);
		pressureSpeedDaoImpl.save(pressureSpeed);
		loadDaoImpl.save(load);
		tireTypeDaoImpl.save(tireType);
		sectionDao.save(section);
		dao.save(state);
		flush();

	}
}
