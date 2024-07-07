package ProxyPattern;

public class ProxyDesignPattern {
    public static void main(String args[]) {
        try {
            EmployeeDao empTableObj = new EmployeeDaoProxy();
//            empTableObj.create("USER", new EmployeeDo(12112192, "Shakeeb", "Computer"));
            empTableObj.create("ADMIN", new EmployeeDo(12112176, "Lovepreet", "Computer"));
            System.out.println("Operation Successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
