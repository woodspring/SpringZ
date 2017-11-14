package woodspring.springz.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import woodspring.springz.dto.Features;

@Repository
@Transactional
public class FeaturesDAOImpl implements FeaturesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Features getById(int feature_id) {
		Features thefeatures = (Features) sessionFactory.getCurrentSession().get(Features.class,feature_id);
		return thefeatures;
	}

	@Override
	public List<Features> getAllFeatures() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Features.class);
		return criteria.list();
	}

	@Override
	public Features save(Features futures) {
		 sessionFactory.getCurrentSession().saveOrUpdate(futures);
		return futures;
	}

	@Override
	public Features update(Features futures) {
		Features retFutures = (Features)sessionFactory.getCurrentSession().merge( futures);
		return retFutures;
	}

	@Override
	public Features view(Features futures) {
		Features retFutures = (Features)sessionFactory.getCurrentSession().merge( futures);
		return retFutures;
	}

	@Override
	public void delete(int features_id) {
		Features retFutures = getById(features_id);
		sessionFactory.getCurrentSession().delete(retFutures);
	}

}
