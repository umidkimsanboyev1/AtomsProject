package uz.master.demotest.services;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.demotest.mappers.Mapper;
import uz.master.demotest.validator.Validator;

/**
 * @param <R> repository
 * @param <M>
 * @param <V>
 */

public abstract class AbstractService<
        R extends JpaRepository,
        M extends Mapper,
        V extends Validator> {
    protected final R repository;
    protected final M mapper;
    protected final V validator;

    protected AbstractService(R repository, M mapper, V validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;

           }
}
