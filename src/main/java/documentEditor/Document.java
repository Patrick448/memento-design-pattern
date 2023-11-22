package documentEditor;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String name;
    private String content;

    private List<String> memento = new ArrayList<String>();

    public Document (String name) {
        this.name = name;
        this.content = "";
    }

    public Document(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() { return name; }
    public String getContent() { return content; }

    public void setName(String name) { this.name = name; }
    public void setContent(String content) {
        save();
        this.content = content;
    }

    public void save() {
        this.memento.add(this.content);
    }
    public void restore(int index) {
        if (index < 0 || index > this.memento.size() - 1) {
            throw new IllegalArgumentException("Invalid index.");
        }
        this.content = this.memento.get(index);
    }
}
