package splitwise.repository;

public class InMemoryGroupRepository implements GroupRespository {
    private final Map<String, Group> store = new HashMap<>();

    @Override
    public Optional<Group> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void save(Group group) {
        store.put(group.getId(), group);
    }
    
}
