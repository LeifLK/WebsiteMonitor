public class Main {
    public static void main(String[] args) {

        User user1 = new User("user1@example.com", "1234567890", User.NotificationChannel.EMAIL, 1);
        User user2 = new User("user2@example.com", "0987654321", User.NotificationChannel.SMS, 5);

        SubscriptionManager subscriptionManager = new SubscriptionManager();
        subscriptionManager.addSubscription(user1, "https://google.com/", Subscription.ComparisonType.HTML);
        subscriptionManager.addSubscription(user2, "https://github.com/", Subscription.ComparisonType.HTML);

        WebsiteMonitor websiteMonitor = new WebsiteMonitor(subscriptionManager);

        websiteMonitor.startMonitoring();
    }
}
