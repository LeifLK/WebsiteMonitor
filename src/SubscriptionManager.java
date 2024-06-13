import java.util.*;

class SubscriptionManager {
    private Map<User, List<Subscription>> subscriptions = new HashMap<>();

    public void addSubscription(User user, String url, Subscription.ComparisonType comparisonType) {
        List<Subscription> userSubscriptions = subscriptions.get(user);
        if (userSubscriptions == null) {
            userSubscriptions = new ArrayList<>();
            subscriptions.put(user, userSubscriptions);
        }
        userSubscriptions.add(new Subscription(url, user, comparisonType));
    }

    public void removeSubscription(User user, String url) {
        List<Subscription> userSubscriptions = subscriptions.get(user);
        if (userSubscriptions != null) {
            Iterator<Subscription> iterator = userSubscriptions.iterator();
            while (iterator.hasNext()) {
                Subscription subscription = iterator.next();
                if (subscription.getUrl().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }

    public List<Subscription> getUserSubscriptions(User user) {
        return subscriptions.getOrDefault(user, new ArrayList<>());
    }

    public Set<User> getAllUsers() {
        return subscriptions.keySet();
    }
}
