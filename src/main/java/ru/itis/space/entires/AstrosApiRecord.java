package ru.itis.space.entires;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AstrosApiRecord {
    @JsonProperty("craft")
    private String craft;
    @JsonProperty("name")
    private String name;
}
