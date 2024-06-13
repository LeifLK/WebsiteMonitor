public class Subscription {
    private String url;
    private User user;
    private int lastSize;
    private String lastHtml;
    private String lastText;
    private ComparisonType preferredComparison;

    public Subscription(String url, User user, ComparisonType preferredComparison) {
        this.url = url;
        this.user = user;
        this.lastSize = 0;
        this.lastHtml = "";
        this.lastText = "";
        this.preferredComparison = preferredComparison;
    }

    public String getUrl() {
        return url;
    }

    public User getUser() {
        return user;
    }

    public int getLastSize() {
        return lastSize;
    }

    public String getLastHtml() {
        return lastHtml;
    }

    public String getLastText() {
        return lastText;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLastSize(int lastSize) {
        this.lastSize = lastSize;
    }

    public void setLastHtml(String lastHtml) {
        this.lastHtml = lastHtml;
    }

    public void setLastText(String lastText) {
        this.lastText = lastText;
    }

    public ComparisonType getPreferredComparison() {
        return preferredComparison;
    }

    public void setPreferredComparison(ComparisonType preferredComparison) {
        this.preferredComparison = preferredComparison;
    }

    public enum ComparisonType {
        SIZE, HTML, TEXT
    }
}
