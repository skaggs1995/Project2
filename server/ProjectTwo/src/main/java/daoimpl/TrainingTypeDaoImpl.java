package daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dao.TrainingTypeDao;
import hibernate.HibernateUtil;
import model.TrainingType;

public class TrainingTypeDaoImpl implements TrainingTypeDao {
	private static TrainingTypeDaoImpl instance;
	private TrainingTypeDaoImpl() {}
	
	public static TrainingTypeDaoImpl getInstance() {
		if (instance == null) {
			instance = new TrainingTypeDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<TrainingType> getAllTrainingTypes() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from TrainingType", TrainingType.class).getResultList();
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}
}
