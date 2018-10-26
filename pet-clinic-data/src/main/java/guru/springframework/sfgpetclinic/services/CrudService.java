package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    //T update(ID id, T object);

    void delete(T object);

    void deleteById(ID id);
}
