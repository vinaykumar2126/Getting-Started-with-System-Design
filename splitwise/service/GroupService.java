package splitwise.service;

import splitwise.model.Split;

public class GroupService {
    private final GroupRespository repo;
    private final ExpensiveService expenseService;

    public GroupService(GroupRespository repo, ExpensiveService expenseService){
        this.repo = repo;
        this.expenseService = expenseService;
    }
    public String createGroup(String name, List<User> members){
        String id = UUID.randomUUID().toString();
        Group group = new Group(id, name);
        for(User member: members){
            group.addMember(member);
        }
        repo.save(group);
        return id;
    }
    public void addExpense(String groupId, String description, double amount, User paidBy, List<User, Double> meta, SplitType splitType){
        Group group = repo.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));
        Expense expense = new Expense(description, amount, paidBy, splitBetween);
        group.addExpense(expense);
        expenseService.addExpense(expense);
        repo.save(group);
    }
   
}
