package woodspring.springz.repository;

import java.util.List;

import woodspring.springz.dto.Features;

public interface FeaturesDAO {
	Features getById(int feature_id);
	List<Features> getAllFeatures();
	Features save(Features futures);
	Features update(Features futures);
	Features view(Features futures);
	void delete(int features_id);

}
