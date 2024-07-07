package ProxyPattern;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        // creates a new Row
        System.out.println("Created New Row in the Employee Table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        // delete a Row
        System.out.println("Deleted Row with employeeID: " + employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        // fetch row
        System.out.println("Fetching Data from the DB");
        return new EmployeeDo(0, "Dummy", "Dummpy");
    }
}

