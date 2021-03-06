package services;

import java.util.List;

import dao.YearsDao;
import daoimpl.YearsDaoImpl;
import model.Years;

public class YearsService {
	private static YearsDao dao = YearsDaoImpl.getInstance();
	private YearsService() {}
	
	public static List<Years> getAllTrainers() {
		return dao.getAllYears();
	}
}
