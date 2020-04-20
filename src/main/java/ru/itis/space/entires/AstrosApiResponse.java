package ru.itis.space.entires;

import lombok.Data;

import java.util.List;

@Data
public class AstrosApiResponse {
    List<AstrosApiRecord> people;
}
