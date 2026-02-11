package splitwise.repository;

import splitwise.model.Group;
import java.util.Optional;

public interface GroupRespository {
    Optional<Group> findById(String id);
    void save(Group group);
    
}

