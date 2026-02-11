package splitwise.repository;
import splitwise.model.Group;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
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
    //     Set<String> keys = store.keySet();

    //     for (String key : keys) {
    //         System.out.println(key);
    //     }
    // }
    
}
