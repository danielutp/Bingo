package com.sofka.service;

import com.sofka.domain.Number;
import java.util.List;
import java.util.Optional;

public interface INumberService {
    public List<Number> list();

    public Number save(Number number);

    public Number update(Long id, Number number);

    public void delete(Number number);

    public Optional<Number> findNumber(Number number);
}
