public class User {
    public String username;
    public String password;
    public String name;

    public void updateProfile(String newName, String newPassword) {
        this.name = newName;
        this.password = newPassword;
        System.out.println("Profile updated successfully.");
    }
}