import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
  private static ArrayList<Task> instances = new ArrayList<Task>();

  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;


  public Task(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
  }

  public String getDescription() {
    return mDescription;
  }
  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Task> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}
