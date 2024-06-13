import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class WebsiteMonitor {
    private SubscriptionManager subscriptionManager;
    private Map<User, Long> userLastChecked;

    public WebsiteMonitor(SubscriptionManager subscriptionManager) {
        this.subscriptionManager = subscriptionManager;
        this.userLastChecked = new HashMap<>();
    }

    public void startMonitoring() {
        while (true) {
            long currentTime = System.currentTimeMillis();

            for (User user : subscriptionManager.getAllUsers()) {
                long lastCheckedTime = userLastChecked.getOrDefault(user, 0L);
                long frequencyMillis = user.getFrequency() * 1000;

                if (currentTime - lastCheckedTime >= frequencyMillis) {
                    List<Subscription> subscriptions = subscriptionManager.getUserSubscriptions(user);
                    for (Subscription subscription : subscriptions) {
                        checkForUpdates(subscription, user);
                    }
                    userLastChecked.put(user, currentTime);
                }
            }
            // Thread.sleep(500);
        }
    }

    private void checkForUpdates(Subscription subscription, User user) {
        try {
            NotificationService notificationService = new NotificationService();

            Document doc = Jsoup.connect(subscription.getUrl()).get();
            String html = doc.html();
            String text = doc.text();
            int size = html.length();

            switch (subscription.getPreferredComparison()) {
                case SIZE:
                    if (subscription.getLastSize() != 0 && subscription.getLastSize() != size) {
                        System.out.println(subscription.getUrl() + " has been updated");
                        // notificationService.notify(user, subscription.getUrl() + " has been updated by size.");
                    }
                    break;
                case HTML:
                    if (!subscription.getLastHtml().isEmpty() && !subscription.getLastHtml().equals(html)) {
                        System.out.println(subscription.getUrl() + " has been updated");
                        // notificationService.notify(user, subscription.getUrl() + " has been updated by size.");
                    }
                    break;
                case TEXT:
                    if (!subscription.getLastText().isEmpty() && !subscription.getLastText().equals(text)) {
                        System.out.println(subscription.getUrl() + " has been updated");
                        // notificationService.notify(user, subscription.getUrl() + " has been updated by size.");
                    }
                    break;
            }

            subscription.setLastHtml(html);
            subscription.setLastText(text);
            subscription.setLastSize(size);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
