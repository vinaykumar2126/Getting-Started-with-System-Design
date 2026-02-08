package splitwise.repository;

public interface GroupRespository {
    Optional<Group> findById(String id);
    void save(Group group);
    
}
