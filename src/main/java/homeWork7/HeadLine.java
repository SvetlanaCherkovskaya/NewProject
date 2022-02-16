package homeWork7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadLine {

    @JsonProperty("Text")
    String text;

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "HeadLine{" +
                "text='" + text + '\'' +
                '}';
    }
}
