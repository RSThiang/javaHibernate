package DaoImplement;

import java.util.List;

public interface DaoInterface <Ecole>{
    void save(Ecole t);

    Ecole load(int id);

    void delete(long id);

    void update( Ecole t);

    List<Ecole> listeEcole();
}
