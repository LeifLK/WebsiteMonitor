public class Main {
    public static void main(String[] args) {
        // Create Users
        User user1 = new User("user1@example.com", "1234567890", User.NotificationChannel.EMAIL, 1);
        User user2 = new User("user2@example.com", "0987654321", User.NotificationChannel.SMS, 5);

        // Create Subscription Manager and Add Subscriptions
        SubscriptionManager subscriptionManager = new SubscriptionManager();
        subscriptionManager.addSubscription(user1, "https://google.com/", Subscription.ComparisonType.HTML);
        subscriptionManager.addSubscription(user2, "https://github.com/", Subscription.ComparisonType.HTML);

        // Create and Start Website Monitor
        WebsiteMonitor websiteMonitor = new WebsiteMonitor(subscriptionManager);

        // Start monitoring
        websiteMonitor.startMonitoring();
    }
}
