public class User {
    private String email;
    private String phone;
    private NotificationChannel preferredChannel;
    private int frequency;

    public User(String email, String phone, NotificationChannel preferredChannel, int frequency) {
        this.email = email;
        this.phone = phone;
        this.preferredChannel = preferredChannel;
        this.frequency = frequency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NotificationChannel getPreferredChannel() {
        return preferredChannel;
    }

    public void setPreferredChannel(NotificationChannel preferredChannel) {
        this.preferredChannel = preferredChannel;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public enum NotificationChannel {
        EMAIL, SMS
    }
}
