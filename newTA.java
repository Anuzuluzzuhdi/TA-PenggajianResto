import java.util.*;

class Employee {
    private String name;
    private String position;
    private double salary;
    private double alpha;
    private double deductions;
    private double bonus;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.salary = 0;
        this.alpha = 0;
        this.deductions = 0;
        this.bonus = 0;
    }

    // Getter and Setter methods for the Employee class

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double calculateSalary() {
        if (alpha < 0) alpha = 0;
        if (deductions < 0) deductions = 0;
        if (bonus < 0) bonus = 0;

        double baseSalary = 0;
        if (position.equals("Manager")) {
            baseSalary = 5000;
        } else if (position.equals("Chef")) {
            baseSalary = 3000;
        } else if (position.equals("Kasir")) {
            baseSalary = 2500;
        } else if (position.equals("Admin")) {
            baseSalary = 4000;
        }

        salary = baseSalary + (alpha * 100) - deductions + bonus;
        return salary;
    }
}

class UserManager {
    private Map<String, String> users;
    private String loggedInUser;

    public UserManager() {
        users = new HashMap<>();
        loggedInUser = null;
    }

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            return true;
        }
        return false;
    }

    public void logout() {
        loggedInUser = null;
    }

    public boolean hasAccess(String position) {
        if (loggedInUser != null) {
            if (loggedInUser.equals("manager1") && (position.equals("Manager") || position.equals("Admin"))) {
                return true;
            } else if (loggedInUser.equals("manager2") && (position.equals("Chef") || position.equals("Kasir"))) {
                return true;
            }
        }
        return false;
    }
}

public class newTA {
    public static void main(String[] args) {
        UserManager manager1 = new UserManager();
        manager1.addUser("manager1", "password1");

        UserManager manager2 = new UserManager();
        manager2.addUser("manager2", "password2");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Employee1", "Manager"));
        employees.add(new Employee("Employee2", "Admin"));
        employees.add(new Employee("Employee3", "Chef"));
        employees.add(new Employee("Employee4", "Kasir"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Penggajian Karyawan ===");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            UserManager currentUserManager = null;
            if (manager1.login(username, password)) {
                currentUserManager = manager1;
            } else if (manager2.login(username, password)) {
                currentUserManager = manager2;
            }

            if (currentUserManager != null) {
                if (currentUserManager.hasAccess("Manager") || currentUserManager.hasAccess("Admin") || currentUserManager.hasAccess("Chef") || currentUserManager.hasAccess("Kasir")) {
                    System.out.println("Login berhasil.");

                    while (true) {
                        System.out.println("\n=== Menu ===");
                        System.out.println("1. Input Data Karyawan");
                        System.out.println("2. Hitung Gaji Karyawan");
                        System.out.println("3. Logout");
                        System.out.print("Pilih menu (1/2/3): ");
                        String choice = scanner.nextLine();

                        if (choice.equals("1")) {
                            System.out.println("\n=== Input Data Karyawan ===");
                            System.out.print("Nama Karyawan: ");
                            String name = scanner.nextLine();
                            System.out.print("Jabatan (Manager/Admin/Chef/Kasir): ");
                            String position = scanner.nextLine();
                            System.out.print("Jumlah Alpha: ");
                            double alpha = Double.parseDouble(scanner.nextLine());
                            System.out.print("Potongan Gaji: ");
                            double deductions = Double.parseDouble(scanner.nextLine());
                            System.out.print("Bonus: ");
                            double bonus = Double.parseDouble(scanner.nextLine());

                            for (Employee employee : employees) {
                                if (employee.getName().equals(name)) {
                                    employee.setAlpha(alpha);
                                    employee.setDeductions(deductions);
                                    employee.setBonus(bonus);
                                    break;
                                }
                            }
                        } else if (choice.equals("2")) {
                            System.out.println("\n=== Hitung Gaji Karyawan ===");
                            for (Employee employee : employees) {
                                double salary = employee.calculateSalary();
                                System.out.println(employee.getName() + " (" + employee.getPosition() + "): Gaji = " + salary);
                            }
                        } else if (choice.equals("3")) {
                            currentUserManager.logout();
                            break;
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                } else {
                    System.out.println("Anda tidak memiliki akses ke penggajian.");
                }
            } else {
                System.out.println("Login gagal. Coba lagi.");
            }
        }
    }
}
