class NotificationService {
    public void notify(User user, String message) {
        switch (user.getPreferredChannel()) {
            case EMAIL:
                sendEmail(user.getEmail(), message);
                break;
            case SMS:
                sendSMS(user.getPhone(), message);
                break;
        }
    }

    private void sendEmail(String email, String message) {

    }

    private void sendSMS(String phone, String message) {

    }
}